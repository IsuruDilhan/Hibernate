/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.EmployeeDao;
import com.dao.RoleDao;
import com.daoImpl.EmployeeDaoImpl;
import com.daoImpl.HibernateUtil;
import com.daoImpl.RoleDaoImpl;
import com.entity.Employee;
import com.entity.Role;
import com.entity.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sarathchandra
 */
public class EmployeeController extends HttpServlet {

    Employee emp = new Employee();
    EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
    EmployeeDao edao;

    Role role = new Role();
    RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
    RoleDao rdao;

    /**
     * Process HTTP Get requests
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("addEmployee") != null) {
            String name = request.getParameter("name");
            emp.setName(name);

            int roleid1 = Integer.parseInt(request.getParameter("roleid").trim());
            role = roleDaoImpl.getRolebyID(roleid1);
            emp.setRole(role);

            empDaoImpl.saveEmployee(emp);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAllEmployees.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * Process HTTP Post requests
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("updateEmployee") != null) {
            int id1 = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("nameupdate");
            int roleid1 = Integer.parseInt(request.getParameter("roleid").trim());
            role = roleDaoImpl.getRolebyID(roleid1);

            Task tk = new Task();
            tk.setTaskID(1);
            empDaoImpl.updateEmployee(id1, name, role, tk);

            RequestDispatcher rd = request.getRequestDispatcher("ShowAllEmployees.jsp");
            rd.forward(request, response);

        }
    }


    /**
     * This method is used to retrieve all the employee details
     * @return List Employee details
     */
    public static List<Employee> showAllEmployees() {
        List<Employee> employeeList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Employee");
        employeeList = query.list();
        return employeeList;
    }
}
