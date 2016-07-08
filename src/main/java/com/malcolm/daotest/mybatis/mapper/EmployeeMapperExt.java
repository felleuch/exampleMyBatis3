/**
 * Name        : com.malcolm.daotest.mybatis.mapper.EmployeeMapperExt.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Extension for Employee MyBatis Mapper 
 */
package com.malcolm.daotest.mybatis.mapper;

import java.util.List;

import com.malcolm.daotest.mybatis.model.Employee;

/**
 * Extension for Employee MyBatis Mapper
 * 
 * @author Malcolm
 */
public interface EmployeeMapperExt {
	
	/**
	 * Get All Employee No Associations, Simple Get all Employee
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployeesSimple();
	
	/**
	 * Get All Employee
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * Get Employees By Project ID
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByProjectId(Integer projectId);
	
	/**
	 * Get Employees By Project Name
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByProjectName(String projectName);
	
	/**
	 * Get Employees By Role Id
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByRoleId(Integer roleId);
	
	/**
	 * Get Employees By Role Name
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByRoleName(String roleName);
	
	/**
	 * Get Employees By Department Id
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByDepartmentId(Integer departmentId);
	
	/**
	 * Get Employees By Department Name
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByDepartmentName(String departmentName);
	
	/**
	 * Get Employees By Manager Id
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByManagerId(Integer managerId);
	
	/**
	 * Get Employees By Matching on Employee First Name Only Using Like
	 * 
	 * @return
	 */
	public List<Employee> getEmployeesByFirstName(String employeeName);
	
}
