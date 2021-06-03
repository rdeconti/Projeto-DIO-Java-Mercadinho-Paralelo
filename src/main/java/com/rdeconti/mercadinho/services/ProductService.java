package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.ProductModel;
import com.rdeconti.mercadinho.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductModel> findAll(){
        return productRepository.findAll( );
    }

    public ProductModel findById(Integer product_ID) {
        return productRepository.findByCodigo( product_ID );
    }

    public void create(ProductModel product){
        productRepository.save( product );
        System.out.println("CREATION DONE WITH SUCCESS: " + product);
    }

    public void update(ProductModel product){
        productRepository.save( product );
        System.out.println("UPDATE DONE WITH SUCCESS " + product);
    }

    public void delete(Integer product_ID){
        ProductModel product = productRepository.findByCodigo( product_ID );
        productRepository.delete( product );
        System.out.println("DELETE DONE WITH SUCCESS " + product);
    }

}
