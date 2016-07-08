/**
 * Name        : com.malcolm.daotest.hibernate.model.ProjectEmployee.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for ProjectEmployee   
 *               
 */
package com.malcolm.daotest.hibernate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Model for ProjectEmployee
 * 
 * @author Malcolm
 */
@Entity
@Table(name="project_employee")
public class ProjectEmployee {

	/**
	 * Project Employee Assn Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_emp_assn_id")
	private Integer project_emp_assn_id;

	/**
	 * Project Id
	 */
	@Column(name="project_id")
	private Integer project_id;
	
	/**
	 * Project
	 */
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false, nullable = true)
	private Project project;
	
	/**
	 * Employee Id
	 */
	@Column(name="emp_id")
	private Integer emp_id;

	/**
	 * Update User
	 */
	@Column(name="update_user")
	private String update_user;

	/**
	 * Update Date
	 */
	@Column(name="update_date")
	private Timestamp update_date;

	/**
	 * @return the project_emp_assn_id
	 */
	public Integer getProject_emp_assn_id() {
		return project_emp_assn_id;
	}

	/**
	 * @param project_emp_assn_id the project_emp_assn_id to set
	 */
	public void setProject_emp_assn_id(Integer project_emp_assn_id) {
		this.project_emp_assn_id = project_emp_assn_id;
	}

	/**
	 * @return the project_id
	 */
	public Integer getProject_id() {
		return project_id;
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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

	/**
	 * @return the update_user
	 */
	public String getUpdate_user() {
		return update_user;
	}

	/**
	 * @param update_user the update_user to set
	 */
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	/**
	 * @return the update_date
	 */
	public Timestamp getUpdate_date() {
		return update_date;
	}

	/**
	 * @param update_date the update_date to set
	 */
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
}
