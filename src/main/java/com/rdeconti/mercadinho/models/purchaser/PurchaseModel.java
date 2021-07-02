package com.rdeconti.mercadinho.models.purchaser;

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
@Table(name="PURCHASES")
public class PurchaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "purchase_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_ID", referencedColumnName = "vendor_ID", nullable=false)
    private VendorModel vendorID;

    @PositiveOrZero
    @Column(name = "purchase_price")
    @NotEmpty(message = "*Por favor informar o preço de compra")
    private Double price;

    @NotEmpty(message = "*Por favor informar o estágio do processo")
    @Column(name = "purchase_stage")
    private Integer stage;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "purchase_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar comentários sobre a informação")
    @Column(name = "purchase_comments")
    private String comments;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_created_at")
    private Date created_at = new Date();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_changed_at")
    private Date changed_at = new Date();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "purchase_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "purchase_changed_by")
    private String changed_by;

}
