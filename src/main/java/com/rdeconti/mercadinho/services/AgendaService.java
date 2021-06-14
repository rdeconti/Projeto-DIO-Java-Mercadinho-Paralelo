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
    private AgendaRepository contactRepository;

    private boolean existsById(Long id) {
        return contactRepository.existsById(id);
    }

    public AgendaModel findById(Long id) throws ResourceNotFoundException {
        AgendaModel contact = contactRepository.findById(id).orElse(null);
        if (contact==null) {
            throw new ResourceNotFoundException("Cannot find AgendaModel with id: " + id);
        }
        else return contact;
    }

    public List<AgendaModel> findAll(int pageNumber, int rowPerPage) {
        List<AgendaModel> contacts = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        contactRepository.findAll(sortedByIdAsc).forEach(contacts::add);
        return contacts;
    }

    public AgendaModel save(AgendaModel contact) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(contact.getName())) {
            if (contact.getId() != null && existsById(contact.getId())) {
                throw new ResourceAlreadyExistsException("AgendaModel with id: " + contact.getId() +
                        " already exists");
            }
            return contactRepository.save(contact);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save contact");
            exc.addErrorMessage("AgendaModel is null or empty");
            throw exc;
        }
    }

    public void update(AgendaModel contact)
            throws BadResourceException, ResourceNotFoundException {
        if (!StringUtils.isEmpty(contact.getName())) {
            if (!existsById(contact.getId())) {
                throw new ResourceNotFoundException("Cannot find AgendaModel with id: " + contact.getId());
            }
            contactRepository.save(contact);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save contact");
            exc.addErrorMessage("AgendaModel is null or empty");
            throw exc;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("Cannot find contact with id: " + id);
        }
        else {
            contactRepository.deleteById(id);
        }
    }

    public Long count() {
        return contactRepository.count();
    }
}
