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
    @Column(name = "product_ID", nullable = false)
    private Long id;

    @NotEmpty(message = "*Por favor informar a imagem do produto")
    @Size(min = 2, max = 1000, message = "*O endereço da imagem deve ter deve ter de 2 até 1000 caracteres")
    @Column(name = "product_image", length = 50, nullable = false)
    private String image;

    @NotEmpty(message = "*Por favor informar a categoria do produto")
    @Column(name = "product_category")
    private Integer category;

    @NotEmpty(message = "*Por favor informar o nome do produto")
    @Column(name = "product_name", length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "*Por favor informar o código EAN do produto")
    @Column(name = "product_ean", length = 14, nullable = false)
    private String ean;

    @NotEmpty(message = "*Por favor informar a unidade do produto")
    @Column(name = "product_unity", length = 3, nullable = false)
    private String unity;

    @NotEmpty(message = "*Por favor informar o preço do produto")
    @Column(name = "product_price", nullable = false)
    private BigDecimal price;

    @NotEmpty(message = "*Por favor informar a descrição do produto")
    @Column(name = "product_description", length = 14, nullable = false)
    private String description;

    @Column(name = "product_status")
    private Boolean status = true;

}
