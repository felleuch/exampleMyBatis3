/**
 * Name        : com.malcolm.daotest.hibernate.model.Department.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for Department 
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
 * Entity Model for Department
 * 
 * @author Malcolm
 */
@Entity
@Table(name="department")
public class Department {
	
	/**
	 * Department ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dept_id")
	private Integer dept_id;

	/**
	 * Department Name
	 */
	@Column(name="dept_name")
	private String dept_name;

	/**
	 * Department Desc
	 */
	@Column(name="dept_desc")
	private String dept_desc;

	/**
	 * Department Manager
	 */
	@Column(name="dept_mgr")
	private Integer dept_mgr;
	
	/**
	 * Department Manager
	 */
	@ManyToOne
	@JoinColumn(name = "dept_mgr", referencedColumnName = "emp_id", insertable = false, updatable = false, nullable = true)
    private Employee deptManager;

	/**
	 * @return the dept_id
	 */
	public Integer getDept_id() {
		return dept_id;
	}

	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	/**
	 * @return the dept_name
	 */
	public String getDept_name() {
		return dept_name;
	}

	/**
	 * @param dept_name the dept_name to set
	 */
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * @return the dept_desc
	 */
	public String getDept_desc() {
		return dept_desc;
	}

	/**
	 * @param dept_desc the dept_desc to set
	 */
	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	/**
	 * @return the dept_mgr
	 */
	public Integer getDept_mgr() {
		return dept_mgr;
	}

	/**
	 * @param dept_mgr the dept_mgr to set
	 */
	public void setDept_mgr(Integer dept_mgr) {
		this.dept_mgr = dept_mgr;
	}

	/**
	 * @return the deptManager
	 */
	public Employee getDeptManager() {
		return deptManager;
	}

	/**
	 * @param deptManager the deptManager to set
	 */
	public void setDeptManager(Employee deptManager) {
		this.deptManager = deptManager;
	} 
}
