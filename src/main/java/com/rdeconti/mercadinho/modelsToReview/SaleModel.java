package com.rdeconti.mercadinho.modelsToReview;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="SALES")
public class SaleModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer sale_ID;
    private Integer sale_storeID;
    private Integer sale_customerID;
    private Integer sale_productID;
    private Double sale_amount;
    private LocalDate sale_createdOn;
    private LocalDate sale_changedOn;

    public SaleModel() {

    }

    public SaleModel(Integer sale_ID, Integer sale_storeID, Integer sale_customerID, Integer sale_productID, Double sale_amount, LocalDate sale_createdOn, LocalDate sale_changedOn) {
        super( );
        this.sale_ID = sale_ID;
        this.sale_storeID = sale_storeID;
        this.sale_customerID = sale_customerID;
        this.sale_productID = sale_productID;
        this.sale_amount = sale_amount;
        this.sale_createdOn = sale_createdOn;
        this.sale_changedOn = sale_changedOn;
    }

    public SaleModel(Integer sale_storeID, Integer sale_customerID, Integer sale_productID, Double sale_amount, LocalDate sale_createdOn, LocalDate sale_changedOn) {
        this.sale_storeID = sale_storeID;
        this.sale_customerID = sale_customerID;
        this.sale_productID = sale_productID;
        this.sale_amount = sale_amount;
        this.sale_createdOn = sale_createdOn;
        this.sale_changedOn = sale_changedOn;
    }

    public Integer getSale_ID() {
        return sale_ID;
    }

    public void setSale_ID(Integer sale_ID) {
        this.sale_ID = sale_ID;
    }

    public Integer getSale_storeID() {
        return sale_storeID;
    }

    public void setSale_storeID(Integer sale_storeID) {
        this.sale_storeID = sale_storeID;
    }

    public Integer getSale_customerID() {
        return sale_customerID;
    }

    public void setSale_customerID(Integer sale_customerID) {
        this.sale_customerID = sale_customerID;
    }

    public Integer getSale_productID() {
        return sale_productID;
    }

    public void setSale_productID(Integer sale_productID) {
        this.sale_productID = sale_productID;
    }

    public Double getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(Double sale_amount) {
        this.sale_amount = sale_amount;
    }

    public LocalDate getSale_createdOn() {
        return sale_createdOn;
    }

    public void setSale_createdOn(LocalDate sale_createdOn) {
        this.sale_createdOn = sale_createdOn;
    }

    public LocalDate getSale_changedOn() {
        return sale_changedOn;
    }

    public void setSale_changedOn(LocalDate sale_changedOn) {
        this.sale_changedOn = sale_changedOn;
    }
}
