/**
 * Name        : com.malcolm.daotest.service.bdo.DesignationBDO.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Designation Business Domain Object
 */
package com.malcolm.daotest.service.bdo;

import java.io.Serializable;

/**
 * Designation Business Domain Object
 * 
 * @author Malcolm
 */
public class DesignationBDO implements Serializable{

	/**
	 * Generated Serialized Version ID
	 */
	private static final long serialVersionUID = -3856796297226037806L;
	
	/**
	 * Designation ID
	 */
	private Integer designationID;
	
	/**
	 * Designation Name
	 */
	private String designationName;
	
	/**
	 * Designation Desc
	 */
	private String designationDesc;

	/**
	 * @return the designationID
	 */
	public Integer getDesignationID() {
		return designationID;
	}

	/**
	 * @param designationID the designationID to set
	 */
	public void setDesignationID(Integer designationID) {
		this.designationID = designationID;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * @return the designationDesc
	 */
	public String getDesignationDesc() {
		return designationDesc;
	}

	/**
	 * @param designationDesc the designationDesc to set
	 */
	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}
	
}
