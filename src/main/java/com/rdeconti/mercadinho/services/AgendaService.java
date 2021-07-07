// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object AGENDA
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.AgendaModel;
import com.rdeconti.mercadinho.repositories.AgendaRepository;
import org.jetbrains.annotations.NotNull;
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

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AgendaRepository agendaRepository;

    // -----------------------------------------------------------------------------------------------------------------
    // Returns whether an entity with the given id exists
    // -----------------------------------------------------------------------------------------------------------------
    private boolean existsObjectById(Long id) {
        return agendaRepository.existsById(id);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Retrieves an entity by its id
    // -----------------------------------------------------------------------------------------------------------------
    public AgendaModel findObjectById(Long id) throws ResourceNotFoundException {

        AgendaModel agendaModel = agendaRepository.findById(id).orElse(null);

        if (agendaModel==null) {

            throw new ResourceNotFoundException("Registro não encontrado com este ID: " + id);

        } else {

            return agendaModel;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns a page of entities meeting the paging restriction provided in the pageable object
    // -----------------------------------------------------------------------------------------------------------------
    public List<AgendaModel> findObjectList(int pageNumber, int rowPerPage) {

        List<AgendaModel> modelArrayList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        agendaRepository.findAll(sortedByIdAsc).forEach(modelArrayList::add);
        return modelArrayList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object
    // -----------------------------------------------------------------------------------------------------------------
    public AgendaModel createObject(@NotNull AgendaModel agendaModel) throws BadResourceException, ResourceAlreadyExistsException {

        if (agendaModel.getName() == null) {

            BadResourceException badResourceException = new BadResourceException("Erro ao salvar o registro");
            badResourceException.addErrorMessage("Registro está nulo ou vazio");
            throw badResourceException;

        }

        if (agendaModel.getId() != null && existsObjectById(agendaModel.getId())) {

            BadResourceException badResourceException = new BadResourceException("Erro ao salvar o registro");
            badResourceException.addErrorMessage("Registro já existe!");
            throw badResourceException;

        }

        return agendaRepository.save(agendaModel);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object
    // -----------------------------------------------------------------------------------------------------------------
    public void updateObject(AgendaModel agendaModel)
            throws BadResourceException, ResourceNotFoundException {

        if (!StringUtils.isEmpty(agendaModel.getName())) {

            if (!existsObjectById(agendaModel.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com ID: " + agendaModel.getId());
            }

            agendaRepository.save(agendaModel);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Erro ao salvar o registro");
            badResourceException.addErrorMessage("Registro está nulo ou vazio");
            throw badResourceException;
        }

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object
    // -----------------------------------------------------------------------------------------------------------------
    public void deleteObject(Long id) throws ResourceNotFoundException {

        if (!existsObjectById(id)) {
            throw new ResourceNotFoundException("Cannot find contact with id: " + id);
        }

        else {
            agendaRepository.deleteById(id);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Count number of registers of Object
    // -----------------------------------------------------------------------------------------------------------------
    public Long countObject() {
        return agendaRepository.count();
    }
}
