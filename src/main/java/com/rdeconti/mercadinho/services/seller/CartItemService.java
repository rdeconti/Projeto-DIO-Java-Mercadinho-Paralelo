package com.rdeconti.mercadinho.services.seller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.CartItemModel;
import com.rdeconti.mercadinho.repositories.seller.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    private boolean existsById(Long id) {
        return cartItemRepository.existsById(id);
    }

    public CartItemModel findById(Long id) throws ResourceNotFoundException {

        CartItemModel cartItem = cartItemRepository.findById(id).orElse(null);

        if (cartItem==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return cartItem;
    }

    public List<CartItemModel> findAll(int pageNumber, int rowPerPage) {

        List<CartItemModel> cartItems = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        cartItemRepository.findAll(sortedByIdAsc).forEach(cartItems::add);

        return cartItems;
    }

    public CartItemModel save(CartItemModel cartItem) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(cartItem.getId())) {

            if (cartItem.getId() != null && existsById(cartItem.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + cartItem.getId() +
                        " já existe");
            }

            return cartItemRepository.save(cartItem);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(CartItemModel cartItem)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(cartItem.getId())) {

            if (!existsById(cartItem.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + cartItem.getId());
            }

            cartItemRepository.save(cartItem);
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
            cartItemRepository.deleteById(id);
        }
    }

    public Long count() {
        return cartItemRepository.count();
    }
}
