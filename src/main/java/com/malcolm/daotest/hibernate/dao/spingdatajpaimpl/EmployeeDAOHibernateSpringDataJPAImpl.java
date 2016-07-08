/**
 * Name        : com.malcolm.daotest.hibernate.dao.spingdatajpaimpl.EmployeeDAOHibernateSpringDataJPAImpl.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Hibernate SpringData JPA Base Implementation for Employee DAO   
 */
package com.malcolm.daotest.hibernate.dao.spingdatajpaimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.malcolm.daotest.hibernate.dao.IEmployeeDAO;
import com.malcolm.daotest.hibernate.model.Employee;

@Repository
@Qualifier("employeeDAOHibernateSpringDataJPAImpl")
public class EmployeeDAOHibernateSpringDataJPAImpl implements IEmployeeDAO {
	
	@Resource  
    private EmployeeInfoRepository employeeInfoRepository;  
	
	@Override
	public List<Employee> getAllEmployeesSimple() {
		try{	
			
			return (List<Employee>)employeeInfoRepository.findAll();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getAllEmployees() {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getAllEmployees();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Integer projectId) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByProjectId(projectId);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByProjectName(String projectName) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByProjectName(projectName);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByRoleId(Integer roleId) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByRoleId(roleId);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByRoleName(String roleName) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByRoleName(roleName);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByDepartmentId(departmentId);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByDepartmentName(String departmentName) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByDepartmentName(departmentName);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByManagerId(Integer managerId) {
		try{	
			
			return (List<Employee>)employeeInfoRepository.getEmployeesByManagerId(managerId);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String employeeName) {
		try{	
			employeeName = employeeName + "%";
			return (List<Employee>)employeeInfoRepository.getEmployeesByFirstName(employeeName);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
}
