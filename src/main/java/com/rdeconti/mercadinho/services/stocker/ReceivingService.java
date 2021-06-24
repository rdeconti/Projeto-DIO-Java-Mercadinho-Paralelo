package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ReceivingModel;
import com.rdeconti.mercadinho.repositories.stocker.ReceivingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceivingService {

    @Autowired
    private ReceivingRepository receivingRepository;

    private boolean existsById(Long id) {
        return receivingRepository.existsById(id);
    }

    public ReceivingModel findById(Long id) throws ResourceNotFoundException {

        ReceivingModel receiving = receivingRepository.findById(id).orElse(null);

        if (receiving==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return receiving;
    }

    public List<ReceivingModel> findAll(int pageNumber, int rowPerPage) {

        List<ReceivingModel> receivings = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        receivingRepository.findAll(sortedByIdAsc).forEach(receivings::add);

        return receivings;
    }

    public ReceivingModel save(ReceivingModel receiving) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(receiving.getId())) {

            if (receiving.getId() != null && existsById(receiving.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + receiving.getId() +
                        " já existe");
            }

            return receivingRepository.save(receiving);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(ReceivingModel receiving)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(receiving.getId())) {

            if (!existsById(receiving.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + receiving.getId());
            }

            receivingRepository.save(receiving);
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
            receivingRepository.deleteById(id);
        }
    }

    public Long count() {
        return receivingRepository.count();
    }
}