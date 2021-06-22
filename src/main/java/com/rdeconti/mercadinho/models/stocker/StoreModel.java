package com.rdeconti.mercadinho.models.stocker;

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

    @Column(name = "store_status", length = 1, nullable = false)
    private Boolean status = true;

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_created")
    private Date created = new Date();

    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_changed")
    private Date changed = new Date();

}
