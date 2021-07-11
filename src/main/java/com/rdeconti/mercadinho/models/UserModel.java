package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Size(min = 2, max = 100, message = "*O nome deve ter deve ter de 2 até 100 caracteres")
    @NotEmpty(message = "*Por favor informe o nome do usuário")
    private String name;

    @Column(name = "user_address")
    @Size(min = 2, max = 1000, message = "*O nome deve ter deve ter de 2 até 1000 caracteres")
    @NotEmpty(message = "*Por favor informe o endereço do usuário")
    private String address;

    @Column(name = "user_cep")
    @Pattern(regexp="\\d{5}-\\d{3}")
    @NotEmpty(message = "*Por favor informe o CEP do usuário")
    private String cep;

    @Column(name = "user_phone")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o telefone do usuário")
    private String phone;

    @Column(name = "user_whats")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o whatsApp do usuário")
    private String whats;

    @Column(name = "user_document")
    @CPF(message = "*Por favor informe CPF válido")
    @NotEmpty(message = "*Por favor informe o CPF do usuário")
    private String cpf;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "user_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_created_at")
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_changed_at")
    private LocalDateTime changedDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar usuário responsável pela criação")
    @Column(name = "user_created_by")
    private String createdUser;

    @NotEmpty(message = "*Por favor informar usuário responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "user_changed_by")
    private String changedUser;

}
