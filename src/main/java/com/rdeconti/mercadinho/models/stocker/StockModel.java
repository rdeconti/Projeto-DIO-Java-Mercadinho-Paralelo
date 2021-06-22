package com.rdeconti.mercadinho.models.stocker;

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
@Table(name="STOCKS")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "stock_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "store_ID", nullable=false)
    private StoreModel storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "product_ID", nullable=false)
    private ProductModel productID;

    @PositiveOrZero
    @NotEmpty(message = "*Por favor informar a quantidade do produto em estoque")
    @Column(name = "stock_amount", nullable = false)
    private Double amount;

    @NotEmpty(message = "*Por favor informar a data de validade do produto")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_expiration")
    private Date expiration;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_changed")
    private Date changed = new Date();

}
