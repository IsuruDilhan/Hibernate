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
 * @author VSARAIS
 */
public class RoleController extends HttpServlet{
   Role role = new Role();
        RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
        RoleDao rdao;
       
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addRole")!=null){
            String title = request.getParameter("title");
            role.setTitle(title);
            roleDaoImpl.saveRole(role);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAllRoles.jsp");
            rd.forward(request, response);
        }
          
        
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showRole")!=null){
            List<Role> roleList = new ArrayList();
            roleList = roleDaoImpl.showAllRoles();
            request.setAttribute("roleList", roleList);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAllRoles.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateRole")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String title = request.getParameter("titleupdate");
             roleDaoImpl.updateRole(id1, title);
             
             RequestDispatcher rd = request.getRequestDispatcher("ShowAllRoles.jsp");
             rd.forward(request, response);
             
         }
    }
 
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  
    
    public static List<Role> showAllRoles() {
        List<Role> roleList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Role");
        roleList = query.list();
        return roleList;
    }
}
