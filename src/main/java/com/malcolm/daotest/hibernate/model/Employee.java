/**
 * Name        : com.malcolm.daotest.hibernate.model.Employee.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Entity Model for Employee  
 */
package com.malcolm.daotest.hibernate.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity Model for Employee
 * 
 * @author Malcolm
 */
@Entity
@Table(name="employee")
public class Employee {
	/**
	 * Employee Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private Integer emp_id;

	/**
	 * Employee First Name
	 */
	@Column(name="emp_first_name")
	private String emp_first_name;

	/**
	 * Employee Last Name
	 */
	@Column(name="emp_last_name")
	private String emp_last_name;

	/**
	 * Employee Start Date
	 */
	@Column(name="emp_start_date")
	private Timestamp emp_start_date;

	/**
	 * Employee End Date
	 */
	@Column(name="emp_end_date")
	private Timestamp emp_end_date;

	/**
	 * Employee Designation Id
	 */
	@Column(name="designation_id")
	private Integer designation_id;
	
	/**
	 * Designation
	 */
	@ManyToOne
	@JoinColumn(name = "designation_id", referencedColumnName = "designation_id", insertable = false, updatable = false, nullable = true)
	private Designation designation;

	/**
	 * Employee Department Id
	 */
	@Column(name="dept_id")
	private Integer dept_id;

	/**
	 * Department
	 */
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id", insertable = false, updatable = false, nullable = true)
	private Department department;
	
	/**
	 * Employee Manager Id
	 */
	@Column(name="mgr_id")
	private Integer mgr_id;

	/**
	 * Manager
	 */
	@ManyToOne
	@JoinColumn(name = "mgr_id", referencedColumnName = "emp_id", insertable = false, updatable = false, nullable = true)
	private Employee manager;
	
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
	 * Employee Roles Assn
	 */
	@OneToMany
	@JoinColumn(name= "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private Set<RoleEmployee> employeeRoleAssn;
	   
	/**
	 * Employee Project Assn
	 */
	@OneToMany
	@JoinColumn(name= "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private Set<ProjectEmployee> employeeProjectAssn;

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
	 * @return the emp_first_name
	 */
	public String getEmp_first_name() {
		return emp_first_name;
	}

	/**
	 * @param emp_first_name the emp_first_name to set
	 */
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	/**
	 * @return the emp_last_name
	 */
	public String getEmp_last_name() {
		return emp_last_name;
	}

	/**
	 * @param emp_last_name the emp_last_name to set
	 */
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	/**
	 * @return the emp_start_date
	 */
	public Timestamp getEmp_start_date() {
		return emp_start_date;
	}

	/**
	 * @param emp_start_date the emp_start_date to set
	 */
	public void setEmp_start_date(Timestamp emp_start_date) {
		this.emp_start_date = emp_start_date;
	}

	/**
	 * @return the emp_end_date
	 */
	public Timestamp getEmp_end_date() {
		return emp_end_date;
	}

	/**
	 * @param emp_end_date the emp_end_date to set
	 */
	public void setEmp_end_date(Timestamp emp_end_date) {
		this.emp_end_date = emp_end_date;
	}

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
	 * @return the designation
	 */
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the mgr_id
	 */
	public Integer getMgr_id() {
		return mgr_id;
	}

	/**
	 * @param mgr_id the mgr_id to set
	 */
	public void setMgr_id(Integer mgr_id) {
		this.mgr_id = mgr_id;
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

	/**
	 * @return the employeeRoleAssn
	 */
	public Set<RoleEmployee> getEmployeeRoleAssn() {
		return employeeRoleAssn;
	}

	/**
	 * @param employeeRoleAssn the employeeRoleAssn to set
	 */
	public void setEmployeeRoleAssn(Set<RoleEmployee> employeeRoleAssn) {
		this.employeeRoleAssn = employeeRoleAssn;
	}

	/**
	 * @return the employeeProjectAssn
	 */
	public Set<ProjectEmployee> getEmployeeProjectAssn() {
		return employeeProjectAssn;
	}

	/**
	 * @param employeeProjectAssn the employeeProjectAssn to set
	 */
	public void setEmployeeProjectAssn(Set<ProjectEmployee> employeeProjectAssn) {
		this.employeeProjectAssn = employeeProjectAssn;
	}
}
