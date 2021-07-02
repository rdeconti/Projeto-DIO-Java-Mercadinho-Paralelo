package com.rdeconti.mercadinho.services.seller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.CartModel;
import com.rdeconti.mercadinho.repositories.seller.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    private boolean existsById(Long id) {
        return cartRepository.existsById(id);
    }

    public CartModel findById(Long id) throws ResourceNotFoundException {

        CartModel cart = cartRepository.findById(id).orElse(null);

        if (cart==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return cart;
    }

    public List<CartModel> findAll(int pageNumber, int rowPerPage) {

        List<CartModel> carts = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        cartRepository.findAll(sortedByIdAsc).forEach(carts::add);

        return carts;
    }

    public CartModel save(CartModel cart) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(cart.getId())) {

            if (cart.getId() != null && existsById(cart.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + cart.getId() +
                        " já existe");
            }

            return cartRepository.save(cart);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(CartModel cart)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(cart.getId())) {

            if (!existsById(cart.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + cart.getId());
            }

            cartRepository.save(cart);
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
            cartRepository.deleteById(id);
        }
    }

    public Long count() {
        return cartRepository.count();
    }
}
