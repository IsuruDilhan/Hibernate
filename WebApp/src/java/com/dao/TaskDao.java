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
 * @author VSARAIS
 */
public interface TaskDao {
   public void saveTask (Task task);
   public List<Task> showAllTasks();
   public void updateTask (int id, String description, Employee emp);
}
