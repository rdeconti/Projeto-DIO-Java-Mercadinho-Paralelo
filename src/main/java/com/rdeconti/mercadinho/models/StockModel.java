// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object STOCK
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="STOCKS")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "stock_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_storeID", referencedColumnName = "store_ID", nullable=false)
    @Valid
    @NotEmpty()
    private StoreModel storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_productID", referencedColumnName = "product_ID", nullable=false)
    @Valid
    @NotEmpty()
    private ProductModel productID;

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Valid
    @NotEmpty()
    @Column(name = "stock_batch")
    private Long batch;

    @Valid
    @NotEmpty()
    @PositiveOrZero
    @Column(name = "stock_amount")
    private BigDecimal amount;

    @Column(name = "product_status")
    private Boolean status = true;

    @Valid
    @NotEmpty()
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_expiration")
    private LocalDateTime expiration;

}
