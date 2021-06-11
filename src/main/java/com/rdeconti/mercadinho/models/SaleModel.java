package com.rdeconti.mercadinho.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SALES")
public class SaleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sale_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_id", referencedColumnName = "stock_ID", nullable=false)
    private StockModel sale_storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_id", referencedColumnName = "customer_ID", nullable=false)
    private CustomerModel sale_customerID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_id", referencedColumnName = "product_ID", nullable=false)
    private ProductModel sale_productID;

    @NotEmpty(message = "*Por favor informar a quantidade a ser vendida")
    private Double sale_amount;

    @CreationTimestamp
    @Column(name = "sale_createdOn", nullable = false)
    private Date sale_createdOn;

    @UpdateTimestamp
    @Column(name = "sale_changedOn", nullable = false)
    private Date sale_changedOn;

}
