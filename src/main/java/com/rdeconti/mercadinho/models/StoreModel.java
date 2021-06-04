package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="STORES")
public class StoreModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer store_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_ID")
    private Integer store_contactID;

    @Column(name = "store_status", length = 1, nullable = false)
    private Boolean store_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "store_createdOn", nullable = false)
    private java.util.Date store_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "store_changedOn", nullable = false)
    private java.util.Date store_changedOn;

    public StoreModel() {

    }

    public StoreModel(Integer store_ID, Integer store_contactID, Boolean store_status, Date store_createdOn, Date store_changedOn) {
        super( );
        this.store_ID = store_ID;
        this.store_contactID = store_contactID;
        this.store_status = store_status;
        this.store_createdOn = store_createdOn;
        this.store_changedOn = store_changedOn;
    }

    public StoreModel(Integer store_contactID, Boolean store_status, Date store_createdOn, Date store_changedOn) {
        this.store_contactID = store_contactID;
        this.store_status = store_status;
        this.store_createdOn = store_createdOn;
        this.store_changedOn = store_changedOn;
    }

    public Integer getStore_ID() {
        return store_ID;
    }

    public void setStore_ID(Integer store_ID) {
        this.store_ID = store_ID;
    }

    public Integer getStore_contactID() {
        return store_contactID;
    }

    public void setStore_contactID(Integer store_contactID) {
        this.store_contactID = store_contactID;
    }

    public Boolean getStore_status() {
        return store_status;
    }

    public void setStore_status(Boolean store_status) {
        this.store_status = store_status;
    }

    public Date getStore_createdOn() {
        return store_createdOn;
    }

    public void setStore_createdOn(Date store_createdOn) {
        this.store_createdOn = store_createdOn;
    }

    public Date getStore_changedOn() {
        return store_changedOn;
    }

    public void setStore_changedOn(Date store_changedOn) {
        this.store_changedOn = store_changedOn;
    }
}
