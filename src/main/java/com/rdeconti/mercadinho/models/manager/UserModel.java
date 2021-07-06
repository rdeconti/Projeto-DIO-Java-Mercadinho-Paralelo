package com.rdeconti.mercadinho.models.manager;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

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

    @Column(name = "user_code")
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

    @Column(name = "user_role")
    @NotEmpty(message = "*Por favor informe a função do usuário")
    private String role;

    @Column(name = "user_name")
    @NotEmpty(message = "*Por favor informe o nome do usuário")
    private String fullName;

    @Column(name = "user_type")
    @NotEmpty(message = "*Por favor informe o tipo de usuário")
    private Integer type;

    @Column(name = "user_link")
    @NotEmpty(message = "*Por favor informe o código: cliente ou funcionário")
    private String link;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "user_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_changed_at")
    private LocalDateTime changed_at = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar o responsável pela criação")
    @Column(name = "user_created_by")
    private String created_by;

    @NotEmpty(message = "*Por favor informar o responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_changed_by")
    private String changed_by;

}
