// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object STOCK
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.StockModel;
import com.rdeconti.mercadinho.repositories.StockRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_1 = "Registro não encontrado com este ID: ";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_2 = "Registro está nulo ou vazio";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_3 = "Erro ao salvar o registro";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_4 = "Registro já existe!";

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private StockRepository stockRepository;

    // -----------------------------------------------------------------------------------------------------------------
    // Returns whether an entity with the given id exists
    // -----------------------------------------------------------------------------------------------------------------
    private boolean existsObjectById(Long id) {
        return stockRepository.existsById(id);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Retrieves an entity by its id
    // -----------------------------------------------------------------------------------------------------------------
    public StockModel findObjectById(Long id) throws ResourceNotFoundException {

        StockModel StockModel = stockRepository.findById(id).orElse(null);

        if (StockModel==null) {

            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);

        } else {

            return StockModel;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns a page of entities meeting the paging restriction provided in the pageable object
    // -----------------------------------------------------------------------------------------------------------------
    public List<StockModel> findObjectList(int pageNumber, int rowPerPage) {

        List<StockModel> modelArrayList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        stockRepository.findAll(sortedByIdAsc).forEach(modelArrayList::add);
        return modelArrayList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object
    // -----------------------------------------------------------------------------------------------------------------
    public StockModel createObject(@NotNull StockModel StockModel) throws BadResourceException, ResourceAlreadyExistsException {

        // Treat null argument
        if (StockModel.getAmount() == null) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;

        }

        // Treat object already exists
        if (StockModel.getId() != null && existsObjectById(StockModel.getId())) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_4);
            throw badResourceException;

        }

        // Save object
        return stockRepository.save(StockModel);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object
    // -----------------------------------------------------------------------------------------------------------------
    public void updateObject(StockModel StockModel)
            throws BadResourceException, ResourceNotFoundException {

        // Treat invalid argument
        if (StockModel.getAmount() != null) {

            if (!existsObjectById(StockModel.getId())) {
                throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + StockModel.getId());
            }

            // Save Object
            stockRepository.save(StockModel);
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
            stockRepository.deleteById(id);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Count number of registers of Object
    // -----------------------------------------------------------------------------------------------------------------
    public Long countObject() {
        return stockRepository.count();
    }
}