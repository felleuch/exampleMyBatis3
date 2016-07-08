/**
 * Name        : com.malcolm.daotest.hibernate.model.Designation.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for Designation 
 */
package com.malcolm.daotest.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Model for Designation
 * 
 * @author Malcolm
 */
@Entity
@Table(name="designation")
public class Designation {
	
	/**
	 * Designation Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="designation_id")
	private Integer designation_id;

	/**
	 * Designation Name
	 */
	@Column(name="designation_name")
	private String designation_name;

	/**
	 * Designation Desc
	 */
	@Column(name="designation_desc")
	private String designation_desc;

	/**
	 * @return the designation_id
	 */
	public Integer getDesignation_id() {
		return designation_id;
	}

	/**
	 * @param designation_id the designation_id to set
	 */
	public void setDesignation_id(Integer designation_id) {
		this.designation_id = designation_id;
	}

	/**
	 * @return the designation_name
	 */
	public String getDesignation_name() {
		return designation_name;
	}

	/**
	 * @param designation_name the designation_name to set
	 */
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	/**
	 * @return the designation_desc
	 */
	public String getDesignation_desc() {
		return designation_desc;
	}

	/**
	 * @param designation_desc the designation_desc to set
	 */
	public void setDesignation_desc(String designation_desc) {
		this.designation_desc = designation_desc;
	}

}
