/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.entity.Role;
import com.entity.Task;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VSARAIS
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void saveEmployee(Employee employee) {
        System.err.println("SAVE");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Employee");
        employeeList = query.list();
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, String name, Role role, Task task) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employeedetails = (Employee) session.load(Employee.class, id);
        employeedetails.setName(name);
        employeedetails.setRole(role);
        Set<Task> tk = new HashSet<Task>();
        tk.add(task);
        employeedetails.setTasksSet(tk);
        session.update(employeedetails);
        transaction.commit();
        session.close();
    }

}
