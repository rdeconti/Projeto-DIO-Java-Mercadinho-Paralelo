package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="PRODUCTS")
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer product_ID;

    @NotEmpty(message = "*Por favor informar o nome do produto")
    @Column(name = "product_name", length = 50, nullable = false)
    private String product_name;

    @NotEmpty(message = "*Por favor informar o código EAN do produto")
    @Column(name = "product_ean", length = 14, nullable = false)
    private String product_ean;

    @NotEmpty(message = "*Por favor informar a unidade do produto")
    @Column(name = "product_unity", length = 3, nullable = false)
    private String product_unity;

    @Column(name = "product_status", length = 1, nullable = false)
    private Boolean product_status;

    @Lob
    @NotEmpty(message = "*Por favor carregar a imagem do produto")
    @Column(name = "product_image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] product_image;

    @NotEmpty(message = "*Por favor informar o preço do produto")
    @Column(name = "product_prince", nullable = false)
    private Double product_price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_createdOn", nullable = false)
    private java.util.Date product_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_changedOn", nullable = false)
    private java.util.Date product_changedOn;

    public ProductModel() {

    }

    public ProductModel(Integer product_ID, String product_name, String product_ean, String product_unity, Boolean product_status, @NotEmpty(message = "*Por favor carregar a imagem do produto") byte[] product_image, Double product_price, Date product_createdOn, Date product_changedOn) {
        super( );
        this.product_ID = product_ID;
        this.product_name = product_name;
        this.product_ean = product_ean;
        this.product_unity = product_unity;
        this.product_status = product_status;
        this.product_image = product_image;
        this.product_price = product_price;
        this.product_createdOn = product_createdOn;
        this.product_changedOn = product_changedOn;
    }

    public ProductModel(String product_name, String product_ean, String product_unity, Boolean product_status, @NotEmpty(message = "*Por favor carregar a imagem do produto") byte[] product_image, Double product_price, Date product_createdOn, Date product_changedOn) {
        this.product_name = product_name;
        this.product_ean = product_ean;
        this.product_unity = product_unity;
        this.product_status = product_status;
        this.product_image = product_image;
        this.product_price = product_price;
        this.product_createdOn = product_createdOn;
        this.product_changedOn = product_changedOn;
    }

    public Integer getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_ean() {
        return product_ean;
    }

    public void setProduct_ean(String product_ean) {
        this.product_ean = product_ean;
    }

    public String getProduct_unity() {
        return product_unity;
    }

    public void setProduct_unity(String product_unity) {
        this.product_unity = product_unity;
    }

    public Boolean getProduct_status() {
        return product_status;
    }

    public void setProduct_status(Boolean product_status) {
        this.product_status = product_status;
    }

    public byte[] getProduct_image() {
        return product_image;
    }

    public void setProduct_image(byte[] product_image) {
        this.product_image = product_image;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Date getProduct_createdOn() {
        return product_createdOn;
    }

    public void setProduct_createdOn(Date product_createdOn) {
        this.product_createdOn = product_createdOn;
    }

    public Date getProduct_changedOn() {
        return product_changedOn;
    }

    public void setProduct_changedOn(Date product_changedOn) {
        this.product_changedOn = product_changedOn;
    }
}
