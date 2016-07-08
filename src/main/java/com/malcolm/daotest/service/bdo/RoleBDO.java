/**
 * Name        : com.malcolm.daotest.service.bdo.RoleBDO.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Role Business Domain Object 
 */
package com.malcolm.daotest.service.bdo;

import java.io.Serializable;

/**
 * Role Business Domain Object 
 * 
 * @author Malcolm
 */
public class RoleBDO implements Serializable{

	/**
	 *  Generated Serialized Version ID
	 */
	private static final long serialVersionUID = 1185464035037127763L;

	/**
	 * Role ID
	 */
	private Integer roleID;
	
	/**
	 * Role Name
	 */
	private String roleName;
	
	/**
	 * Role Description
	 */
	private String roleDesc;

	/**
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
