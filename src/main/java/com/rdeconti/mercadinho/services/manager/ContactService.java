package com.rdeconti.mercadinho.services.manager;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.manager.ContactModel;
import com.rdeconti.mercadinho.repositories.manager.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private boolean existsById(Long id) {
        return contactRepository.existsById(id);
    }

    public ContactModel findById(Long id) throws ResourceNotFoundException {

        ContactModel contactModel = contactRepository.findById(id).orElse(null);

        if (contactModel==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return contactModel;
    }

    public List<ContactModel> findAll(int pageNumber, int rowPerPage) {

        List<ContactModel> contactModelList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        contactRepository.findAll(sortedByIdAsc).forEach(contactModelList::add);

        return contactModelList;
    }

    public ContactModel save(ContactModel contact) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(contact.getId())) {

            if (contact.getId() != null && existsById(contact.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + contact.getId() +
                        " já existe");
            }

            return contactRepository.save(contact);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(ContactModel contact)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(contact.getId())) {

            if (!existsById(contact.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + contact.getId());
            }

            contactRepository.save(contact);
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
            contactRepository.deleteById(id);
        }
    }

    public Long count() {
        return contactRepository.count();
    }
}
