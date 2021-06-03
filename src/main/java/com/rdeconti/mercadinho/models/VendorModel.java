package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="VENDORS")
public class VendorModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer vendor_ID;
    private Integer vendor_contactID;
    private Boolean vendor_status;
    private LocalDate vendor_createdOn;
    private LocalDate vendor_changedOn;

    public VendorModel() {

    }

    public VendorModel(Integer vendor_ID, Integer vendor_contactID, Boolean vendor_status, LocalDate vendor_createdOn, LocalDate vendor_changedOn) {
        super( );
        this.vendor_ID = vendor_ID;
        this.vendor_contactID = vendor_contactID;
        this.vendor_status = vendor_status;
        this.vendor_createdOn = vendor_createdOn;
        this.vendor_changedOn = vendor_changedOn;
    }

    public VendorModel(Integer vendor_contactID, Boolean vendor_status, LocalDate vendor_createdOn, LocalDate vendor_changedOn) {
        this.vendor_contactID = vendor_contactID;
        this.vendor_status = vendor_status;
        this.vendor_createdOn = vendor_createdOn;
        this.vendor_changedOn = vendor_changedOn;
    }

    public Integer getVendor_ID() {
        return vendor_ID;
    }

    public void setVendor_ID(Integer vendor_ID) {
        this.vendor_ID = vendor_ID;
    }

    public Integer getVendor_contactID() {
        return vendor_contactID;
    }

    public void setVendor_contactID(Integer vendor_contactID) {
        this.vendor_contactID = vendor_contactID;
    }

    public Boolean getVendor_status() {
        return vendor_status;
    }

    public void setVendor_status(Boolean vendor_status) {
        this.vendor_status = vendor_status;
    }

    public LocalDate getVendor_createdOn() {
        return vendor_createdOn;
    }

    public void setVendor_createdOn(LocalDate vendor_createdOn) {
        this.vendor_createdOn = vendor_createdOn;
    }

    public LocalDate getVendor_changedOn() {
        return vendor_changedOn;
    }

    public void setVendor_changedOn(LocalDate vendor_changedOn) {
        this.vendor_changedOn = vendor_changedOn;
    }
}
