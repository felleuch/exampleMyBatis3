/**
 * Name        : com.malcolm.daotest.hibernate.model.Role.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for Role  
 */
package com.malcolm.daotest.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Model for Role
 * 
 * @author Malcolm
 */
@Entity
@Table(name="role")
public class Role {
	
	/**
	 * Role Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Integer role_id;

	/**
	 * Role Name
	 */
	@Column(name="role_name")
	private String role_name;

	/**
	 * Role Desc
	 */
	@Column(name="role_desc")
	private String role_desc;

	/**
	 * @return the role_id
	 */
	public Integer getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	/**
	 * @return the role_desc
	 */
	public String getRole_desc() {
		return role_desc;
	}

	/**
	 * @param role_desc the role_desc to set
	 */
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

}
