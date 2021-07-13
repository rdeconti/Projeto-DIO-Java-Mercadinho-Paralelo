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
    @Column(name = "employee_ID", nullable = false)
    private Long id;

    @Column(name = "employee_name")
    @Valid
    @NotEmpty()
    private String name;

    @Column(name = "employee_email")
    @Valid
    @NotEmpty()
    private String email;

    @Column(name = "employee_address")
    @Valid
    @NotEmpty()
    private String address;

    @Column(name = "employee_cep")
    @Pattern(regexp="\\d{5}-\\d{3}")
    @Valid
    @NotEmpty()
    private String cep;

    @Column(name = "employee_phone")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @Valid
    @NotEmpty()
    private String phone;

    @Column(name = "employee_whats")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @Valid
    @NotEmpty()
    private String whats;

    @Column(name = "employee_document")
    @CPF(message = "*Por favor informe CPF válido")
    @Valid
    @NotEmpty()
    private String cpf;

    @Column(name = "employee_note")
    @Valid
    @NotEmpty()
    private String note;

    @Column(name = "employee_status")
    private Boolean status = true;

}

