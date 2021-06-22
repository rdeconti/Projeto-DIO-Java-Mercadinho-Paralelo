package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.stocker.ProductModel;
import com.rdeconti.mercadinho.models.stocker.StockModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name="SALES")
public class SaleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sale_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_ID", referencedColumnName = "stock_ID", nullable=false)
    private StockModel storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_ID", referencedColumnName = "customer_ID", nullable=false)
    private CustomerModel customerID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_ID", referencedColumnName = "product_ID", nullable=false)
    private ProductModel productID;

    @PositiveOrZero
    @NotEmpty(message = "*Por favor informar a quantidade a ser vendida")
    private Double amount;

    @PositiveOrZero
    @Column(name = "sales_price")
    @NotEmpty(message = "*Por favor informar o preço de venda")
    private Double price;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_changed")
    private Date changed = new Date();

}
