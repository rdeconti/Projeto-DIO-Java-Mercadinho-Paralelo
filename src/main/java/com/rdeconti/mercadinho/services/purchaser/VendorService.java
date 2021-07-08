package com.rdeconti.mercadinho.services.purchaser;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.purchaser.VendorModel;
import com.rdeconti.mercadinho.repositories.purchaser.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private VendorRepository vendorRepository;

    private boolean existsById(Long id) {
        return vendorRepository.existsById(id);
    }

    public VendorModel findById(Long id) throws ResourceNotFoundException {

        VendorModel vendorModel = vendorRepository.findById(id).orElse(null);

        if (vendorModel==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return vendorModel;
    }

    public List<VendorModel> findAll(int pageNumber, int rowPerPage) {

        List<VendorModel> vendorModelList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        vendorRepository.findAll(sortedByIdAsc).forEach(vendorModelList::add);

        return vendorModelList;
    }

    public VendorModel save(VendorModel vendorModel) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(vendorModel.getId())) {

            return vendorRepository.save(vendorModel);

        }

        if (!ObjectUtils.isEmpty(vendorModel.getId())) {

            if (vendorModel.getId() != null && existsById(vendorModel.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + vendorModel.getId() +
                        " já existe");
            }

            return vendorRepository.save(vendorModel);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(VendorModel vendorModel)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(vendorModel.getId())) {

            if (!existsById(vendorModel.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + vendorModel.getId());
            }

            vendorRepository.save(vendorModel);
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
            vendorRepository.deleteById(id);
        }
    }

    public Long count() {
        return vendorRepository.count();
    }
}
