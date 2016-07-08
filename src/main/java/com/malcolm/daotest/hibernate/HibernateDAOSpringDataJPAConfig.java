/**
 * Name        : com.malcolm.daotest.hibernate.HibernateDAOSpringDataJPAConfig.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Configuration Object for Hibernate SpringData JPA Based DAO    
 */
package com.malcolm.daotest.hibernate;


import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Configuration Object for Hibernate SpringData JPA Based DAO
 * 
 * @author Malcolm
 */
@ComponentScan({"com.malcolm.daotest.hibernate.dao.spingdatajpaimpl","com.malcolm.daotest.service.hibernatespringjpa"})
@EnableJpaRepositories("com.malcolm.daotest.hibernate.dao.spingdatajpaimpl")
public class HibernateDAOSpringDataJPAConfig extends BaseHibernateDAOConfig {
	/**
	 * Get Session Factory
	 * 
	 * @return
	 */
	@Bean
	public EntityManagerFactory  entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    entityManagerFactoryBean.setPackagesToScan("com.malcolm.daotest.hibernate.model");
	    entityManagerFactoryBean.setDataSource(dataSource());
	    entityManagerFactoryBean.afterPropertiesSet();
	    return entityManagerFactoryBean.getObject();
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
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}	
}
