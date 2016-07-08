/**
 * Name        : com.malcolm.daotest.hibernate.dao.hibernateimpl.EmployeeDAOHibernateImplSpringTest.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Test Case for pure Hibernate Implementation 
 */
package com.malcolm.daotest.hibernate.dao.hibernateimpl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jamonapi.MonitorFactory;
import com.malcolm.daotest.hibernate.HibernateDAOConfig;
import com.malcolm.daotest.hibernate.dao.IEmployeeDAO;
import com.malcolm.daotest.hibernate.model.Employee;
import com.malcolm.daotest.hibernate.model.ProjectEmployee;
import com.malcolm.daotest.hibernate.model.RoleEmployee;

/**
 * Test Case for pure Hibernate Implementation 
 * 
 * @author Malcolm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateDAOConfig.class})
@Transactional
public class EmployeeDAOHibernateImplSpringTest {
	
	@Autowired
	@Qualifier("employeeDAOHibernateImpl")
	private IEmployeeDAO dao;
	
	/**
	 * HTLM report for JAMON
	 */
	private static final String htmlReportPath = "EmployeeDAOHibernateImplSpringTest.html";
	
	@AfterClass
	public static void getReport() throws IOException {
		String reportPath = "";
		if(new File("/tmp").exists()){
			reportPath = "/tmp/"+htmlReportPath;
		}else if(new File("/temp").exists()){
			reportPath = "/temp/"+htmlReportPath;
		}else{
			reportPath = null;
		}
		if(reportPath != null){
			Path file = Paths.get(reportPath);
			List<String> content = new ArrayList<String>(); 
			content.add("<HTML><HEAD><TITLE>EmployeeDAOHibernateImplSpringTest</TITLE></HEAD><BODY>");
			content.add(MonitorFactory.getReport());
			content.add("</BODY>");
			Files.write(file, content,Charset.forName("utf-8"));
		}	
	}
	
	@Test
	public void getAllEmployeesSimple() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getAllEmployeesSimple();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
	}
	
	@Test
	public void getAllEmployees() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectId() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByProjectId(1);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByProjectName() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByProjectName("Apricot-DEV");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(10));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByRoleId() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByRoleId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByRoleName() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByRoleName("BUSINESS ANALYST");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(15));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByDepartmentId() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByDepartmentId(5);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByDepartmentName() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByDepartmentName("DEVELOPMENT");
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(51));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByManagerId() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByManagerId(24);
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(4));
		validateEmployeeList(employeeList);
	}
	
	@Test
	public void getEmployeesByFirstName() {
		assertNotNull("Employee DAO not injected ",dao);
		List<Employee>  employeeList = dao.getEmployeesByFirstName("a develo");
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
	private void validateEmployeeList(List<Employee> employeeList) {
		for (Employee employee : employeeList) {
			if(employee.getDepartment() != null ){
				assertNotNull("Employee Department Name not valid ",employee.getDepartment().getDept_name());
				assertNotNull("Employee Department Desc not valid ",employee.getDepartment().getDept_desc());
			}else{
				assertThat(employee.getDesignation_id(), equalTo(12));
			}
			if(employee.getManager() != null ){
				assertNotNull("Employee Manager First  Name not valid ",employee.getManager().getEmp_first_name());
				assertNotNull("Employee Manager Last Name not valid ",employee.getManager().getEmp_last_name());
			}else{
				assertThat(employee.getDesignation_id(), equalTo(12));
			}
			if(employee.getDesignation() != null ){
				assertNotNull("Employee Designation Name not valid ",employee.getDesignation().getDesignation_name());
			}else{
				assertThat(employee.getDesignation_id(), equalTo(12));
			}
			
			if(employee.getEmployeeProjectAssn() != null ){
				Set<ProjectEmployee> projectAssnList = employee.getEmployeeProjectAssn();
				for (ProjectEmployee projectEmployee : projectAssnList) {
					if(projectEmployee.getProject() != null){
						assertNotNull("Employee Project  Name not valid ",projectEmployee.getProject().getProject_name());
						assertNotNull("Employee Project Desc not valid ",projectEmployee.getProject().getProject_desc());
					}else{
						System.out.println("GOT INVALID PROJECT - NO ASSOCIATION ");
					}
				}
			}else{
				assertThat(employee.getDesignation_id(), equalTo(12));
			}
			
			if(employee.getEmployeeRoleAssn() != null ){
				Set<RoleEmployee> roleAssnList = employee.getEmployeeRoleAssn();
				for (RoleEmployee roleEmployee : roleAssnList) {
					if(roleEmployee.getRole() != null){
						assertNotNull("Employee Role Name not valid ",roleEmployee.getRole().getRole_name());
						assertNotNull("Employee Role Desc not valid ",roleEmployee.getRole().getRole_desc());
					}else{
						System.out.println("GOT INVALID ROLE - NO ASSOCIATION ");
					}
					
				}
			}
		}
	}
}
