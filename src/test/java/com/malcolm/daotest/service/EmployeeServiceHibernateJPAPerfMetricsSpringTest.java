/**
 * Name        : com.malcolm.daotest.service.EmployeeServicePerfMetricsSpringTest.java
 * Author      : Malcolm
 * Created on  : Jun 11, 2014
 *
 * Description : Testcase for Employee Service With Perf Metrics Executing Test cases in loop 
 */
package com.malcolm.daotest.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jamonapi.MonitorFactory;
import com.malcolm.daotest.hibernate.HibernateDAOJPAConfig;
import com.malcolm.daotest.service.bdo.EmployeeBDO;

/**
 * Testcase for Employee Service With Perf Metrics Executing Test cases in loop
 * 
 * @author Malcolm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateDAOJPAConfig.class})
@Transactional
public class EmployeeServiceHibernateJPAPerfMetricsSpringTest {
	/**
	 * Number of Loops to run for Test Cases
	 */
	private static final int numberofRepeats = 10;
	
	@Autowired
	@Qualifier("employeeServiceHibernateJPAImpl")
	private IEmployeeService serviceHibernateJPA;
	
	/**
	 * HTLM report for JAMON
	 */
	private static final String htmlReportPath = "/temp/EmployeeServiceHibernateJPAPerfMetricsSpringTest.html";
	
	@AfterClass
	public static void getReport() throws IOException {
		Path file = Paths.get(htmlReportPath);
		List<String> content = new ArrayList<String>(); 
		content.add("<HTML><HEAD><TITLE>EmployeeServiceHibernateJPAPerfMetricsSpringTest</TITLE></HEAD><BODY>");
		content.add(MonitorFactory.getReport());
		content.add("</BODY>");
		Files.write(file, content,Charset.forName("utf-8"));
	}
	
	@Test
	@Repeat(numberofRepeats)
	public void getAllEmployeesHibernateJPA() {
		assertNotNull("Employee Service not injected ",serviceHibernateJPA);
		List<EmployeeBDO>  employeeList = serviceHibernateJPA.getAllEmployees();
		assertNotNull("Employee List not fetched ",employeeList);
		assertThat(employeeList, notNullValue());
		assertThat(employeeList.size(), not(0));
		assertThat(employeeList.size(), greaterThan(1));
		assertThat(employeeList.size(), equalTo(61));
	}
}
