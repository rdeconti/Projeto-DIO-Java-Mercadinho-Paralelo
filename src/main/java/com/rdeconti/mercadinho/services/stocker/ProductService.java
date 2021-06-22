package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ProductModel;
import com.rdeconti.mercadinho.repositories.stocker.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    public ProductModel findById(Long id) throws ResourceNotFoundException {

        ProductModel product = productRepository.findById(id).orElse(null);

        if (product==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return product;
    }

    public List<ProductModel> findAll(int pageNumber, int rowPerPage) {

        List<ProductModel> products = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        productRepository.findAll(sortedByIdAsc).forEach(products::add);

        return products;
    }

    public ProductModel save(ProductModel product) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(product.getId())) {

            if (product.getId() != null && existsById(product.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + product.getId() +
                        " já existe");
            }

            return productRepository.save(product);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(ProductModel product)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(product.getId())) {

            if (!existsById(product.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + product.getId());
            }

            productRepository.save(product);
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
            productRepository.deleteById(id);
        }
    }

    public Long count() {
        return productRepository.count();
    }
}
