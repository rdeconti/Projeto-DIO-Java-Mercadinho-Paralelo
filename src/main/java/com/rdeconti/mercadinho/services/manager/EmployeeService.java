package com.rdeconti.mercadinho.services.manager;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.manager.EmployeeModel;
import com.rdeconti.mercadinho.repositories.manager.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }

    public EmployeeModel findById(Long id) throws ResourceNotFoundException {

        EmployeeModel employee = employeeRepository.findById(id).orElse(null);

        if (employee==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return employee;
    }

    public List<EmployeeModel> findAll(int pageNumber, int rowPerPage) {

        List<EmployeeModel> employees = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        employeeRepository.findAll(sortedByIdAsc).forEach(employees::add);

        return employees;
    }

    public EmployeeModel save(EmployeeModel employee) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(employee.getId())) {

            if (employee.getId() != null && existsById(employee.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + employee.getId() +
                        " já existe");
            }

            return employeeRepository.save(employee);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(EmployeeModel employee)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(employee.getId())) {

            if (!existsById(employee.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + employee.getId());
            }

            employeeRepository.save(employee);
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
            employeeRepository.deleteById(id);
        }
    }

    public Long count() {
        return employeeRepository.count();
    }
}
