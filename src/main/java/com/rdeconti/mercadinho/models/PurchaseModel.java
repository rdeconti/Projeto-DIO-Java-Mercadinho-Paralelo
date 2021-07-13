// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object PRODUCT
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
@Table(name="PURCHASES")
public class PurchaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "purchase_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "vendor_ID", nullable=false)
    @Valid
    @NotEmpty()
    private VendorModel vendorID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "product_ID", nullable=false)
    @Valid
    @NotEmpty()
    private ProductModel productID;

    @Valid
    @NotEmpty()
    @PositiveOrZero
    @Column(name = "purchase_amount")
    private BigDecimal amount;

    @Valid
    @NotEmpty()
    @PositiveOrZero
    @Column(name = "purchase_price")
    private BigDecimal price;

    @Valid
    @NotEmpty()
    @PositiveOrZero
    @Column(name = "purchase_discount")
    private BigDecimal discount;

    @Valid
    @NotEmpty()
    @Column(name = "purchase_stage")
    private Integer stage;

    @Valid
    @NotEmpty()
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_creation")
    private LocalDateTime creation;

    @Column(name = "purchase_status")
    private Boolean status = true;

    @Valid
    @NotEmpty()
    @Column(name = "purchase_comments")
    private String comments;

}
