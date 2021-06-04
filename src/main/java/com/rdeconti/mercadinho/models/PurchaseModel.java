package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="PURCHASES")
public class PurchaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer purchase_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_ID")
    private Integer purchase_storeID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_vendorID")
    private Integer purchase_vendorID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_productID")
    private Integer purchase_productID;

    @NotEmpty(message = "*Por favor informar a quantidade a ser comprada")
    private Double purchase_amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_createdOn", nullable = false)
    private java.util.Date purchase_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_changedOn", nullable = false)
    private java.util.Date purchase_changedOn;

    public PurchaseModel() {

    }

    public PurchaseModel(Integer purchase_ID, Integer purchase_storeID, Integer purchase_vendorID, Integer purchase_productID, Double purchase_amount, Date purchase_createdOn, Date purchase_changedOn) {
        super( );
        this.purchase_ID = purchase_ID;
        this.purchase_storeID = purchase_storeID;
        this.purchase_vendorID = purchase_vendorID;
        this.purchase_productID = purchase_productID;
        this.purchase_amount = purchase_amount;
        this.purchase_createdOn = purchase_createdOn;
        this.purchase_changedOn = purchase_changedOn;
    }

    public PurchaseModel(Integer purchase_storeID, Integer purchase_vendorID, Integer purchase_productID, Double purchase_amount, Date purchase_createdOn, Date purchase_changedOn) {
        this.purchase_storeID = purchase_storeID;
        this.purchase_vendorID = purchase_vendorID;
        this.purchase_productID = purchase_productID;
        this.purchase_amount = purchase_amount;
        this.purchase_createdOn = purchase_createdOn;
        this.purchase_changedOn = purchase_changedOn;
    }

    public Integer getPurchase_ID() {
        return purchase_ID;
    }

    public void setPurchase_ID(Integer purchase_ID) {
        this.purchase_ID = purchase_ID;
    }

    public Integer getPurchase_storeID() {
        return purchase_storeID;
    }

    public void setPurchase_storeID(Integer purchase_storeID) {
        this.purchase_storeID = purchase_storeID;
    }

    public Integer getPurchase_vendorID() {
        return purchase_vendorID;
    }

    public void setPurchase_vendorID(Integer purchase_vendorID) {
        this.purchase_vendorID = purchase_vendorID;
    }

    public Integer getPurchase_productID() {
        return purchase_productID;
    }

    public void setPurchase_productID(Integer purchase_productID) {
        this.purchase_productID = purchase_productID;
    }

    public Double getPurchase_amount() {
        return purchase_amount;
    }

    public void setPurchase_amount(Double purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public Date getPurchase_createdOn() {
        return purchase_createdOn;
    }

    public void setPurchase_createdOn(Date purchase_createdOn) {
        this.purchase_createdOn = purchase_createdOn;
    }

    public Date getPurchase_changedOn() {
        return purchase_changedOn;
    }

    public void setPurchase_changedOn(Date purchase_changedOn) {
        this.purchase_changedOn = purchase_changedOn;
    }
}
