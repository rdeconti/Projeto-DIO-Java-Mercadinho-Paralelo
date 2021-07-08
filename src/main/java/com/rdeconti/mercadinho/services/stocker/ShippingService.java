package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ShippingModel;
import com.rdeconti.mercadinho.repositories.stocker.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private ShippingRepository shippingRepository;

    private boolean existsById(Long id) {
        return shippingRepository.existsById(id);
    }

    public ShippingModel findById(Long id) throws ResourceNotFoundException {

        ShippingModel shippingModel = shippingRepository.findById(id).orElse(null);

        if (shippingModel==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return shippingModel;
    }

    public List<ShippingModel> findAll(int pageNumber, int rowPerPage) {

        List<ShippingModel> stocks = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        shippingRepository.findAll(sortedByIdAsc).forEach(stocks::add);

        return stocks;
    }

    public ShippingModel save(ShippingModel stock) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(stock.getId())) {

            if (stock.getId() != null && existsById(stock.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + stock.getId() +
                        " já existe");
            }

            return shippingRepository.save(stock);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(ShippingModel stock)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(stock.getId())) {

            if (!existsById(stock.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + stock.getId());
            }

            shippingRepository.save(stock);
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
            shippingRepository.deleteById(id);
        }
    }

    public Long count() {
        return shippingRepository.count();
    }
}