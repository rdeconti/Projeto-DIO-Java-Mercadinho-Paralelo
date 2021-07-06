package com.rdeconti.mercadinho.models.manager;

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
@Table(name="EMPLOYEES")
public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    // TODO VERIFICAR SE TODOS IDS ESTÃO SENDO GERADOS AUTOMATICAMENTE
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "employee_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee_ID", referencedColumnName = "contact_ID", nullable=false)
    private ContactModel contactID;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "employee_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "employee_created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "employee_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "employee_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "employee_changed_by")
    private String changed_by;

}

