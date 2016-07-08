/**
 * Name        : com.malcolm.daotest.service.bdo.EmployeeBDO.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Employee Business Domain Object
 */
package com.malcolm.daotest.service.bdo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Employee Business Domain Object
 * 
 * @author Malcolm
 *
 */
public class EmployeeBDO implements Serializable{

	/**
	 * Generated Serialized Version ID
	 */
	private static final long serialVersionUID = -5078090538343005689L;
	
	/**
	 * Employee ID
	 */
	private Integer employeeID;
	
	/**
	 * Employee First Name
	 */
	private String employeeFirstName;
	
	/**
	 * Employee Last Name
	 */
	private String employeeLastName;
	
	/**
	 * Employee Start Date
	 */
	private Date employeeStartDate;
	
	/**
	 * Employee End Date
	 */
	private Date employeeEndDate;
	
	/**
	 * Employee Designation
	 */
	private DesignationBDO employeeDesignation;
	
	/**
	 * Employee Department
	 */
	private DepartmentBDO employeeDepartment;
	
	/**
	 * Employee Manager
	 */
	private EmployeeBDO employeeManager;
	
	/**
	 * Update User
	 */
	private String updateUser;
	
	/**
	 * Update Date
	 */
	private Date updateDate;
	
	/**
	 * Employee Roles
	 */
	private List<RoleBDO> employeeRoles;
	
	/**
	 * Employee Projects
	 */
	private List<ProjectBDO> employeeProjects;

	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the employeeFirstName
	 */
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	/**
	 * @param employeeFirstName the employeeFirstName to set
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	/**
	 * @return the employeeLastName
	 */
	public String getEmployeeLastName() {
		return employeeLastName;
	}

	/**
	 * @param employeeLastName the employeeLastName to set
	 */
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	/**
	 * @return the employeeStartDate
	 */
	public Date getEmployeeStartDate() {
		return employeeStartDate;
	}

	/**
	 * @param employeeStartDate the employeeStartDate to set
	 */
	public void setEmployeeStartDate(Date employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}

	/**
	 * @return the employeeEndDate
	 */
	public Date getEmployeeEndDate() {
		return employeeEndDate;
	}

	/**
	 * @param employeeEndDate the employeeEndDate to set
	 */
	public void setEmployeeEndDate(Date employeeEndDate) {
		this.employeeEndDate = employeeEndDate;
	}

	/**
	 * @return the employeeDesignation
	 */
	public DesignationBDO getEmployeeDesignation() {
		return employeeDesignation;
	}

	/**
	 * @param employeeDesignation the employeeDesignation to set
	 */
	public void setEmployeeDesignation(DesignationBDO employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	/**
	 * @return the employeeDepartment
	 */
	public DepartmentBDO getEmployeeDepartment() {
		return employeeDepartment;
	}

	/**
	 * @param employeeDepartment the employeeDepartment to set
	 */
	public void setEmployeeDepartment(DepartmentBDO employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	/**
	 * @return the employeeManager
	 */
	public EmployeeBDO getEmployeeManager() {
		return employeeManager;
	}

	/**
	 * @param employeeManager the employeeManager to set
	 */
	public void setEmployeeManager(EmployeeBDO employeeManager) {
		this.employeeManager = employeeManager;
	}

	/**
	 * @return the employeeRoles
	 */
	public List<RoleBDO> getEmployeeRoles() {
		return employeeRoles;
	}

	/**
	 * @param employeeRoles the employeeRoles to set
	 */
	public void setEmployeeRoles(List<RoleBDO> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

	/**
	 * @return the employeeProjects
	 */
	public List<ProjectBDO> getEmployeeProjects() {
		return employeeProjects;
	}

	/**
	 * @param employeeProjects the employeeProjects to set
	 */
	public void setEmployeeProjects(List<ProjectBDO> employeeProjects) {
		this.employeeProjects = employeeProjects;
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


