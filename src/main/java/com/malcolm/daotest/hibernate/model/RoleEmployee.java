/**
 * Name        : com.malcolm.daotest.hibernate.model.RoleEmployee.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for RoleEmployee  
 */
package com.malcolm.daotest.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Model for RoleEmployee
 * 
 * @author Malcolm
 */
@Entity
@Table(name="role_employee")
public class RoleEmployee {
	
	/**
	 * Role Employee Assn Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_emp_assn_id")
	private Integer role_emp_assn_id;

	/**
	 * Role Id
	 */
	@Column(name="role_id")
	private Integer role_id;
	
	/**
	 * Role
	 */
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false, nullable = true)
	private Role role;

	/**
	 * Employee Id
	 */
	@Column(name="emp_id")
	private Integer emp_id;

	/**
	 * @return the role_emp_assn_id
	 */
	public Integer getRole_emp_assn_id() {
		return role_emp_assn_id;
	}

	/**
	 * @param role_emp_assn_id the role_emp_assn_id to set
	 */
	public void setRole_emp_assn_id(Integer role_emp_assn_id) {
		this.role_emp_assn_id = role_emp_assn_id;
	}

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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the emp_id
	 */
	public Integer getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
}