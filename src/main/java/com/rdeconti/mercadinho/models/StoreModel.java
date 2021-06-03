package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="STORES")
public class StoreModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer store_ID;
    private Integer store_contactID;
    private Boolean store_status;
    private LocalDate store_createdOn;
    private LocalDate store_changedOn;

    public StoreModel() {

    }

    public StoreModel(Integer store_ID, Integer store_contactID, Boolean store_status, LocalDate store_createdOn, LocalDate store_changedOn) {
        super( );
        this.store_ID = store_ID;
        this.store_contactID = store_contactID;
        this.store_status = store_status;
        this.store_createdOn = store_createdOn;
        this.store_changedOn = store_changedOn;
    }

    public StoreModel(Integer store_contactID, Boolean store_status, LocalDate store_createdOn, LocalDate store_changedOn) {
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

    public LocalDate getStore_createdOn() {
        return store_createdOn;
    }

    public void setStore_createdOn(LocalDate store_createdOn) {
        this.store_createdOn = store_createdOn;
    }

    public LocalDate getStore_changedOn() {
        return store_changedOn;
    }

    public void setStore_changedOn(LocalDate store_changedOn) {
        this.store_changedOn = store_changedOn;
    }
}
