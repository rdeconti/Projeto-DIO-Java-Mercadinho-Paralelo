package com.rdeconti.mercadinho.models.stocker;

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
@Table(name="MOVEMENTS")
public class MovementModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "movement_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="movement_ID", referencedColumnName = "stock_ID", nullable=false)
    private StockModel stockID;

    @NotEmpty(message = "*Por favor informar o número da ordem")
    @Column(name = "movement_order")
    private Long order;

    @NotEmpty(message = "*Por favor informar o número da item da ordem")
    @Column(name = "movement_item")
    private Long item;

    @NotEmpty(message = "*Por favor informar o tipo da ordem")
    @Column(name = "movement_type")
    private String type;

    @NotEmpty(message = "*Por favor informar a data do movimento")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "movement_date")
    private Date movementAt = new Date();

    @PositiveOrZero
    @Column(name = "movement_amount")
    @NotEmpty(message = "*Por favor informar a quantidade movimentada")
    private Double amount;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "movement_status")
    private Boolean active = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "movement_created_at")
    private Date created_at = new Date();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "movement_changed_at")
    private Date changed_at = new Date();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "movement_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "movement_changed_by")
    private String changed_by;

}
