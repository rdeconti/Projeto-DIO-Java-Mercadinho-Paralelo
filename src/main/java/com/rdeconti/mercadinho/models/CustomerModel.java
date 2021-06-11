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
@Table(name="CUSTOMERS")
public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "customer_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel customer_contactID;

    // TODO CREATE BUTTONS AND ROUTINE TO CHANGE STATUS IN ALL OBJECTS
    @Column(name = "customer_status", length = 1, nullable = false)
    private Boolean customer_status = true;

    @CreationTimestamp
    @Column(name = "customer_createdOn", nullable = false)
    private Date customer_createdOn;

    @UpdateTimestamp
    @Column(name = "customer_changedOn", nullable = false)
    private Date customer_changedOn;

}
