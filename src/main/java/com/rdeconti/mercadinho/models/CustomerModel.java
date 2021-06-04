package com.rdeconti.mercadinho.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="CUSTOMERS")
public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer customer_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_ID")
    private Integer customer_contactID;

    // TODO CREATE BUTTONS AND ROUTINE TO CHANGE STATUS IN ALL OBJECTS
    @Column(name = "customer_status", length = 1, nullable = false)
    private Boolean customer_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "customer_createdOn", nullable = false)
    private java.util.Date customer_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "customer_changedOn", nullable = false)
    private java.util.Date customer_changedOn;

    public CustomerModel() {

    }

    public CustomerModel(Integer customer_ID, Integer customer_contactID, Boolean customer_status, Date customer_createdOn, Date customer_changedOn) {
        super( );
        this.customer_ID = customer_ID;
        this.customer_contactID = customer_contactID;
        this.customer_status = customer_status;
        this.customer_createdOn = customer_createdOn;
        this.customer_changedOn = customer_changedOn;
    }

    public CustomerModel(Integer customer_contactID, Boolean customer_status, Date customer_createdOn, Date customer_changedOn) {
        this.customer_contactID = customer_contactID;
        this.customer_status = customer_status;
        this.customer_createdOn = customer_createdOn;
        this.customer_changedOn = customer_changedOn;
    }

    public Integer getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(Integer customer_ID) {
        this.customer_ID = customer_ID;
    }

    public Integer getCustomer_contactID() {
        return customer_contactID;
    }

    public void setCustomer_contactID(Integer customer_contactID) {
        this.customer_contactID = customer_contactID;
    }

    public Boolean getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(Boolean customer_status) {
        this.customer_status = customer_status;
    }

    public Date getCustomer_createdOn() {
        return customer_createdOn;
    }

    public void setCustomer_createdOn(Date customer_createdOn) {
        this.customer_createdOn = customer_createdOn;
    }

    public Date getCustomer_changedOn() {
        return customer_changedOn;
    }

    public void setCustomer_changedOn(Date customer_changedOn) {
        this.customer_changedOn = customer_changedOn;
    }





}
