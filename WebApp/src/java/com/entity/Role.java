/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Sarathchandra
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable{
    int id;
    String title;
 
    /**
     * Getter of role id.
     * @return int Roleid
     */
    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "ROLEID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    /**
     * Setter of the role id.
     * @param id Id of the role
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter of the role title.
     * @return String Title of the role
     */
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    /**
     * Setter of the role title.
     * @param title Title of the role
     */
    public void setTitle(String title) {
        this.title = title;
    }
   
}
