package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    private boolean existsById(Long id) {
        return agendaRepository.existsById(id);
    }

    public AgendaModel findById(Long id) throws ResourceNotFoundException {
        AgendaModel agendaModel = agendaRepository.findById(id).orElse(null);
        if (agendaModel ==null) {
            throw new ResourceNotFoundException("Cannot find Contact with id: " + id);
        }
        else return agendaModel;
    }

    public List<AgendaModel> findAll(int pageNumber, int rowPerPage) {
        List<AgendaModel> agendaModels = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        agendaRepository.findAll(sortedByIdAsc).forEach(agendaModels::add);
        return agendaModels;
    }

    public AgendaModel save(AgendaModel agendaModel) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(agendaModel.getName())) {
            if (agendaModel.getId() != null && existsById(agendaModel.getId())) {
                throw new ResourceAlreadyExistsException("Contact with id: " + agendaModel.getId() +
                        " already exists");
            }
            return agendaRepository.save(agendaModel);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save contact");
            exc.addErrorMessage("Contact is null or empty");
            throw exc;
        }
    }

    public void update(AgendaModel agendaModel)
            throws BadResourceException, ResourceNotFoundException {
        if (!StringUtils.isEmpty(agendaModel.getName())) {
            if (!existsById(agendaModel.getId())) {
                throw new ResourceNotFoundException("Cannot find Contact with id: " + agendaModel.getId());
            }
            agendaRepository.save(agendaModel);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save contact");
            exc.addErrorMessage("Contact is null or empty");
            throw exc;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("Cannot find contact with id: " + id);
        }
        else {
            agendaRepository.deleteById(id);
        }
    }

    public Long count() {
        return agendaRepository.count();
    }
}
