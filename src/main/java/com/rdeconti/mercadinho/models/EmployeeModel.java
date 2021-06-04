package com.rdeconti.mercadinho.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer employee_ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_ID")
    private Integer employee_contactID;

    @Column(name = "employee_status", length = 1, nullable = false)
    private Boolean employee_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "employee_createdOn", nullable = false)
    private java.util.Date employee_createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "employee_changedOn", nullable = false)
    private java.util.Date employee_changedOn;

    public EmployeeModel() {

    }

    public EmployeeModel(Integer employee_ID, Integer employee_contactID, Boolean employee_status, Date employee_createdOn, Date employee_changedOn) {
        super( );
        this.employee_ID = employee_ID;
        this.employee_contactID = employee_contactID;
        this.employee_status = employee_status;
        this.employee_createdOn = employee_createdOn;
        this.employee_changedOn = employee_changedOn;
    }

    public EmployeeModel(Integer employee_contactID, Boolean employee_status, Date employee_createdOn, Date employee_changedOn) {
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

    public Date getEmployee_createdOn() {
        return employee_createdOn;
    }

    public void setEmployee_createdOn(Date employee_createdOn) {
        this.employee_createdOn = employee_createdOn;
    }

    public Date getEmployee_changedOn() {
        return employee_changedOn;
    }

    public void setEmployee_changedOn(Date employee_changedOn) {
        this.employee_changedOn = employee_changedOn;
    }
}
