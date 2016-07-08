/**
 * Name        : com.malcolm.daotest.service.IEmployeeService.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Interface for Employee Service 
 */
package com.malcolm.daotest.service;

import java.util.List;

import com.malcolm.daotest.service.bdo.EmployeeBDO;

/**
 * Interface for Employee Service
 * 
 * @author Malcolm
 */
public interface IEmployeeService {

	/**
	 * Get All Employee No Associations, Simple Get all Employee
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getAllEmployeesSimple();
	
	/**
	 * Get All Employee
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getAllEmployees();
	
	/**
	 * Get Employees By Project ID
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByProjectId(Integer projectId);
	
	/**
	 * Get Employees By Project Name
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByProjectName(String projectName);
	
	/**
	 * Get Employees By Role Id
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByRoleId(Integer roleId);
	
	/**
	 * Get Employees By Role Name
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByRoleName(String roleName);
	
	/**
	 * Get Employees By Department Id
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByDepartmentId(Integer departmentId);
	
	/**
	 * Get Employees By Department Name
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByDepartmentName(String departmentName);
	
	/**
	 * Get Employees By Manager Id
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByManagerId(Integer managerId);
	
	/**
	 * Get Employees By Matching on Employee First Name Only Using Like
	 * 
	 * @return
	 */
	public List<EmployeeBDO> getEmployeesByFirstName(String employeeName);
}
