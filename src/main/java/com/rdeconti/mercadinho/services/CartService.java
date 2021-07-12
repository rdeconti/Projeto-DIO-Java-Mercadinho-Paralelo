// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object CART
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.CartModel;
import com.rdeconti.mercadinho.repositories.CartRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_1 = "Registro não encontrado com este ID: ";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_2 = "Registro está nulo ou vazio";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_3 = "Erro ao salvar o registro";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_4 = "Registro já existe!";

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private CartRepository cartRepository;

    // -----------------------------------------------------------------------------------------------------------------
    // Returns whether an entity with the given id exists
    // -----------------------------------------------------------------------------------------------------------------
    private boolean existsObjectById(Long id) {
        return cartRepository.existsById(id);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Retrieves an entity by its id
    // -----------------------------------------------------------------------------------------------------------------
    public CartModel findObjectById(Long id) throws ResourceNotFoundException {

        CartModel CartModel = cartRepository.findById(id).orElse(null);

        if (CartModel==null) {

            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);

        } else {

            return CartModel;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns a page of entities meeting the paging restriction provided in the pageable object
    // -----------------------------------------------------------------------------------------------------------------
    public List<CartModel> findObjectList(int pageNumber, int rowPerPage) {

        List<CartModel> modelArrayList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        cartRepository.findAll(sortedByIdAsc).forEach(modelArrayList::add);
        return modelArrayList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object
    // -----------------------------------------------------------------------------------------------------------------
    public CartModel createObject(@NotNull CartModel CartModel) throws BadResourceException, ResourceAlreadyExistsException {

        // Treat null argument
        if (CartModel.getPrice() == null) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;

        }

        // Treat object already exists
        if (CartModel.getId() != null && existsObjectById(CartModel.getId())) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_4);
            throw badResourceException;

        }

        // Save object
        return cartRepository.save(CartModel);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object
    // -----------------------------------------------------------------------------------------------------------------
    public void updateObject(CartModel CartModel)
            throws BadResourceException, ResourceNotFoundException {

        // Treat invalid argument
        if (CartModel.getPrice() != null) {

            if (!existsObjectById(CartModel.getId())) {
                throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + CartModel.getId());
            }

            // Save Object
            cartRepository.save(CartModel);
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
            cartRepository.deleteById(id);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Count number of registers of Object
    // -----------------------------------------------------------------------------------------------------------------
    public Long countObject() {
        return cartRepository.count();
    }
}
