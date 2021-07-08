package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.MovementModel;
import com.rdeconti.mercadinho.repositories.stocker.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovementService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private MovementRepository movementRepository;

    private boolean existsById(Long id) {
        return movementRepository.existsById(id);
    }

    public MovementModel findById(Long id) throws ResourceNotFoundException {

        MovementModel movement = movementRepository.findById(id).orElse(null);

        if (movement==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return movement;
    }

    public List<MovementModel> findAll(int pageNumber, int rowPerPage) {

        List<MovementModel> movements = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        movementRepository.findAll(sortedByIdAsc).forEach(movements::add);

        return movements;
    }

    public MovementModel save(MovementModel movement) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(movement.getId())) {

            if (movement.getId() != null && existsById(movement.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + movement.getId() +
                        " já existe");
            }

            return movementRepository.save(movement);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(MovementModel movement)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(movement.getId())) {

            if (!existsById(movement.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + movement.getId());
            }

            movementRepository.save(movement);
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
            movementRepository.deleteById(id);
        }
    }

    public Long count() {
        return movementRepository.count();
    }
}
