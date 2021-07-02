package com.rdeconti.mercadinho.models.purchaser;

import com.rdeconti.mercadinho.models.enumStatus;
import com.rdeconti.mercadinho.models.manager.ContactModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Validated
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

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "vendor_status", nullable = false)
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "vendor_created_at")
    private Date created_at = new Date();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "vendor_changed_at")
    private Date changed_at = new Date();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "vendor_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "vendor_changed_by")
    private String changed_by;

}
