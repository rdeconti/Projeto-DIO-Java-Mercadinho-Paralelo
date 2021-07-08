package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.StoreModel;
import com.rdeconti.mercadinho.repositories.stocker.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private StoreRepository storeRepository;

    private boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }

    public StoreModel findById(Long id) throws ResourceNotFoundException {

        StoreModel store = storeRepository.findById(id).orElse(null);

        if (store==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return store;
    }

    public List<StoreModel> findAll(int pageNumber, int rowPerPage) {

        List<StoreModel> stores = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        storeRepository.findAll(sortedByIdAsc).forEach(stores::add);

        return stores;
    }

    public StoreModel save(StoreModel store) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(store.getCreated_at())) {

            if (store.getId() != null && existsById(store.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + store.getId() +
                        " já existe");
            }

            return storeRepository.save(store);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(StoreModel store)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(store.getCreated_at())) {

            if (!existsById(store.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + store.getId());
            }

            storeRepository.save(store);
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
            storeRepository.deleteById(id);
        }
    }

    public Long count() {
        return storeRepository.count();
    }
}