package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="EMPLOYEES")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer employee_ID;
    private Integer employee_contactID;
    private Boolean employee_status;
    private LocalDate employee_createdOn;
    private LocalDate employee_changedOn;

    public EmployeeModel() {

    }

    public EmployeeModel(Integer employee_ID, Integer employee_contactID, Boolean employee_status, LocalDate employee_createdOn, LocalDate employee_changedOn) {
        super( );
        this.employee_ID = employee_ID;
        this.employee_contactID = employee_contactID;
        this.employee_status = employee_status;
        this.employee_createdOn = employee_createdOn;
        this.employee_changedOn = employee_changedOn;
    }

    public EmployeeModel(Integer employee_contactID, Boolean employee_status, LocalDate employee_createdOn, LocalDate employee_changedOn) {
        this.employee_contactID = employee_contactID;
        this.employee_status = employee_status;
        this.employee_createdOn = employee_createdOn;
        this.employee_changedOn = employee_changedOn;
    }

    public Integer getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(Integer employee_ID) {
        this.employee_ID = employee_ID;
    }

    public Integer getEmployee_contactID() {
        return employee_contactID;
    }

    public void setEmployee_contactID(Integer employee_contactID) {
        this.employee_contactID = employee_contactID;
    }

    public Boolean getEmployee_status() {
        return employee_status;
    }

    public void setEmployee_status(Boolean employee_status) {
        this.employee_status = employee_status;
    }

    public LocalDate getEmployee_createdOn() {
        return employee_createdOn;
    }

    public void setEmployee_createdOn(LocalDate employee_createdOn) {
        this.employee_createdOn = employee_createdOn;
    }

    public LocalDate getEmployee_changedOn() {
        return employee_changedOn;
    }

    public void setEmployee_changedOn(LocalDate employee_changedOn) {
        this.employee_changedOn = employee_changedOn;
    }
}
