/**
 * Name        : com.malcolm.daotest.hibernate.HibernateDAOConfig.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Configuration Object for Pure Hibernate Based DAO  
 */
package com.malcolm.daotest.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * Configuration Object for Pure Hibernate Based DAO  
 * 
 * @author Malcolm
 *
 */
@Configuration
@ComponentScan({"com.malcolm.daotest.hibernate.dao.hibernateimpl","com.malcolm.daotest.service.hibernate"})
public class HibernateDAOConfig extends BaseHibernateDAOConfig {
	/**
	 * Get Session Factory
	 * 
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.malcolm.daotest.hibernate.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	/**
	 * Return the Transaction Manager
	 * 
	 * @param sessionFactory
	 * @return
	 */
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
}
