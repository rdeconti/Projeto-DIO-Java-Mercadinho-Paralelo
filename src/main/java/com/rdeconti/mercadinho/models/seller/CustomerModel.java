package com.rdeconti.mercadinho.models.seller;

import com.rdeconti.mercadinho.models.ContactModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_ID", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel contactID;

    // TODO CREATE BUTTONS AND ROUTINE TO CHANGE STATUS IN ALL OBJECTS
    @Column(name = "customer_status", length = 1, nullable = false)
    private Boolean status = true;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "customer_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "customer_changed")
    private Date changed = new Date();

}
