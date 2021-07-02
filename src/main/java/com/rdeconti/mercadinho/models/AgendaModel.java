package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AGENDAS")
public class AgendaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "agenda_ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "agenda_name")
    private String name;

    @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
    @Size(max = 25)
    @Column(name = "agenda_phone")
    private String phone;

    @Email(message = "Email Address")
    @Size(max = 100)
    @Column(name = "agenda_email")
    private String email;

    @Size(max = 50)
    @Column(name = "agenda_address1")
    private String address1;

    @Size(max = 50)
    @Column(name = "agenda_address2")
    private String address2;

    @Size(max = 50)
    @Column(name = "agenda_address3")
    private String address3;

    @Size(max = 20)
    @Column(name = "agenda_postal")
    private String postalCode;

    @Column(name = "agenda_note", length = 4000)
    private String note;
}
