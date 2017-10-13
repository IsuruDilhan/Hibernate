/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.TaskDao;
import com.entity.Employee;
import com.entity.Task;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VSARAIS
 */
public class TaskDaoImpl implements TaskDao{

    @Override
    public void saveTask(Task task) {
        System.err.println("SAVE");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Task> showAllTasks() {
        List<Task> taskList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Task");
        taskList = query.list();
        return taskList;
    }

    @Override
    public void updateTask(int id, String description, Employee emp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Task taskdetails = (Task)session.load(Task.class, id);
        taskdetails.setDescription(description);
        taskdetails.setEmployee(emp);
        session.update(taskdetails);
        transaction.commit();
        session.close();
    }
    
    
}
