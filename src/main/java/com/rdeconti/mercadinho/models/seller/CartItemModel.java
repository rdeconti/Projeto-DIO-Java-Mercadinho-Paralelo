package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.manager.UserModel;
import com.rdeconti.mercadinho.models.stocker.StockModel;
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
@Table(name="CARTS_ITEMS")
public class CartItemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "item_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="item_ID", referencedColumnName = "user_ID", nullable=false)
    private UserModel userID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "stock_ID", nullable=false)
    private StockModel stockID;

    @PositiveOrZero
    @Column(name = "item_amount")
    @NotEmpty(message = "*Por favor informar o quantidade a ser comprada")
    private Double amount;

    @PositiveOrZero
    @Column(name = "item_price")
    @NotEmpty(message = "*Por favor informar o preço a ser pago")
    private Double price;

    @PositiveOrZero
    @Column(name = "item_discount")
    @NotEmpty(message = "*Por favor informar o desconto")
    private Double discount;

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
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "item_created_at")
    private Date created_at = new Date();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "item_changed_at")
    private Date changed_at = new Date();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "item_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "item_changed_by")
    private String changed_by;

}