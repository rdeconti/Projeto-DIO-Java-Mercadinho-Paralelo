// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object PRODUCT
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="PRODUCTS")
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "product_ID")
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "product_image")
    private String image;

    @Valid
    @NotEmpty()
    @Column(name = "product_category")
    private Integer category;

    @Valid
    @NotEmpty()
    @Column(name = "product_name")
    private String name;

    @Valid
    @NotEmpty()
    @Column(name = "product_ean")
    private String ean;

    @Valid
    @NotEmpty()
    @Column(name = "product_unity")
    private String unity;

    @Valid
    @NotEmpty()
    @Column(name = "product_price")
    private BigDecimal price;

    @Valid
    @NotEmpty()
    @Column(name = "product_description")
    private String description;

    @Column(name = "product_status")
    private Boolean status = true;

}
