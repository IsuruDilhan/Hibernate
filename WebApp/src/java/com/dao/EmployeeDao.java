/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Employee;
import com.entity.Role;
import com.entity.Task;
import java.util.List;

/**
 *
 * @author Sarathchandra
 */
public interface EmployeeDao {

    /**
     * This method is used to save the given details
     * of the employee in the database.
     * @param employee Employee object with relevant data
     */
    public void saveEmployee (Employee employee);

    /**
     * This method is used to retrieve the all the
     * details of the employees.
     * @return List List of Employees
     */
    public List<Employee> showAllEmployees();

    /**
     * This method is used to update the 
     * relevant employee details according to
     * the given employee id.
     * @param id Id of the employee
     * @param name Name of the employee
     * @param role Role of the employee
     * @param task Task of the employee
     */
    public void updateEmployee (int id, String name, Role role, Task task);
}
