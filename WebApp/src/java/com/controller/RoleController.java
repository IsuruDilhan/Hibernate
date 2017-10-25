/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.RoleDao;
import com.daoImpl.HibernateUtil;
import com.daoImpl.RoleDaoImpl;
import com.entity.Role;
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
public class RoleController extends HttpServlet {

    Role role = new Role();
    RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
    RoleDao rdao;

    /**
     * Process HTTP GET requests.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("addRole") != null) {
            String title = request.getParameter("title");
            role.setTitle(title);
            roleDaoImpl.saveRole(role);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAllRoles.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * Process HTTP POST requests.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("updateRole") != null) {
            int id1 = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("titleupdate");
            roleDaoImpl.updateRole(id1, title);

            RequestDispatcher rd = request.getRequestDispatcher("ShowAllRoles.jsp");
            rd.forward(request, response);

        }
    }


    /**
     * This method is used to retrieve the all 
     * the details of the roles.
     * @return List All the details of roles
     */
    public static List<Role> showAllRoles() {
        List<Role> roleList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Role");
        roleList = query.list();
        return roleList;
    }
    
    /**
     * This method is used to retrieve unassigned roles
     * @return List All the details of roles
     */
    public static List showUnassignedRoles() {
        List roleList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        roleList = session.createQuery("select r from Role as r where r.id NOT IN (select e.role from Employee as e)").list();
        //roleList = query.list();
        return roleList;
    }
}
