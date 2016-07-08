/**
 * Name        : com.malcolm.daotest.service.bdo.DepartmentBDO.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Department Business Domain Object
 */
package com.malcolm.daotest.service.bdo;

import java.io.Serializable;

/**
 * Department Business Domain Object
 * 
 * @author Malcolm
 */
public class DepartmentBDO implements Serializable{
	/**
	 * Generated Serialized Version ID
	 */
	private static final long serialVersionUID = -2401014253387075606L;
	
	/**
	 * Department ID
	 */
	private Integer departmentID;
	
	/**
	 * Department Name
	 */
	private String departmentName;
	
	/**
	 * Department Desc
	 */
	private String departmentDesc;
	
	/**
	 * Department Manager
	 */
	private EmployeeBDO departmentManager;

	/**
	 * @return the departmentID
	 */
	public Integer getDepartmentID() {
		return departmentID;
	}

	/**
	 * @param departmentID the departmentID to set
	 */
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the departmentDesc
	 */
	public String getDepartmentDesc() {
		return departmentDesc;
	}

	/**
	 * @param departmentDesc the departmentDesc to set
	 */
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	/**
	 * @return the departmentManager
	 */
	public EmployeeBDO getDepartmentManager() {
		return departmentManager;
	}

	/**
	 * @param departmentManager the departmentManager to set
	 */
	public void setDepartmentManager(EmployeeBDO departmentManager) {
		this.departmentManager = departmentManager;
	}
}
