package com.rdeconti.mercadinho.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agenda")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class AgendaModel implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "agenda_id", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "agenda_name", nullable = false)
    private String name;

    @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
    @Size(max = 25)
    @Column(name = "agenda_phone", nullable = false)
    private String phone;

    @Email(message = "Email Address")
    @Size(max = 100)
    @Column(name = "agenda_email", nullable = false)
    private String email;

    @Size(max = 50)
    @Column(name = "agenda_address1", nullable = false)
    private String address1;

    @Size(max = 50)
    @Column(name = "agenda_address2", nullable = false)
    private String address2;

    @Size(max = 50)
    @Column(name = "agenda_address3", nullable = false)
    private String address3;

    @Size(max = 20)
    @Column(name = "agenda_postalCode", nullable = false)
    private String postalCode;

    @Column(name = "agenda_note", nullable = false, length = 4000)
    private String note;


}
