package com.rdeconti.mercadinho.services.seller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.SaleModel;
import com.rdeconti.mercadinho.repositories.seller.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private SaleRepository saleRepository;

    private boolean existsById(Long id) {
        return saleRepository.existsById(id);
    }

    public SaleModel findById(Long id) throws ResourceNotFoundException {

        SaleModel sale = saleRepository.findById(id).orElse(null);

        if (sale==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return sale;
    }

    public List<SaleModel> findAll(int pageNumber, int rowPerPage) {

        List<SaleModel> sales = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        saleRepository.findAll(sortedByIdAsc).forEach(sales::add);

        return sales;
    }

    public SaleModel save(SaleModel sale) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(sale.getId())) {

            if (sale.getId() != null && existsById(sale.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + sale.getId() +
                        " já existe");
            }

            return saleRepository.save(sale);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(SaleModel sale)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(sale.getId())) {

            if (!existsById(sale.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + sale.getId());
            }

            saleRepository.save(sale);
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
            saleRepository.deleteById(id);
        }
    }

    public Long count() {
        return saleRepository.count();
    }
}
