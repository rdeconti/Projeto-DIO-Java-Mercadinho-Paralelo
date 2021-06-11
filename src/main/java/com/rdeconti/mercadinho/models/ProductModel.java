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
@Table(name="PRODUCTS")
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "product_ID", nullable = false)
    private Integer codigo;

    @NotEmpty(message = "*Por favor informar o nome do produto")
    @Column(name = "product_name", length = 50, nullable = false)
    private String product_name;

    @NotEmpty(message = "*Por favor informar o código EAN do produto")
    @Column(name = "product_ean", length = 14, nullable = false)
    private String product_ean;

    @NotEmpty(message = "*Por favor informar a unidade do produto")
    @Column(name = "product_unity", length = 3, nullable = false)
    private String product_unity;

    @Column(name = "product_status", length = 1, nullable = false)
    private Boolean product_status = true;

    @Lob
    @NotEmpty(message = "*Por favor carregar a imagem do produto")
    @Column(name = "product_image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] product_image;

    @NotEmpty(message = "*Por favor informar o preço do produto")
    @Column(name = "product_prince", nullable = false)
    private Double product_price;

    @CreationTimestamp
    @Column(name = "product_createdOn", nullable = false)
    private Date product_createdOn;

    @UpdateTimestamp
    @Column(name = "product_changedOn", nullable = false)
    private Date product_changedOn;

}
