package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="CONTACTS")
public class ContactModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer contact_ID;
    private String contact_name;
    private String contact_address;
    private String contact_phone;
    private Integer contact_type;
    private String contact_document;
    private Boolean contact_status;
    private LocalDate contact_createdOn;
    private LocalDate  contact_changedOn;

    public ContactModel() {

    }

    public ContactModel(Integer contact_ID, String contact_name, String contact_address, String contact_phone, Integer contact_type, String contact_document, Boolean contact_status, LocalDate contact_createdOn, LocalDate contact_changedOn) {
        super( );
        this.contact_ID = contact_ID;
        this.contact_name = contact_name;
        this.contact_address = contact_address;
        this.contact_phone = contact_phone;
        this.contact_type = contact_type;
        this.contact_document = contact_document;
        this.contact_status = contact_status;
        this.contact_createdOn = contact_createdOn;
        this.contact_changedOn = contact_changedOn;
    }

    public ContactModel(String contact_name, String contact_address, String contact_phone, Integer contact_type, String contact_document, Boolean contact_status, LocalDate contact_createdOn, LocalDate contact_changedOn) {
        this.contact_name = contact_name;
        this.contact_address = contact_address;
        this.contact_phone = contact_phone;
        this.contact_type = contact_type;
        this.contact_document = contact_document;
        this.contact_status = contact_status;
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

    public LocalDate getContact_createdOn() {
        return contact_createdOn;
    }

    public void setContact_createdOn(LocalDate contact_createdOn) {
        this.contact_createdOn = contact_createdOn;
    }

    public LocalDate getContact_changedOn() {
        return contact_changedOn;
    }

    public void setContact_changedOn(LocalDate contact_changedOn) {
        this.contact_changedOn = contact_changedOn;
    }









}
