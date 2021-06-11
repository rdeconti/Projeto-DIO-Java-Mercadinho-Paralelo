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
@Table(name="PURCHASES")
public class PurchaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "purchase_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_id", referencedColumnName = "stock_ID", nullable=false)
    private StockModel purchase_storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_id", referencedColumnName = "vendor_ID", nullable=false)
    private VendorModel purchase_vendorID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_id", referencedColumnName = "product_ID", nullable=false)
    private ProductModel purchase_productID;

    @NotEmpty(message = "*Por favor informar a quantidade a ser comprada")
    private Double purchase_amount;

    @CreationTimestamp
    @Column(name = "purchase_createdOn", nullable = false)
    private Date purchase_createdOn;

    @UpdateTimestamp
    @Column(name = "purchase_changedOn", nullable = false)
    private Date purchase_changedOn;

}
