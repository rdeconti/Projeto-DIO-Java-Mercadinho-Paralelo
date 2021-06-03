package com.rdeconti.mercadinho.models;

import com.rdeconti.mercadinho.modelsToReview.RoleModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer user_ID;
    private Integer user_contactID;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_ID"), inverseJoinColumns = @JoinColumn(name = "role_ID"))
    private Set<RoleModel> roles;

    private String user_name;
    private String user_password;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an user_email")
    private String user_email;
    private String user_firsName;
    private String user_lastName;
    private Boolean user_status;
    private LocalDate user_createdOn;
    private LocalDate user_changedOn;

    public UserModel() {

    }

    public UserModel(Set<RoleModel> roles) {
        this.roles = roles;
    }

    public UserModel(Integer user_ID, Integer user_contactID, Integer user_roleID, String user_name, String user_password, String user_email, String user_firsName, String user_lastName, Boolean user_status, LocalDate user_createdOn, LocalDate user_changedOn) {
        super();
        this.user_ID = user_ID;
        this.user_contactID = user_contactID;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_firsName = user_firsName;
        this.user_lastName = user_lastName;
        this.user_status = user_status;
        this.user_createdOn = user_createdOn;
        this.user_changedOn = user_changedOn;
    }

    public UserModel(Integer user_contactID, Integer user_roleID, String user_name, String user_password, String user_email, String user_firsName, String user_lastName, Boolean user_status, LocalDate user_createdOn, LocalDate user_changedOn) {
        this.user_contactID = user_contactID;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_firsName = user_firsName;
        this.user_lastName = user_lastName;
        this.user_status = user_status;
        this.user_createdOn = user_createdOn;
        this.user_changedOn = user_changedOn;
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

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_firsName() {
        return user_firsName;
    }

    public void setUser_firsName(String user_firsName) {
        this.user_firsName = user_firsName;
    }

    public String getUser_lastName() {
        return user_lastName;
    }

    public void setUser_lastName(String user_lastName) {
        this.user_lastName = user_lastName;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }

    public LocalDate getUser_createdOn() {
        return user_createdOn;
    }

    public void setUser_createdOn(LocalDate user_createdOn) {
        this.user_createdOn = user_createdOn;
    }

    public LocalDate getUser_changedOn() {
        return user_changedOn;
    }

    public void setUser_changedOn(LocalDate user_changedOn) {
        this.user_changedOn = user_changedOn;
    }
}
