package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="INVENTORIES")
public class StockModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Stock_ID;
    private Integer Stock_storeID;
    private Integer Stock_productID;
    private Double Stock_amount;
    private LocalDate Stock_createdOn;
    private LocalDate Stock_changedOn;

    public StockModel() {

    }

    public StockModel(Integer Stock_ID, Integer Stock_storeID, Integer Stock_productID, Double Stock_amount, LocalDate Stock_createdOn, LocalDate Stock_changedOn) {
        super( );
        this.Stock_ID = Stock_ID;
        this.Stock_storeID = Stock_storeID;
        this.Stock_productID = Stock_productID;
        this.Stock_amount = Stock_amount;
        this.Stock_createdOn = Stock_createdOn;
        this.Stock_changedOn = Stock_changedOn;
    }

    public StockModel(Integer Stock_storeID, Integer Stock_productID, Double Stock_amount, LocalDate Stock_createdOn, LocalDate Stock_changedOn) {
        this.Stock_storeID = Stock_storeID;
        this.Stock_productID = Stock_productID;
        this.Stock_amount = Stock_amount;
        this.Stock_createdOn = Stock_createdOn;
        this.Stock_changedOn = Stock_changedOn;
    }

    public Integer getStock_ID() {
        return Stock_ID;
    }

    public void setStock_ID(Integer Stock_ID) {
        this.Stock_ID = Stock_ID;
    }

    public Integer getStock_storeID() {
        return Stock_storeID;
    }

    public void setStock_storeID(Integer Stock_storeID) {
        this.Stock_storeID = Stock_storeID;
    }

    public Integer getStock_productID() {
        return Stock_productID;
    }

    public void setStock_productID(Integer Stock_productID) {
        this.Stock_productID = Stock_productID;
    }

    public Double getStock_amount() {
        return Stock_amount;
    }

    public void setStock_amount(Double Stock_amount) {
        this.Stock_amount = Stock_amount;
    }

    public LocalDate getStock_createdOn() {
        return Stock_createdOn;
    }

    public void setStock_createdOn(LocalDate Stock_createdOn) {
        this.Stock_createdOn = Stock_createdOn;
    }

    public LocalDate getStock_changedOn() {
        return Stock_changedOn;
    }

    public void setStock_changedOn(LocalDate Stock_changedOn) {
        this.Stock_changedOn = Stock_changedOn;
    }
}
