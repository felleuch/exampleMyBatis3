/**
 * Name        : com.malcolm.daotest.hibernate.HibernateDAOJPAConfig.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Configuration Object for Hibernate JPA Based DAO   
 */
package com.malcolm.daotest.hibernate;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Configuration Object for Hibernate JPA Based DAO   
 * 
 * @author Malcolm
 *
 */
@ComponentScan({"com.malcolm.daotest.hibernate.dao.jpaimpl","com.malcolm.daotest.service.hibernatejpa"})
public class HibernateDAOJPAConfig extends BaseHibernateDAOConfig {
	
	/**
	 * Get Session Factory
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.malcolm.daotest.hibernate.model");
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		return entityManagerFactoryBean;
	}
	
	/**
	 * Return the Transaction Manager
	 * 
	 * @param sessionFactory
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}	
}	
