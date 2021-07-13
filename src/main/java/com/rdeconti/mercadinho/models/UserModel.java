// -----------------------------------------------------------------------------------------------------------------
// Author: Rosemeire Deconti
// Date: 01/06/2021
// Project: Develop an application to control stocks and e-commerce from a Grocery
// Origin: Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
// Class: Model that defines attributes regarding object USER
// -----------------------------------------------------------------------------------------------------------------
package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ID")
    private Long id;

    @Valid
    @NotEmpty()
    @Column(name = "user_code")
    private String userName;

    @Valid
    @NotEmpty()
    @Column(name = "user_email")
    private String email;

    @Valid
    @NotEmpty()
    @Column(name = "user_password")
    private String password;

    @Valid
    @NotEmpty()
    @Column(name = "user_role")
    private String role = "ROLE_USER";

    @Valid
    @NotEmpty()
    @Column(name = "user_name")
    private String name;

    @Column(name = "user_status")
    private Boolean status = true;

}
