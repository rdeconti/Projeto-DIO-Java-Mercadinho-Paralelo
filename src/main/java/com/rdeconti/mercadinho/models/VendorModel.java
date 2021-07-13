// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object VENDOR
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
@Table(name="VENDORS")
public class VendorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "vendor_ID", nullable = false)
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_name")
    private String name;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_email")
    private String email;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_address")
    private String address;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_cep")
    private String cep;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_phone")
    private String phone;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_whats")
    private String whats;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_document")
    private String cnpj;

    @Valid
    @NotEmpty()
    @Column(name = "vendor_note")
    private String note;

    @Column(name = "vendor_status")
    private Boolean status = true;

}
