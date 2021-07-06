package com.rdeconti.mercadinho.models.manager;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="CONTACTS")
public class ContactModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "contact_ID")
    private Long id;

    @NotEmpty(message = "*Por favor informar o nome do contato!")
    @Column(name = "contact_name")
    private String name;

    @Email(message = "*Por favor informar um e-mail válido!")
    @NotEmpty(message = "*Please provide an user_email")
    @Column(name = "contact_email")
    private String email;

    @NotEmpty(message = "*Por favor informar o país!")
    @Column(name = "contact_country")
    private String country;

    @NotEmpty(message = "*Por favor informar o estado!")
    @Column(name = "contact_state")
    private String state;

    @NotEmpty(message = "*Por favor informar a cidade!")
    @Column(name = "contact_city")
    private String city;

    @NotEmpty(message = "*Por favor informar o bairro!")
    @Column(name = "contact_district")
    private String district;

    @NotEmpty(message = "*Por favor informar o endereço!")
    @Column(name = "contact_address")
    private String address;

    @NotEmpty(message = "*Por favor informar o número")
    @Column(name = "contact_number")
    private String number;

    @NotEmpty(message = "*Por favor informar o CEP!")
    @Column(name = "contact_cep")
    private String cep;

    @NotEmpty(message = "*Por favor informar o complemento!")
    @Column(name = "contact_complement")
    private String complement;

    @NotEmpty(message = "*Por favor informar o telefone 1!")
    @Column(name = "contact_phone_1")
    private String phone_1;

    @NotEmpty(message = "*Por favor informar o telefone 2!")
    @Column(name = "contact_phone_2")
    private String phone_2;

    @NotEmpty(message = "*Por favor informar o whatsApp")
    @Column(name = "contact_whats_app")
    private String whatsapp;

    @NotEmpty(message = "*Por favor informar o tipo de documento")
    @Column(name = "contact_type")
    private String type;

    @NotEmpty(message = "*Por favor informar o número de documento")
    @Column(name = "contact_document")
    private String document;

    @NotEmpty(message = "*Por favor informar o Site")
    @Column(name = "contact_site")
    private String site;

    @NotEmpty(message = "*Por favor informar o Facebook")
    @Column(name = "contact_facebook")
    private String facebook;

    @NotEmpty(message = "*Por favor informar o Instagram")
    @Column(name = "contact_instagram")
    private String instagram;

    @NotEmpty(message = "*Por favor informar o Linkedin")
    @Column(name = "contact_linkedin")
    private String linkedin;

    @NotEmpty(message = "*Por favor informar o Youtube")
    @Column(name = "contact_youtube")
    private String youtube;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "contact_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "contact_created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "contact_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "contact_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "contact_changed_by")
    private String changed_by;

}
