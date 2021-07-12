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

    @Column(name = "customer_name")
    @Size(min = 2, max = 100, message = "*O nome deve ter deve ter de 2 até 100 caracteres")
    @NotEmpty(message = "*Por favor informe o nome do cliente")
    private String name;

    @Column(name = "customer_email")
    @Email(message = "*Por favor informe e-mail válido")
    @NotEmpty(message = "*Por favor informe o e-mail do cliente")
    private String email;

    @Column(name = "customer_address")
    @Size(min = 2, max = 1000, message = "*O nome deve ter deve ter de 2 até 1000 caracteres")
    @NotEmpty(message = "*Por favor informe o endereço do cliente")
    private String address;

    @Column(name = "customer_cep")
    @Pattern(regexp="\\d{5}-\\d{3}")
    @NotEmpty(message = "*Por favor informe o CEP do cliente")
    private String cep;

    @Column(name = "customer_phone")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o telefone do cliente")
    private String phone;

    @Column(name = "customer_whats")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o whatsApp do cliente")
    private String whats;

    // TODO TRATAR O TIPO DE DOCUMENTO
    @Column(name = "customer_type")
    @NotEmpty(message = "*Por favor informe o tipo de documento")
    private String type;

    @Column(name = "customer_document")
    @CNPJ(message = "*Por favor informe CNPJ válido")
    @NotEmpty(message = "*Por favor informe o CNPJ do cliente")
    private String cnpj;

    @Column(name = "customer_note")
    @NotEmpty(message = "*Por favor informe observações do cliente")
    private String note;
    
    @Column(name = "customer_status")
    private Boolean status = true;

}
