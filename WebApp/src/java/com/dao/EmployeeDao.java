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
 * @author VSARAIS
 */
public interface EmployeeDao {
   public void saveEmployee (Employee employee);
   public List<Employee> showAllEmployees();
   public void updateEmployee (int id, String name, Role role, Task task);
}
