package com.rdeconti.mercadinho.modelsToReview;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="PURCHASES")
public class PurchaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer purchase_ID;
    private Integer purchase_storeID;
    private Integer purchase_vendorID;
    private Integer purchase_productID;
    private Double purchase_amount;
    private LocalDate purchase_createdOn;
    private LocalDate purchase_changedOn;

    public PurchaseModel() {

    }

    public PurchaseModel(Integer purchase_ID, Integer purchase_storeID, Integer purchase_vendorID, Integer purchase_productID, Double purchase_amount, LocalDate purchase_createdOn, LocalDate purchase_changedOn) {
        super( );
        this.purchase_ID = purchase_ID;
        this.purchase_storeID = purchase_storeID;
        this.purchase_vendorID = purchase_vendorID;
        this.purchase_productID = purchase_productID;
        this.purchase_amount = purchase_amount;
        this.purchase_createdOn = purchase_createdOn;
        this.purchase_changedOn = purchase_changedOn;
    }

    public PurchaseModel(Integer purchase_storeID, Integer purchase_vendorID, Integer purchase_productID, Double purchase_amount, LocalDate purchase_createdOn, LocalDate purchase_changedOn) {
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

    public LocalDate getPurchase_createdOn() {
        return purchase_createdOn;
    }

    public void setPurchase_createdOn(LocalDate purchase_createdOn) {
        this.purchase_createdOn = purchase_createdOn;
    }

    public LocalDate getPurchase_changedOn() {
        return purchase_changedOn;
    }

    public void setPurchase_changedOn(LocalDate purchase_changedOn) {
        this.purchase_changedOn = purchase_changedOn;
    }
}
