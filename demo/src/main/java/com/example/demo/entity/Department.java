package com.example.demo.entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer deptid;

    @Column(name="department_name")
    private String dname;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name="manager_id", referencedColumnName = "manager_id", 
    nullable = true )
    private Employee emp;

    @ManyToOne( cascade = CascadeType.MERGE)
    @JoinColumn(name="location_id", referencedColumnName = "location_id", 
    nullable = true)
    private Location loc;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }
    public Department(){

    }
    public Department(String dname, Employee emp, Location loc) {
        this.dname = dname;
        this.emp = emp;
        this.loc = loc;
    }

    public void addEmployee(Employee emp) {
        emp.add(emp);
        emp.setDep(this);
    }

    
}
