package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CONTACTS")
public class ContactModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer contact_ID;

    @NotEmpty(message = "*Por favor informar o nome do contato")
    private String contact_name;

    @NotEmpty(message = "*Por favor informar o endereço do contato")
    private String contact_address;

    @Pattern(regexp="(^$|[0-9]{10})")
    @NotEmpty(message = "*Por favor informar o telefone do contato")
    private String contact_phone;

    // TODO CHECK BEAN VALIDATION TO CPF OR CNPJ
    @NotEmpty(message = "*Por favor informar o tipo do contato")
    private Integer contact_type;

    @NotEmpty(message = "*Por favor informar o documento do contato")
    private String contact_document;

    @Column(name = "contact_status", length = 1, nullable = false)
    private Boolean contact_status;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an user_email")
    private String contact_email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "contact_createdOn", nullable = false)
    private java.util.Date contact_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "contact_changedOn", nullable = false)
    private java.util.Date contact_changedOn;

    public ContactModel() {

    }

    public ContactModel(Integer contact_ID, String contact_name, String contact_address, String contact_phone, Integer contact_type, String contact_document, Boolean contact_status, String contact_email, Date contact_createdOn, Date contact_changedOn) {
        super( );
        this.contact_ID = contact_ID;
        this.contact_name = contact_name;
        this.contact_address = contact_address;
        this.contact_phone = contact_phone;
        this.contact_type = contact_type;
        this.contact_document = contact_document;
        this.contact_status = contact_status;
        this.contact_email = contact_email;
        this.contact_createdOn = contact_createdOn;
        this.contact_changedOn = contact_changedOn;
    }

    public ContactModel(String contact_name, String contact_address, String contact_phone, Integer contact_type, String contact_document, Boolean contact_status, String contact_email, Date contact_createdOn, Date contact_changedOn) {
        this.contact_name = contact_name;
        this.contact_address = contact_address;
        this.contact_phone = contact_phone;
        this.contact_type = contact_type;
        this.contact_document = contact_document;
        this.contact_status = contact_status;
        this.contact_email = contact_email;
        this.contact_createdOn = contact_createdOn;
        this.contact_changedOn = contact_changedOn;
    }

    public Integer getContact_ID() {
        return contact_ID;
    }

    public void setContact_ID(Integer contact_ID) {
        this.contact_ID = contact_ID;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public Integer getContact_type() {
        return contact_type;
    }

    public void setContact_type(Integer contact_type) {
        this.contact_type = contact_type;
    }

    public String getContact_document() {
        return contact_document;
    }

    public void setContact_document(String contact_document) {
        this.contact_document = contact_document;
    }

    public Boolean getContact_status() {
        return contact_status;
    }

    public void setContact_status(Boolean contact_status) {
        this.contact_status = contact_status;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public Date getContact_createdOn() {
        return contact_createdOn;
    }

    public void setContact_createdOn(Date contact_createdOn) {
        this.contact_createdOn = contact_createdOn;
    }

    public Date getContact_changedOn() {
        return contact_changedOn;
    }

    public void setContact_changedOn(Date contact_changedOn) {
        this.contact_changedOn = contact_changedOn;
    }









}
