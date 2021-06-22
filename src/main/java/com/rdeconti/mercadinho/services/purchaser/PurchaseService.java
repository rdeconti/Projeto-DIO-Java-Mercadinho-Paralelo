package com.rdeconti.mercadinho.services.purchaser;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.purchaser.PurchaseModel;
import com.rdeconti.mercadinho.repositories.purchaser.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    private boolean existsById(Long id) {
        return purchaseRepository.existsById(id);
    }

    public PurchaseModel findById(Long id) throws ResourceNotFoundException {

        PurchaseModel purchase = purchaseRepository.findById(id).orElse(null);

        if (purchase==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return purchase;
    }

    public List<PurchaseModel> findAll(int pageNumber, int rowPerPage) {

        List<PurchaseModel> purchases = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        purchaseRepository.findAll(sortedByIdAsc).forEach(purchases::add);

        return purchases;
    }

    public PurchaseModel save(PurchaseModel purchase) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(purchase.getPrice())) {

            if (purchase.getId() != null && existsById(purchase.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + purchase.getId() +
                        " já existe");
            }

            return purchaseRepository.save(purchase);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazio ou nulo");
            throw badResourceException;
        }
    }

    public void update(PurchaseModel purchase)
            throws BadResourceException, ResourceNotFoundException {

        if (!StringUtils.isEmpty(purchase.getPrice())) {

            if (!existsById(purchase.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + purchase.getId());
            }

            purchaseRepository.save(purchase);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazio ou nulo");
            throw badResourceException;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {

        if (!existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else {
            purchaseRepository.deleteById(id);
        }
    }

    public Long count() {
        return purchaseRepository.count();
    }
}
