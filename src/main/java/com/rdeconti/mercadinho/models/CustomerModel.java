// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object CUSTOMER
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

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
@Table(name="CUSTOMERS")
public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "customer_ID", nullable = false)
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "customer_name")
    private String name;

    @Valid
    @NotEmpty()
    @Column(name = "customer_email")
    private String email;

    @Valid
    @NotEmpty()
    @Column(name = "customer_address")
    private String address;

    @Valid
    @NotEmpty()
    @Column(name = "customer_cep")
    private String cep;

    @Valid
    @NotEmpty()
    @Column(name = "customer_phone")
    private String phone;

    @Valid
    @NotEmpty()
    @Column(name = "customer_whats")
    private String whats;

    // TODO TRATAR O TIPO DE DOCUMENTO
    // @Valid
    // @NotEmpty()
    @Column(name = "customer_type")
    private String type;

    @Valid
    @NotEmpty()
    @Column(name = "customer_document")
    private String cnpj;

    @Valid
    @NotEmpty()
    @Column(name = "customer_note")
    private String note;
    
    @Column(name = "customer_status")
    private Boolean status = true;

}
