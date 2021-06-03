package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.VendorModel;
import com.rdeconti.mercadinho.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Iterable<VendorModel> findAll(){
        return vendorRepository.findAll( );
    }

    public VendorModel findById(Integer vendor_ID) {
        return vendorRepository.findByCodigo( vendor_ID );
    }

    public void create(VendorModel vendor){
        vendorRepository.save( vendor );
        System.out.println("CREATION DONE WITH SUCCESS: " + vendor);
    }

    public void update(VendorModel vendor){
        vendorRepository.save( vendor );
        System.out.println("UPDATE DONE WITH SUCCESS " + vendor);
    }

    public void delete(Integer vendor_ID){
        VendorModel vendor = vendorRepository.findByCodigo( vendor_ID );
        vendorRepository.delete( vendor );
        System.out.println("DELETE DONE WITH SUCCESS " + vendor);
    }

}
