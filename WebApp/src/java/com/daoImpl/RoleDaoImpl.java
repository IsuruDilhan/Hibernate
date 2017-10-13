/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImpl;

import com.dao.RoleDao;
import com.entity.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VSARAIS
 */
public class RoleDaoImpl implements RoleDao{

    @Override
    public void saveRole(Role role) {
        System.err.println("SAVE");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Role> showAllRoles() {
        List<Role> roleList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Role");
        roleList = query.list();
        return roleList;
    }

    @Override
    public void updateRole(int id, String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Role roledetails = (Role)session.load(Role.class, id);
        roledetails.setTitle(title);
        session.update(roledetails);
        transaction.commit();
        session.close();
    }
    
    
}
