/**
 * Name        : com.malcolm.daotest.hibernate.model.Project.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for Project  
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
 * Entity Model for Project
 * 
 * @author Malcolm
 */
@Entity
@Table(name = "project")
public class Project {

	/**
	 * Project Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private Integer project_id;

	/**
	 * Project Name
	 */
	@Column(name = "project_name")
	private String project_name;

	/**
	 * Project Desc
	 */
	@Column(name = "project_desc")
	private String project_desc;

	/**
	 * Project Manager
	 */
	@Column(name = "project_manager")
	private Integer project_manager;

	/**
	 * Project Manager
	 */
	@ManyToOne
	@JoinColumn(name = "project_manager", referencedColumnName = "emp_id", insertable = false, updatable = false, nullable = true)
	private Employee manager;

	/**
	 * Project Start Date
	 */
	@Column(name = "project_startdate")
	private Timestamp project_startdate;

	/**
	 * Project End Date
	 */
	@Column(name = "project_enddate")
	private Timestamp project_enddate;

	/**
	 * Update User
	 */
	@Column(name = "update_user")
	private String update_user;

	/**
	 * Update Date
	 */
	@Column(name = "update_date")
	private Timestamp update_date;

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
	 * @return the project_name
	 */
	public String getProject_name() {
		return project_name;
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	/**
	 * @return the project_desc
	 */
	public String getProject_desc() {
		return project_desc;
	}

	/**
	 * @param project_desc the project_desc to set
	 */
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	/**
	 * @return the project_manager
	 */
	public Integer getProject_manager() {
		return project_manager;
	}

	/**
	 * @param project_manager the project_manager to set
	 */
	public void setProject_manager(Integer project_manager) {
		this.project_manager = project_manager;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * @return the project_startdate
	 */
	public Timestamp getProject_startdate() {
		return project_startdate;
	}

	/**
	 * @param project_startdate the project_startdate to set
	 */
	public void setProject_startdate(Timestamp project_startdate) {
		this.project_startdate = project_startdate;
	}

	/**
	 * @return the project_enddate
	 */
	public Timestamp getProject_enddate() {
		return project_enddate;
	}

	/**
	 * @param project_enddate the project_enddate to set
	 */
	public void setProject_enddate(Timestamp project_enddate) {
		this.project_enddate = project_enddate;
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
