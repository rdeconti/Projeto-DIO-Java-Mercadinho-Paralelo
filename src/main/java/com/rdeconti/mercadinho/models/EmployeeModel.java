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
    @Size(min = 2, max = 100, message = "*O nome deve ter deve ter de 2 até 100 caracteres")
    @NotEmpty(message = "*Por favor informe o nome do empregado")
    private String name;

    @Column(name = "employee_email")
    @Email(message = "*Por favor informe e-mail válido")
    @NotEmpty(message = "*Por favor informe o e-mail do empregado")
    private String email;

    @Column(name = "employee_address")
    @Size(min = 2, max = 1000, message = "*O nome deve ter deve ter de 2 até 1000 caracteres")
    @NotEmpty(message = "*Por favor informe o endereço do empregado")
    private String address;

    @Column(name = "employee_cep")
    @Pattern(regexp="\\d{5}-\\d{3}")
    @NotEmpty(message = "*Por favor informe o CEP do empregado")
    private String cep;

    @Column(name = "employee_phone")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o telefone do empregado")
    private String phone;

    @Column(name = "employee_whats")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o whatsApp do empregado")
    private String whats;

    @Column(name = "employee_document")
    @CPF(message = "*Por favor informe CPF válido")
    @NotEmpty(message = "*Por favor informe o CPF do empregado")
    private String cpf;

    @Column(name = "employee_note")
    @NotEmpty(message = "*Por favor informe observações do empregado")
    private String note;

    @Column(name = "employee_status")
    private Boolean status = true;

}

