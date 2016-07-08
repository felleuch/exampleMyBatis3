/**
 * Name        : com.malcolm.daotest.hibernate.BaseHibernateDAOConfig.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Base Hibernate DAO Config
 */
package com.malcolm.daotest.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jamonapi.proxy.JAMonDataSource;

/**
 * Base Hibernate JPA Config
 * 
 * @author Malcolm
 */
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:dbconfig.properties","classpath:hibernateConfig.properties" })
public class BaseHibernateDAOConfig {
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "dataSource.driver";
	private static final String PROPERTY_NAME_DATABASE_URL = "dataSource.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "dataSource.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "dataSource.password";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	@Autowired
	private Environment environment;
	
	/**
	 * Get DataSource
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return new JAMonDataSource(dataSource);
	}

	/**
	 * Return Hibernate Properties 
	 * 
	 * @return
	 */
	protected Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 6067241928722086747L;
			{
				setProperty("hibernate.dialect",environment.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
				setProperty("hibernate.show_sql",environment.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
			}
		};
	}
}
