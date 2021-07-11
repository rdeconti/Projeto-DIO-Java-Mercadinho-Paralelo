package com.rdeconti.mercadinho.models.purchaser;

import com.rdeconti.mercadinho.models.stocker.StockModel;
import com.rdeconti.mercadinho.models.seller.CartModel;
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
@Table(name="PURCHASES_ITEMS")
public class PurchaseItemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_ID", nullable = false)
    private Long id;

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

    @Column(name = "item_status")
    private Boolean status = true;

}
