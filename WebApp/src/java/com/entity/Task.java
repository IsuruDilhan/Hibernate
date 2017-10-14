/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Sarathchandra
 */
@Entity
@Table(name = "TASK")
public class Task implements Serializable {
    private int taskID;
    private Employee employee;
    private String description;

    /**
     * Getter of task id.
     * @return int Id of the task
     */
    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "TASKID", unique = true, nullable = false)
    public int getTaskID() {
        return taskID;
    }

    /**
     * Setter of task id.
     * @param taskID Id of the task
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * Getter of assigned employee of the task.
     * @return Employee Assigned employee
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", nullable = true)
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Setter of assigned employee of the task.
     * @param employee Assigned employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Getter of the task description.
     * @return String Task description
     */
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    /**
     * Setter of the task description.
     * @param description Task description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}