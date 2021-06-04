package com.rdeconti.mercadinho.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="USERS")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer user_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_ID")
    private Integer user_contactID;

    @NotEmpty(message = "*Por favor informar a função do usuário")
    @Column(name = "user_role", length = 20, nullable = false)
    private String user_role;

    @NotEmpty(message = "*Por favor informar o nome de login do usuário")
    @Size(min = 10, max = 20)
    @Column(name = "user_name", nullable = false)
    private String user_name;

    @NotEmpty(message = "*Por favor informar a senha do usuário")
    @Column(name = "user_password", length = 128, nullable = false)
    private String user_password;

    @Column(name = "user_status", length = 1, nullable = false)
    private Boolean user_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "user_createdOn", nullable = false)
    private java.util.Date user_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "user_changedOn", nullable = false)
    private java.util.Date user_changedOn;

    public UserModel() {

    }

    public UserModel(Integer user_ID, Integer user_contactID, String user_role, String user_name, String user_password, Boolean user_status, Date user_createdOn, Date user_changedOn) {
        super();
        this.user_ID = user_ID;
        this.user_contactID = user_contactID;
        this.user_role = user_role;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_status = user_status;
        this.user_createdOn = user_createdOn;
        this.user_changedOn = user_changedOn;
    }

    public UserModel(Integer user_contactID, String user_role, String user_name, String user_password, Boolean user_status, Date user_createdOn, Date user_changedOn) {
        this.user_contactID = user_contactID;
        this.user_role = user_role;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_status = user_status;
        this.user_createdOn = user_createdOn;
        this.user_changedOn = user_changedOn;
    }

    public UserModel(String user_name, String user_password, boolean enabled, boolean userNonExpired, boolean credentialsNonExpired, boolean userNonLocked, List<GrantedAuthority> grantList) {
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public Integer getUser_contactID() {
        return user_contactID;
    }

    public void setUser_contactID(Integer user_contactID) {
        this.user_contactID = user_contactID;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }

    public Date getUser_createdOn() {
        return user_createdOn;
    }

    public void setUser_createdOn(Date user_createdOn) {
        this.user_createdOn = user_createdOn;
    }

    public Date getUser_changedOn() {
        return user_changedOn;
    }

    public void setUser_changedOn(Date user_changedOn) {
        this.user_changedOn = user_changedOn;
    }

    @Override
    public String toString() {
        return "[" + this.user_name + "," + this.user_password + "," + this.user_role + "]";
    }
}
