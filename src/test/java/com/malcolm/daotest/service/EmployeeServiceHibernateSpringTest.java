/**
 * Name        : com.malcolm.daotest.service.EmployeeServiceHibernateSpringTest.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Testcase for Employee Service Using Native Hibernate Session Factory 
 */
package com.malcolm.daotest.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.malcolm.daotest.hibernate.HibernateDAOConfig;
import com.malcolm.daotest.service.bdo.EmployeeBDO;
import com.malcolm.daotest.service.bdo.ProjectBDO;
import com.malcolm.daotest.service.bdo.RoleBDO;

/**
 * Testcase for Employee Service Using Native Hibernate Session Factory
 * 
 * @author Malcolm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateDAOConfig.class})
@Transactional
public class EmployeeServiceHibernateSpringTest {

	@Autowired
	@Qualifier("employeeServiceHibernateImpl")
	private IEmployeeService serviceHibernate;
	
	@Test
	public void getAllEmployeesSimpleHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getAllEmployeesSimple();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
	}
	
	@Test
	public void getAllEmployeesHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectIdHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByProjectId(1);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByProjectNameHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByProjectName("Apricot-DEV");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByRoleIdHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByRoleId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	
	@Test
	public void getEmployeesByRoleNameHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByRoleName("BUSINESS ANALYST");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByDepartmentIdHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByDepartmentId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByDepartmentNameHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByDepartmentName("DEVELOPMENT");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByManagerIdHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByManagerId(24);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(4));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByFirstNameHibernate() {
		assertNotNull("Employee Service not injected ",serviceHibernate);
		List<EmployeeBDO>  employeeList = serviceHibernate.getEmployeesByFirstName("a develo");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(9));
		validateEmployeeList(employeeList);
	}
	
	/**
	 * Validate Employee List
	 * 
	 * @param employeeList
	 */
	private void validateEmployeeList(List<EmployeeBDO> employeeList) {
		for (EmployeeBDO employee : employeeList) {
			if(employee.getEmployeeDepartment() != null ){
				assertNotNull("Employee Department Name not valid ",employee.getEmployeeDepartment().getDepartmentName());
				assertNotNull("Employee Department Desc not valid ",employee.getEmployeeDepartment().getDepartmentDesc());
			}else{
				if(employee.getEmployeeDesignation() != null){
					assertThat(employee.getEmployeeDesignation().getDesignationID(), equalTo(12));
				}	
			}
			if(employee.getEmployeeManager() != null ){
				assertNotNull("Employee Manager First  Name not valid ",employee.getEmployeeManager().getEmployeeFirstName());
				assertNotNull("Employee Manager Last Name not valid ",employee.getEmployeeManager().getEmployeeLastName());
			}else{
				if(employee.getEmployeeDesignation() != null){
					assertThat(employee.getEmployeeDesignation().getDesignationID(), equalTo(12));
				}
			}
			if(employee.getEmployeeDesignation() != null ){
				assertNotNull("Employee Designation Name not valid ",employee.getEmployeeDesignation().getDesignationName());
			}else{
				if(employee.getEmployeeDesignation() != null){
					assertThat(employee.getEmployeeDesignation().getDesignationID(), equalTo(12));
				}
			}
			
			if(employee.getEmployeeProjects() != null ){
				List<ProjectBDO> projectAssnList = employee.getEmployeeProjects();
				for (ProjectBDO project : projectAssnList) {
					assertNotNull("Employee Project  Name not valid ",project.getProjectName());
					assertNotNull("Employee Project Desc not valid ",project.getProjectDesc());
				}
			}else{
				if(employee.getEmployeeDesignation() != null){
					assertThat(employee.getEmployeeDesignation().getDesignationID(), equalTo(12));
				}
			}
			
			if(employee.getEmployeeRoles() != null ){
				List<RoleBDO> roleAssnList = employee.getEmployeeRoles();
				for (RoleBDO role : roleAssnList) {
					assertNotNull("Employee Role Name not valid ",role.getRoleName());
					assertNotNull("Employee Role Desc not valid ",role.getRoleDesc());
				}
			}
		}
	}
	
}
