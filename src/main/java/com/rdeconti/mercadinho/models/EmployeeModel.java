// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object EMPLOYEE
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="EMPLOYEES")
public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "employee_ID")
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "employee_name")
    private String name;

    @Valid
    @NotEmpty()
    @Column(name = "employee_email")
    private String email;

    @Valid
    @NotEmpty()
    @Column(name = "employee_address")
    private String address;

    @Valid
    @NotEmpty()
    @Column(name = "employee_cep")
    private String cep;

    @Valid
    @NotEmpty()
    @Column(name = "employee_phone")
    private String phone;

    @Valid
    @NotEmpty()
    @Column(name = "employee_whats")
    private String whats;

    @Valid
    @NotEmpty()
    @Column(name = "employee_document")
    private String cpf;

    @Valid
    @NotEmpty()
    @Column(name = "employee_note")
    private String note;

    @Column(name = "employee_status")
    private Boolean status = true;

}

