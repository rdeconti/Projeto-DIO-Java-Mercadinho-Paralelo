// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object PURCHASE
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.PurchaseModel;
import com.rdeconti.mercadinho.repositories.PurchaseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_1 = "Registro não encontrado com este ID: ";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_2 = "Registro está nulo ou vazio";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_3 = "Erro ao salvar o registro";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_4 = "Registro já existe!";

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private PurchaseRepository purchaseRepository;

    // -----------------------------------------------------------------------------------------------------------------
    // Returns whether an entity with the given id exists
    // -----------------------------------------------------------------------------------------------------------------
    private boolean existsObjectById(Long id) {
        return purchaseRepository.existsById(id);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Retrieves an entity by its id
    // -----------------------------------------------------------------------------------------------------------------
    public PurchaseModel findObjectById(Long id) throws ResourceNotFoundException {

        PurchaseModel PurchaseModel = purchaseRepository.findById(id).orElse(null);

        if (PurchaseModel==null) {

            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);

        } else {

            return PurchaseModel;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns a page of entities meeting the paging restriction provided in the pageable object
    // -----------------------------------------------------------------------------------------------------------------
    public List<PurchaseModel> findObjectList(int pageNumber, int rowPerPage) {

        List<PurchaseModel> modelArrayList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        purchaseRepository.findAll(sortedByIdAsc).forEach(modelArrayList::add);
        return modelArrayList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object
    // -----------------------------------------------------------------------------------------------------------------
    public PurchaseModel createObject(@NotNull PurchaseModel PurchaseModel) throws BadResourceException, ResourceAlreadyExistsException {

        // Treat null argument
        if (PurchaseModel.getPrice() == null) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;

        }

        // Treat object already exists
        if (PurchaseModel.getId() != null && existsObjectById(PurchaseModel.getId())) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_4);
            throw badResourceException;

        }

        // Save object
        return purchaseRepository.save(PurchaseModel);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object
    // -----------------------------------------------------------------------------------------------------------------
    public void updateObject(PurchaseModel PurchaseModel)
            throws BadResourceException, ResourceNotFoundException {

        // Treat invalid argument
        if (PurchaseModel.getPrice() != null) {

            if (!existsObjectById(PurchaseModel.getId())) {
                throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + PurchaseModel.getId());
            }

            // Save Object
            purchaseRepository.save(PurchaseModel);
        }

        else {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;
        }

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object
    // -----------------------------------------------------------------------------------------------------------------
    public void deleteObject(Long id) throws ResourceNotFoundException {

        // Treat invalid argument
        if (!existsObjectById(id)) {
            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);
        }

        else {

            // Delete object
            purchaseRepository.deleteById(id);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Count number of registers of Object
    // -----------------------------------------------------------------------------------------------------------------
    public Long countObject() {
        return purchaseRepository.count();
    }
}
