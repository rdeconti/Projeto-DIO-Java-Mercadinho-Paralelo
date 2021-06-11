package com.rdeconti.mercadinho.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="STOCKS")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "stock_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "store_id", nullable=false)
    private StoreModel stock_storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "product_id", nullable=false)
    private ProductModel stock_productID;

    @PositiveOrZero
    @NotEmpty(message = "*Por favor informar a quantidade do produto em estoque")
    @Column(name = "stock_amount", nullable = false)
    private Double stock_amount;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stock_expiration", nullable = false)
    private Date stock_expiration;

    @CreationTimestamp
    @Column(name = "stock_createdOn", nullable = false)
    private Date stock_createdOn;

    @UpdateTimestamp
    @Column(name = "stock_changedOn", nullable = false)
    private Date stock_changedOn;

}
