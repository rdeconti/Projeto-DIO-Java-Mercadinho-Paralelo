// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object AGENDA
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="AGENDAS")
public class AgendaModel implements Serializable {

    // TODO CORRIGIR TODOS OS LOMBOKS
    // TODO UTILIZAR LOCALDATETIME E BIGDECIMAL
    // TODO TIRAR A SENHA DO BANCO DE DADOS
    // TODO CRIAR BANCO DE DADOS AUTOMATICAMENTE
    // UTILIZAR O HttpStatus no controller para montar mensagens
    // UTILIZAR @AUDITTED PARA AUDITAR TABELAS

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "agenda_ID")
    private Long id;

    @Valid
    @NotEmpty(message = "*Por favor informar o nome")
    @Size(max = 100)
    @Column(name = "agenda_name")
    private String name;

    @Valid
    @NotEmpty(message = "*Por favor informar o telefone")
    @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$")
    @Size(max = 25)
    @Column(name = "agenda_phone")
    private String phone;

    @Valid
    @NotEmpty(message = "*Por favor informar o e-mail")
    @Email(message = "Email Address")
    @Size(max = 100)
    @Column(name = "agenda_email")
    private String email;

    @Valid
    @NotEmpty(message = "*Por favor informar o endereço")
    @Size(max = 50)
    @Column(name = "agenda_address1")
    private String address1;

    @Valid
    @NotEmpty(message = "*Por favor informar o endereço")
    @Size(max = 50)
    @Column(name = "agenda_address2")
    private String address2;

    @Valid
    @NotEmpty(message = "*Por favor informar o endereço")
    @Size(max = 50)
    @Column(name = "agenda_address3")
    private String address3;

    @Valid
    @NotEmpty(message = "*Por favor informar o código postal")
    @Size(max = 20)
    @Column(name = "agenda_postal")
    private String postalCode;

    @Valid
    @NotEmpty(message = "*Por favor informar as observações")
    @Column(name = "agenda_note", length = 4000)
    private String note;
}
