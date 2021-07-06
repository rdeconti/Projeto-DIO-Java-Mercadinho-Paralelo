package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.seller.CustomerModel;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "sale_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "sale_changed_by")
    private String changed_by;

}
