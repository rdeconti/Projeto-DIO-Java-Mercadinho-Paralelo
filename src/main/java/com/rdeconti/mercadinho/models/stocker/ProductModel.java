package com.rdeconti.mercadinho.models.stocker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Long id;

    @NotEmpty(message = "*Por favor informar o nome do produto")
    @Column(name = "product_name", length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "*Por favor informar o código EAN do produto")
    @Column(name = "product_ean", length = 14, nullable = false)
    private String ean;

    @NotEmpty(message = "*Por favor informar a unidade do produto")
    @Column(name = "product_unity", length = 3, nullable = false)
    private String unity;

    @Column(name = "product_status", length = 1, nullable = false)
    private Boolean status = true;

    @Lob
    @NotEmpty(message = "*Por favor carregar a imagem do produto")
    @Column(name = "product_image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @NotEmpty(message = "*Por favor informar o preço do produto")
    @Column(name = "product_price", nullable = false)
    private Double price;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "product_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "product_changed")
    private Date changed = new Date();

}
