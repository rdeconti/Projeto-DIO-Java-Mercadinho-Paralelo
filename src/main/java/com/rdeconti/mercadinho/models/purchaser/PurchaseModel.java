package com.rdeconti.mercadinho.models.purchaser;

import com.rdeconti.mercadinho.models.stocker.ProductModel;
import com.rdeconti.mercadinho.models.stocker.StockModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PURCHASES")
public class PurchaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "purchase_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "stock_ID", nullable=false)
    private StockModel storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "vendor_ID", nullable=false)
    private VendorModel vendorID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "product_ID", nullable=false)
    private ProductModel productID;

    @PositiveOrZero
    @Column(name = "purchase_amount")
    @NotEmpty(message = "*Por favor informar a quantidade a ser comprada")
    private Double amount;

    @PositiveOrZero
    @Column(name = "purchase_price")
    @NotEmpty(message = "*Por favor informar o preço de compra")
    private Double price;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_created")
    private Date created = new Date();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_changed")
    private Date changed = new Date();

}
