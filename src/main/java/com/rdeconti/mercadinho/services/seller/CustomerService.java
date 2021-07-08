package com.rdeconti.mercadinho.services.seller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.CustomerModel;
import com.rdeconti.mercadinho.repositories.seller.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private CustomerRepository customerRepository;

    private boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    public CustomerModel findById(Long id) throws ResourceNotFoundException {

        CustomerModel customer = customerRepository.findById(id).orElse(null);

        if (customer==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return customer;
    }

    public List<CustomerModel> findAll(int pageNumber, int rowPerPage) {

        List<CustomerModel> customers = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        customerRepository.findAll(sortedByIdAsc).forEach(customers::add);

        return customers;
    }

    public CustomerModel save(CustomerModel customer) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(customer.getCreated_at())) {

            if (customer.getId() != null && existsById(customer.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + customer.getId() +
                        " já existe");
            }

            return customerRepository.save(customer);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(CustomerModel customer)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(customer.getCreated_at())) {

            if (!existsById(customer.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + customer.getId());
            }

            customerRepository.save(customer);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar informação");
            badResourceException.addErrorMessage("Informação não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {

        if (!existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else {
            customerRepository.deleteById(id);
        }
    }

    public Long count() {
        return customerRepository.count();
    }
}
