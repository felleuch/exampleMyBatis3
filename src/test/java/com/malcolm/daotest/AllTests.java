/**
 * Name        : com.malcolm.daotest.AllTests.java
 * Author      : Malcolm
 * Created on  : Jun 11, 2014
 *
 * Description : Test Suite 
 */
package com.malcolm.daotest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.malcolm.daotest.hibernate.dao.hibernateimpl.EmployeeDAOHibernateImplSpringTest;
import com.malcolm.daotest.hibernate.dao.jpaimpl.EmployeeDAOHibernateJPAImplSpringTest;
import com.malcolm.daotest.hibernate.dao.spingdatajpaimpl.EmployeeDAOHibernateSpringDataJPAImplSpringTest;
import com.malcolm.daotest.mybatis.dao.EmployeeDAOMyBatisSpringTest;
import com.malcolm.daotest.service.EmployeeServiceHibernateJPAPerfMetricsSpringTest;
import com.malcolm.daotest.service.EmployeeServiceHibernatePerfMetricsSpringTest;
import com.malcolm.daotest.service.EmployeeServiceHibernateSpringDataJPAPerfMetricsSpringTest;
import com.malcolm.daotest.service.EmployeeServiceHibernateSpringTest;
import com.malcolm.daotest.service.EmployeeServiceMyBatisPerfMetricsSpringTest;
import com.malcolm.daotest.service.EmployeeServiceSpringTest;

@RunWith(Suite.class)
@SuiteClasses({
	EmployeeDAOMyBatisSpringTest.class,
	EmployeeDAOHibernateImplSpringTest.class,
	EmployeeDAOHibernateJPAImplSpringTest.class,
	EmployeeDAOHibernateSpringDataJPAImplSpringTest.class,
	EmployeeServiceSpringTest.class,
	EmployeeServiceHibernateSpringTest.class,
	EmployeeServiceMyBatisPerfMetricsSpringTest.class,
	EmployeeServiceHibernatePerfMetricsSpringTest.class,
	EmployeeServiceHibernateJPAPerfMetricsSpringTest.class,
	EmployeeServiceHibernateSpringDataJPAPerfMetricsSpringTest.class
	})
public class AllTests {
}
