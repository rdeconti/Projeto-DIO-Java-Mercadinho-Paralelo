package com.rdeconti.mercadinho.modelsToReview;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ROLES")
public class RoleModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer role_ID;
    private String role_name;
    private Boolean role_status;
    private LocalDate role_createdOn;
    private LocalDate role_changedOn;

    public RoleModel() {

    }

    public RoleModel(Integer role_ID, String role_name, Boolean role_status, LocalDate role_createdOn, LocalDate role_changedOn) {
        super( );
        this.role_ID = role_ID;
        this.role_name = role_name;
        this.role_status = role_status;
        this.role_createdOn = role_createdOn;
        this.role_changedOn = role_changedOn;
    }

    public RoleModel(String role_name, Boolean role_status, LocalDate role_createdOn, LocalDate role_changedOn) {
        this.role_name = role_name;
        this.role_status = role_status;
        this.role_createdOn = role_createdOn;
        this.role_changedOn = role_changedOn;
    }

    public Integer getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(Integer role_ID) {
        this.role_ID = role_ID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Boolean getRole_status() {
        return role_status;
    }

    public void setRole_status(Boolean role_status) {
        this.role_status = role_status;
    }

    public LocalDate getRole_createdOn() {
        return role_createdOn;
    }

    public void setRole_createdOn(LocalDate role_createdOn) {
        this.role_createdOn = role_createdOn;
    }

    public LocalDate getRole_changedOn() {
        return role_changedOn;
    }

    public void setRole_changedOn(LocalDate role_changedOn) {
        this.role_changedOn = role_changedOn;
    }
}
