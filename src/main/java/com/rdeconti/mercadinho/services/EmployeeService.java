package com.rdeconti.mercadinho.services;

import com.rdeconti.mercadinho.models.EmployeeModel;
import com.rdeconti.mercadinho.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<EmployeeModel> findAll(){
        return employeeRepository.findAll( );
    }

    public EmployeeModel findById(Integer employee_ID) {
        return employeeRepository.findByCodigo( employee_ID );
    }

    public void create(EmployeeModel employee){
        employeeRepository.save( employee );
        System.out.println("CREATION DONE WITH SUCCESS: " + employee);
    }

    public void update(EmployeeModel employee){
        employeeRepository.save( employee );
        System.out.println("UPDATE DONE WITH SUCCESS " + employee);
    }

    public void delete(Integer employee_ID){
        EmployeeModel employee = employeeRepository.findByCodigo( employee_ID );
        employeeRepository.delete( employee );
        System.out.println("DELETE DONE WITH SUCCESS " + employee);
    }

}
