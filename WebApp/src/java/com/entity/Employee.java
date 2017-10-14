/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author VSARAIS
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
    private int employeeID;
    private String name;
    private Role role;
    private Set<Task> tasksSet = new HashSet<Task>(0);

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "EMPLOYEEID", unique = true, nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Task.class ,mappedBy = "employee")
    public Set<Task> getTasksSet() {
        return tasksSet;
    }

    public void setTasksSet(Set<Task> tasksSet) {
        this.tasksSet = tasksSet;
    }
    
}
