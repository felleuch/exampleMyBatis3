/**
 * Name        : com.malcolm.daotest.service.mybatis.EmployeeServiceMyBatisImpl.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Employee Service MyBatis DAO Based Implementation 
 */
package com.malcolm.daotest.service.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malcolm.daotest.mybatis.MyBatisModelMapper;
import com.malcolm.daotest.mybatis.dao.EmployeeDAO;
import com.malcolm.daotest.mybatis.model.Employee;
import com.malcolm.daotest.service.IEmployeeService;
import com.malcolm.daotest.service.bdo.EmployeeBDO;

/**
 * Employee Service MyBatis DAO Based Implementation
 * 
 * @author Malcolm
 */
@Service
@Transactional
@Qualifier("employeeServiceMyBatisImpl")
public class EmployeeServiceMyBatisImpl implements IEmployeeService {
	
	@Autowired
	@Qualifier("employeeDAO")
	private EmployeeDAO dao;
	
	@Override
	public List<EmployeeBDO> getAllEmployeesSimple() {
		List<Employee> 	employeeInfoList 	  = dao.getAllEmployeesSimple();
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getAllEmployees() {
		List<Employee> 	employeeInfoList 	  = dao.getAllEmployees();
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByProjectId(Integer projectId) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByProjectId(projectId);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByProjectName(String projectName) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByProjectName(projectName);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByRoleId(Integer roleId) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByRoleId(roleId);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByRoleName(String roleName) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByRoleName(roleName);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByDepartmentId(Integer departmentId) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByDepartmentId(departmentId);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByDepartmentName(String departmentName) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByDepartmentName(departmentName);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByManagerId(Integer managerId) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByManagerId(managerId);
		return mapEmployeeBDO(employeeInfoList);
	}

	@Override
	public List<EmployeeBDO> getEmployeesByFirstName(String employeeName) {
		List<Employee> 	employeeInfoList 	  = dao.getEmployeesByFirstName(employeeName);
		return mapEmployeeBDO(employeeInfoList);
	}
	
	/**
	 * Map Employee BDO List 
	 * 
	 * @param employeeInfoList
	 * @return
	 */
	private List<EmployeeBDO> mapEmployeeBDO(List<Employee> employeeInfoList) {
		List<EmployeeBDO> employeeInfoBDOList = new ArrayList<EmployeeBDO>();
		for (Employee employee : employeeInfoList) {
			employeeInfoBDOList.add(MyBatisModelMapper.mapEmployeeBDO(employee));
		}
		return employeeInfoBDOList;
	}
}
