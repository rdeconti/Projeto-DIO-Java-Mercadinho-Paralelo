// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object MOVEMENT
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
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
@Table(name="MOVEMENTS")
public class MovementModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "movement_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="movement_ID", referencedColumnName = "product_ID", nullable=false)
    @Valid
    @NotEmpty()
    private ProductModel productID;

    @Valid
    @NotEmpty()
    @Column(name = "movement_order")
    private Long order;

    @Valid
    @NotEmpty()
    @Column(name = "movement_type")
    private String type;

    @Valid
    @NotEmpty()
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "movement_date")
    private LocalDateTime movementAt = LocalDateTime.now();

    @Valid
    @NotEmpty()
    @PositiveOrZero
    @Column(name = "movement_amount")
    private BigDecimal amount;

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Valid
    @NotEmpty()
    @Column(name = "movement_batch")
    private Long batch;

    @Column(name = "movement_status")
    private Boolean active = true;

}

