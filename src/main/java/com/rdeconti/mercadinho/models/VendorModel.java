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
@Table(name="VENDORS")
public class VendorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "vendor_ID", nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vendor_id", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel vendor_contactID;

    @Column(name = "vendor_status", length = 1, nullable = false)
    private Boolean vendor_status = true;

    @CreationTimestamp
    @Column(name = "vendor_createdOn", nullable = false)
    private Date vendor_createdOn;

    @UpdateTimestamp
    @Column(name = "vendor_changedOn", nullable = false)
    private Date vendor_changedOn;

}
