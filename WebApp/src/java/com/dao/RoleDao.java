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
 * @author VSARAIS
 */
public interface RoleDao {
   public void saveRole (Role role);
   public List<Role> showAllRoles();
   public void updateRole (int id, String title);
}
