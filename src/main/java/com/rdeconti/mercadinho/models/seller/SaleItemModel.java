package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.stocker.StockModel;
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
@Table(name="SALES_ITEMS")
public class SaleItemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_ID", nullable = false)
    private Long id;

    // TODO -------------------------------- LINK COM USER !!!
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_ID", referencedColumnName = "cart_ID", nullable = false)
    private CartModel cartID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_ID", referencedColumnName = "stock_ID", nullable = false)
    private StockModel stockID;

    @PositiveOrZero
    @Column(name = "item_amount")
    @NotEmpty(message = "*Por favor informar o quantidade a ser comprada")
    private BigDecimal amount;

    @PositiveOrZero
    @Column(name = "item_price")
    @NotEmpty(message = "*Por favor informar o preço a ser pago")
    private BigDecimal price;

    @PositiveOrZero
    @Column(name = "item_discount")
    @NotEmpty(message = "*Por favor informar o desconto")
    private BigDecimal discount;

    @NotEmpty(message = "*Por favor informar o estágio do processo")
    @Column(name = "item_stage")
    private Integer stage;

    @NotEmpty(message = "*Por favor informar comentários sobre a informação")
    @Column(name = "item_comments")
    private String comments;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "item_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "item_created_at")
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "item_changed_at")
    private LocalDateTime changedDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar usuário responsável pela criação")
    @Column(name = "item_created_by")
    private String createdUser;

    @NotEmpty(message = "*Por favor informar usuário responsável pela alteração")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "item_changed_by")
    private String changedUser;

}
