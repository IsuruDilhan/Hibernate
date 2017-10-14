/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Role;
import java.util.List;

/**
 *
 * @author Sarathchandra
 */
public interface RoleDao {

    /**
     * This method is used to save the given details
     * of the role in the database. 
     * @param role Role object with relevant data
     */
    public void saveRole (Role role);

    /**
     * This method is used to retrieve all
     * the role details.
     * @return List List of roles
     */
    public List<Role> showAllRoles();

    /**
     * This method is used to update the
     * role with given details.
     * @param id Id of the role
     * @param title Title of the role
     */
    public void updateRole (int id, String title);

    /**
     * This method is used to get the
     * role details of given role id
     * @param id Id of the role
     * @return Role Role object
     */
    public Role getRolebyID(int id);
}
