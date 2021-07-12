// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object AGENDA
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="AGENDAS")
public class AgendaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "agenda_ID")
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_name")
    private String name;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_phone")
    private String phone;

    @Valid
    @NotEmpty()
    @Email(message = "Email Address")
    @Column(name = "agenda_email")
    private String email;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_address1")
    private String address1;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_address2")
    private String address2;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_address3")
    private String address3;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_postal")
    private String postalCode;

    @Valid
    @NotEmpty()
    @Column(name = "agenda_note", length = 4000)
    private String note;
}
