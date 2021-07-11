package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.CustomerModel;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
@Table(name="SALES")
public class SaleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sale_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_ID", referencedColumnName = "customer_ID", nullable=false)
    private CustomerModel customerID;

    @PositiveOrZero
    @Column(name = "sale_price")
    @NotEmpty(message = "*Por favor informar o preço de compra")
    private BigDecimal price;

    @NotEmpty(message = "*Por favor informar o estágio do processo")
    @Column(name = "sale_stage")
    private Integer stage;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "sale_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar comentários sobre a informação")
    @Column(name = "sale_comments")
    private String comments;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_created_at")
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_changed_at")
    private LocalDateTime changedDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar usuário responsável pela criação")
    @Column(name = "sale_created_by")
    private String createdUser;

    @NotEmpty(message = "*Por favor informar usuário responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_changed_by")
    private String changedUser;

}
