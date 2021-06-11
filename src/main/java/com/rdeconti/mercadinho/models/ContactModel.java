package com.rdeconti.mercadinho.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CONTACTS")
public class ContactModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "contact_id", nullable = false)
    private Integer codigo;

    @NotEmpty(message = "*Por favor informar o nome do contato!")
    @Column(name = "contact_name", nullable = false)
    private String contact_name;

    @NotEmpty(message = "*Por favor informar o endereço do contato!")
    @Column(name = "contact_address", nullable = false)
    private String contact_address;

    @Pattern(regexp="(^$|[0-9]{10})")
    @NotEmpty(message = "*Por favor informar o telefone do contato!")
    @Column(name = "contact_phone", nullable = false)
    private String contact_phone;

    // TODO CHECK BEAN VALIDATION TO CPF OR CNPJ
    @NotEmpty(message = "*Por favor informar o tipo de documento do contato!")
    @Column(name = "contact_type", nullable = false)
    private Integer contact_type;

    @NotEmpty(message = "*Por favor informar o documento do contato!")
    @Column(name = "contact_document", nullable = false)
    private String contact_document;

    @Column(name = "contact_status", length = 1, nullable = false)
    private Boolean contact_status = true;

    @Email(message = "*Por favor informar um e-mail válido!")
    @NotEmpty(message = "*Please provide an user_email")
    @Column(name = "contact_email")
    private String contact_email;

    @CreationTimestamp
    @Column(name = "contact_createdOn", nullable = false)
    private Date contact_createdOn;

    @UpdateTimestamp
    @Column(name = "contact_changedOn", nullable = false)
    private Date contact_changedOn;

}
