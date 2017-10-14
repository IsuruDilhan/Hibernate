/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.RoleDao;
import com.daoImpl.HibernateUtil;
import com.daoImpl.TaskDaoImpl;
import com.entity.Employee;
import com.entity.Role;
import com.entity.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author VSARAIS
 */
public class TaskController extends HttpServlet {

    Task task = new Task();
    TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
    RoleDao rdao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("addTask") != null) {
            String description = request.getParameter("description");
            task.setDescription(description);
            taskDaoImpl.saveTask(task);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAllTasks.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("updateTask") != null) {
            int id1 = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("descriptionupdate");
            int empid1 = Integer.parseInt(request.getParameter("empid").trim());
            Employee emp = new Employee();
            emp.setEmployeeID(empid1);
            taskDaoImpl.updateTask(id1, description, emp);

            RequestDispatcher rd = request.getRequestDispatcher("ShowAllTasks.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  

    public static List<Task> showAllTasks() {
        List<Task> taskList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Task");
        taskList = query.list();
        return taskList;
    }
}
