package com.rdeconti.mercadinho.models.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ID")
    private int id;

    @Column(name = "user_name")
    @Length(min = 5, message = "*Seu código de usuário deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor informe seu código de usuário")
    private String userName;

    @Column(name = "user_email")
    @Email(message = "*Por favor informe e-mail válido")
    @NotEmpty(message = "*Por favor informe seu e-mail")
    private String email;

    @Column(name = "user_password")
    @Length(min = 5, message = "*Sua senha deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor informe sua senha")
    private String password;

    @NotEmpty(message = "*Por favor informar a situação do usuário")
    @Column(name = "user_status")
    private Boolean active = true;

    @Column(name = "user_role")
    @NotEmpty(message = "*Por favor informar a função do usuário")
    private String role;

    /*
    @Column(name = "user_firstName")
    @NotEmpty(message = "*Por favor informe seu nome")
    private String firstName;

    @Column(name = "user_lastName")
    @NotEmpty(message = "*Por favor informe seu sobrenome")
    private String lastName;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_ID"), inverseJoinColumns = @JoinColumn(name = "role_ID"))
    private Set<RoleModel> roleModels;
    */
}
