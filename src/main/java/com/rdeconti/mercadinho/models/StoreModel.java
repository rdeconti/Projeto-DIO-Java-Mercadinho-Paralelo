package com.rdeconti.mercadinho.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="STORES")
public class StoreModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "store_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="store_id", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel store_contactID;

    @Column(name = "store_status", length = 1, nullable = false)
    private Boolean store_status = true;

    @CreationTimestamp
    @Column(name = "store_createdOn", nullable = false)
    private Date store_createdOn;

    @UpdateTimestamp
    @Column(name = "store_changedOn", nullable = false)
    private Date store_changedOn;

}
