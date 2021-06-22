package com.rdeconti.mercadinho.models.purchaser;

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
@Table(name="VENDORS")
public class VendorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "vendor_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vendor_ID", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel contactID;

    @Column(name = "vendor_status", length = 1, nullable = false)
    private Boolean status = true;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "vendor_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "vendor_changed")
    private Date changed = new Date();

}
