package com.rdeconti.mercadinho.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="STORES")
public class StoreModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "store_ID", nullable = false)
    private Long id;

    @Column(name = "store_name")
    @Size(min = 2, max = 100, message = "*O nome deve ter deve ter de 2 até 100 caracteres")
    @NotEmpty(message = "*Por favor informe o nome do loja")
    private String name;

    @Column(name = "store_email")
    @Email(message = "*Por favor informe e-mail válido")
    @NotEmpty(message = "*Por favor informe o e-mail do loja")
    private String email;

    @Column(name = "store_address")
    @Size(min = 2, max = 1000, message = "*O nome deve ter deve ter de 2 até 1000 caracteres")
    @NotEmpty(message = "*Por favor informe o endereço do loja")
    private String address;

    @Column(name = "store_cep")
    @Pattern(regexp="\\d{5}-\\d{3}")
    @NotEmpty(message = "*Por favor informe o CEP do loja")
    private String cep;

    @Column(name = "store_phone")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o telefone do loja")
    private String phone;

    @Column(name = "store_whats")
    @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
    @NotEmpty(message = "*Por favor informe o whatsApp do loja")
    private String whats;

    @Column(name = "store_document")
    @CNPJ(message = "*Por favor informe CNPJ válido")
    @NotEmpty(message = "*Por favor informe o CNPJ do loja")
    private String cnpj;

    @Column(name = "store_note")
    @NotEmpty(message = "*Por favor informe observações da loja")
    private String note;

    @NotEmpty(message = "*Por favor informar a situação")
    @Column(name = "store_status")
    private Boolean status = true;

    @NotEmpty(message = "*Por favor informar a data de criação")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_created_at")
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar a data de alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_changed_at")
    private LocalDateTime changedDate = LocalDateTime.now();

    @NotEmpty(message = "*Por favor informar usuário responsável pela criação")
    @Column(name = "store_created_by")
    private String createdUser;

    @NotEmpty(message = "*Por favor informar usuário responsável pela alteração")
    @DateTimeFormat(pattern="dd-MMM-yyyy")
    @Column(name = "store_changed_by")
    private String changedUser;

}
