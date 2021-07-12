// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Service level that execute business rules object USER
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.UserModel;
import com.rdeconti.mercadinho.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // TODO REVIEW DOCUMENTATION

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_1 = "Registro não encontrado com este ID: ";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_2 = "Registro está nulo ou vazio";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_3 = "Erro ao salvar o registro";
    private static final String ATTRIBUTE_VALUE_ERROR_MESSAGE_4 = "Registro já existe!";

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private UserRepository userRepository;

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Find user by email
    // -----------------------------------------------------------------------------------------------------------------
    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Find user by name
    // -----------------------------------------------------------------------------------------------------------------
    public UserModel findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Find user by role
    // -----------------------------------------------------------------------------------------------------------------
    public UserModel findRoleByUserName(String userRole) {
        return userRepository.findRoleByUserName(userRole);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Save user
    // -----------------------------------------------------------------------------------------------------------------
    public void saveUser(UserModel userModel) {

        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        userModel.setStatus(true);
        
        userRepository.save(userModel);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns whether an entity with the given id exists
    // -----------------------------------------------------------------------------------------------------------------
    private boolean existsObjectById(Long id) {
        return userRepository.existsById(id);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Retrieves an entity by its id
    // -----------------------------------------------------------------------------------------------------------------
    public UserModel findObjectById(Long id) throws ResourceNotFoundException {

        UserModel userModel = userRepository.findById(id).orElse(null);

        if (userModel==null) {

            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);

        } else {

            return userModel;

        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Returns a page of entities meeting the paging restriction provided in the pageable object
    // -----------------------------------------------------------------------------------------------------------------
    public List<UserModel> findObjectList(int pageNumber, int rowPerPage) {

        List<UserModel> modelArrayList = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        userRepository.findAll(sortedByIdAsc).forEach(modelArrayList::add);
        return modelArrayList;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Create object
    // -----------------------------------------------------------------------------------------------------------------
    public UserModel createObject(@NotNull UserModel userModel) throws BadResourceException, ResourceAlreadyExistsException {

        // Treat null argument
        if (userModel.getName() == null) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;

        }

        // Treat object already exists
        if (userModel.getId() != null && existsObjectById(userModel.getId())) {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_4);
            throw badResourceException;

        }

        // Save object
        return userRepository.save(userModel);

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Update object
    // -----------------------------------------------------------------------------------------------------------------
    public void updateObject(UserModel userModel)
            throws BadResourceException, ResourceNotFoundException {

        // Treat invalid argument
        if (userModel.getName() != null) {

            if (!existsObjectById(userModel.getId())) {
                throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + userModel.getId());
            }

            // Save Object
            userRepository.save(userModel);
        }

        else {

            BadResourceException badResourceException = new BadResourceException(ATTRIBUTE_VALUE_ERROR_MESSAGE_3);
            badResourceException.addErrorMessage(ATTRIBUTE_VALUE_ERROR_MESSAGE_2);
            throw badResourceException;
        }

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Delete object
    // -----------------------------------------------------------------------------------------------------------------
    public void deleteObject(Long id) throws ResourceNotFoundException {

        // Treat invalid argument
        if (!existsObjectById(id)) {
            throw new ResourceNotFoundException(ATTRIBUTE_VALUE_ERROR_MESSAGE_1 + id);
        }

        else {

            // Delete object
            userRepository.deleteById(id);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Count number of registers of Object
    // -----------------------------------------------------------------------------------------------------------------
    public Long countObject() {
        return userRepository.count();
    }

}