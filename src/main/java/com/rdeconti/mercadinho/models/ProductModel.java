package com.rdeconti.mercadinho.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "product_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "product_created_at")
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "product_changed_at")
    private LocalDateTime changedDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar usuário responsável pela criação")
    @Column(name = "product_created_by")
    private String createdUser;

    @NotEmpty(message = "*Por favor informar usuário responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "product_changed_by")
    private String changedUser;

}
