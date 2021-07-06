package com.rdeconti.mercadinho.models.stocker;

import com.rdeconti.mercadinho.models.purchaser.ProductModel;
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
@Table(name="STOCKS")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "stock_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "store_ID", nullable=false)
    private StoreModel storeID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_ID", referencedColumnName = "product_ID", nullable=false)
    private ProductModel productID;

    @PositiveOrZero
    @NotEmpty(message = "*Por favor informar a quantidade do produto em estoque")
    @Column(name = "stock_amount", nullable = false)
    private BigDecimal amount;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "product_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de validade do produto")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_expiration")
    private LocalDateTime expiration;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "stock_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "stock_changed_by")
    private String changed_by;

}
