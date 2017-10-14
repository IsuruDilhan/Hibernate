/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Employee;
import com.entity.Task;
import java.util.List;

/**
 *
 * @author Sarathchandra
 */
public interface TaskDao {

    /**
     * This method is used to save the task object in db
     * @param task Task object with relevant data.
     */
    public void saveTask (Task task);

    /**
     * This method is used to retrieve all the task details
     * @return List Returns all the task details.
     */
    public List<Task> showAllTasks();

    /**
     * This method is used to update the details of the given task
     * with relevant data.
     * @param id Id of the task
     * @param description Description of the task
     * @param emp Assigned employee object
     */
    public void updateTask (int id, String description, Employee emp);
}
