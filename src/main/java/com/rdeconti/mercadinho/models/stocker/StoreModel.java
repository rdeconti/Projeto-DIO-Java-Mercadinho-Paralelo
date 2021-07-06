package com.rdeconti.mercadinho.models.stocker;

import com.rdeconti.mercadinho.models.manager.ContactModel;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="STORES")
public class StoreModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "store_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="store_ID", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel contactID;

    @NotEmpty(message = "*Por favor informar a razão social da loja")
    @Column(name = "store_social")
    private String social;

    @NotEmpty(message = "*Por favor informar a inscrição municipal da loja")
    @Column(name = "store_municipal")
    private String municipal;

    @NotEmpty(message = "*Por favor informar a inscrição estadual da loja")
    @Column(name = "store_state")
    private String state;

    @NotEmpty(message = "*Por favor informar a atividade da loja")
    @Column(name = "store_activity")
    private String activity;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "store_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "store_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_changed_by")
    private String changed_by;

}
