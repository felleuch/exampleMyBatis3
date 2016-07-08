/**
 * Name        : com.malcolm.daotest.service.EmployeeServiceSpringTest.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Testcase for Employee Service 
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

import com.malcolm.daotest.hibernate.HibernateDAOJPAConfig;
import com.malcolm.daotest.hibernate.HibernateDAOSpringDataJPAConfig;
import com.malcolm.daotest.mybatis.MyBatisDAOConfig;
import com.malcolm.daotest.service.bdo.EmployeeBDO;
import com.malcolm.daotest.service.bdo.ProjectBDO;
import com.malcolm.daotest.service.bdo.RoleBDO;

/**
 * Testcase for Employee Service
 * 
 * @author Malcolm
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBatisDAOConfig.class,HibernateDAOJPAConfig.class,HibernateDAOSpringDataJPAConfig.class})
@Transactional
public class EmployeeServiceSpringTest {
	
	@Autowired
	@Qualifier("employeeServiceMyBatisImpl")
	private IEmployeeService serviceMyBatis;
	
	@Autowired
	@Qualifier("employeeServiceHibernateJPAImpl")
	private IEmployeeService serviceHibernateJPA;
	
	@Autowired
	@Qualifier("employeeServiceHibernateSpringDataJPAImpl")
	private IEmployeeService serviceHibernateSpringDataJPA;
	
	@Test
	public void getAllEmployeesSimpleMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getAllEmployeesSimple();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
	}
	
	@Test
	public void getAllEmployeesMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectIdMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByProjectId(1);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByProjectNameMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByProjectName("Apricot-DEV");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByRoleIdMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByRoleId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	
	@Test
	public void getEmployeesByRoleNameMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByRoleName("BUSINESS ANALYST");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByDepartmentIdMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByDepartmentId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByDepartmentNameMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByDepartmentName("DEVELOPMENT");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByManagerIdMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByManagerId(24);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(4));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByFirstNameMyBatis() {
		assertNotNull("Employee Service not injected ",serviceMyBatis);
		List<EmployeeBDO>  employeeList = serviceMyBatis.getEmployeesByFirstName("a develo");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(9));
		validateEmployeeList(employeeList);
	}	

	
	@Test
	public void getAllEmployeesSimpleHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getAllEmployeesSimple();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
	}
	
	@Test
	public void getAllEmployeesHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectIdHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByProjectId(1);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByProjectNameHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByProjectName("Apricot-DEV");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByRoleIdHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByRoleId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	
	@Test
	public void getEmployeesByRoleNameHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByRoleName("BUSINESS ANALYST");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByDepartmentIdHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByDepartmentId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByDepartmentNameHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByDepartmentName("DEVELOPMENT");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByManagerIdHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByManagerId(24);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(4));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByFirstNameHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getEmployeesByFirstName("a develo");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(9));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getAllEmployeesSimpleHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getAllEmployeesSimple();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
	}
	
	@Test
	public void getAllEmployeesHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectIdHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByProjectId(1);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByProjectNameHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByProjectName("Apricot-DEV");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByRoleIdHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByRoleId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	
	@Test
	public void getEmployeesByRoleNameHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByRoleName("BUSINESS ANALYST");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}	

	@Test
	public void getEmployeesByDepartmentIdHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByDepartmentId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByDepartmentNameHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByDepartmentName("DEVELOPMENT");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByManagerIdHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByManagerId(24);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(4));
		validateEmployeeList(employeeList);
	}	
	
	@Test
	public void getEmployeesByFirstNameHibernateSpringDataJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateSpringDataJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateSpringDataJPA.getEmployeesByFirstName("a develo");
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
