package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="STOCKS")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer stock_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_ID")
    private Integer stock_storeID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_ID")
    private Integer stock_productID;

    @PositiveOrZero
    @NotEmpty(message = "*Por favor informar a quantidade do produto em estoque")
    @Column(name = "stock_amount", nullable = false)
    private Double stock_amount;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stock_expiration", nullable = false)
    private java.util.Date stock_expiration;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stock_createdOn", nullable = false)
    private java.util.Date stock_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stock_changedOn", nullable = false)
    private java.util.Date stock_changedOn;

    public StockModel() {

    }

    public StockModel(Integer stock_ID, Integer stock_storeID, Integer stock_productID, Double stock_amount, Date stock_expiration, Date stock_createdOn, Date stock_changedOn) {
        super( );
        this.stock_ID = stock_ID;
        this.stock_storeID = stock_storeID;
        this.stock_productID = stock_productID;
        this.stock_amount = stock_amount;
        this.stock_expiration = stock_expiration;
        this.stock_createdOn = stock_createdOn;
        this.stock_changedOn = stock_changedOn;
    }

    public StockModel(Integer stock_storeID, Integer stock_productID, Double stock_amount, Date stock_expiration, Date stock_createdOn, Date stock_changedOn) {
        this.stock_storeID = stock_storeID;
        this.stock_productID = stock_productID;
        this.stock_amount = stock_amount;
        this.stock_expiration = stock_expiration;
        this.stock_createdOn = stock_createdOn;
        this.stock_changedOn = stock_changedOn;
    }

    public Integer getStock_ID() {
        return stock_ID;
    }

    public void setStock_ID(Integer stock_ID) {
        this.stock_ID = stock_ID;
    }

    public Integer getStock_storeID() {
        return stock_storeID;
    }

    public void setStock_storeID(Integer stock_storeID) {
        this.stock_storeID = stock_storeID;
    }

    public Integer getStock_productID() {
        return stock_productID;
    }

    public void setStock_productID(Integer stock_productID) {
        this.stock_productID = stock_productID;
    }

    public Double getStock_amount() {
        return stock_amount;
    }

    public void setStock_amount(Double stock_amount) {
        this.stock_amount = stock_amount;
    }

    public Date getStock_expiration() {
        return stock_expiration;
    }

    public void setStock_expiration(Date stock_expiration) {
        this.stock_expiration = stock_expiration;
    }

    public Date getStock_createdOn() {
        return stock_createdOn;
    }

    public void setStock_createdOn(Date stock_createdOn) {
        this.stock_createdOn = stock_createdOn;
    }

    public Date getStock_changedOn() {
        return stock_changedOn;
    }

    public void setStock_changedOn(Date stock_changedOn) {
        this.stock_changedOn = stock_changedOn;
    }
}
