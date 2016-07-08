/**
 * Name        : com.malcolm.daotest.service.bdo.ProjectBDO.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Project Business Domain Object
 */
package com.malcolm.daotest.service.bdo;

import java.io.Serializable;
import java.util.Date;

/**
 * Project Business Domain Object
 * 
 * @author Malcolm
 */
public class ProjectBDO implements Serializable{

	/**
	 *  Generated Serialized Version ID
	 */
	private static final long serialVersionUID = 8765217483018351296L;
	
	/**
	 * Project ID
	 */
	private Integer projectID;
	
	/**
	 * Project Name
	 */
	private String projectName;
	
	/**
	 * Project Description
	 */
	private String projectDesc;
	
	/**
	 * Project Manager
	 */
	private EmployeeBDO projectManager;
	
	/**
	 * Project Start Date
	 */
	private Date projectStartDate;
	
	/**
	 * Project End Date
	 */
	private Date projectEndDate;
	
	/**
	 * Update User
	 */
	private String updateUser;
	
	/**
	 * Update Date
	 */
	private Date updateDate;

	/**
	 * @return the projectID
	 */
	public Integer getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectDesc
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * @param projectDesc the projectDesc to set
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 * @return the projectManager
	 */
	public EmployeeBDO getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager the projectManager to set
	 */
	public void setProjectManager(EmployeeBDO projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the projectStartDate
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * @param projectStartDate the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * @return the projectEndDate
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * @param projectEndDate the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
