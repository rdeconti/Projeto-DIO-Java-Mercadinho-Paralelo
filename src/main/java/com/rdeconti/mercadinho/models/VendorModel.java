package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="VENDORS")
public class VendorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer vendor_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_ID")
    private Integer vendor_contactID;

    @Column(name = "vendor_status", length = 1, nullable = false)
    private Boolean vendor_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vendor_createdOn", nullable = false)
    private java.util.Date vendor_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vendor_changedOn", nullable = false)
    private java.util.Date vendor_changedOn;

    public VendorModel() {

    }

    public VendorModel(Integer vendor_ID, Integer vendor_contactID, Boolean vendor_status, Date vendor_createdOn, Date vendor_changedOn) {
        super( );
        this.vendor_ID = vendor_ID;
        this.vendor_contactID = vendor_contactID;
        this.vendor_status = vendor_status;
        this.vendor_createdOn = vendor_createdOn;
        this.vendor_changedOn = vendor_changedOn;
    }

    public VendorModel(Integer vendor_contactID, Boolean vendor_status, Date vendor_createdOn, Date vendor_changedOn) {
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

    public Date getVendor_createdOn() {
        return vendor_createdOn;
    }

    public void setVendor_createdOn(Date vendor_createdOn) {
        this.vendor_createdOn = vendor_createdOn;
    }

    public Date getVendor_changedOn() {
        return vendor_changedOn;
    }

    public void setVendor_changedOn(Date vendor_changedOn) {
        this.vendor_changedOn = vendor_changedOn;
    }
}
