/**
 * Name        : com.malcolm.daotest.mybatis.MyBatisDAOConfig.java
 * Author      : Malcolm
 * Created on  : May 23, 2014
 *
 * Description : MyBatis Configuration 
 */
package com.malcolm.daotest.mybatis;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jamonapi.proxy.JAMonDataSource;

/**
 * MyBatis Configuration
 * 
 * @author Malcolm
 */
@Configuration
@EnableTransactionManagement  
@PropertySource("classpath:dbconfig.properties")
@ComponentScan({"com.malcolm.daotest.mybatis","com.malcolm.daotest.service.mybatis"})
public class MyBatisDAOConfig {
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER 	 = "dataSource.driver";
	private static final String PROPERTY_NAME_DATABASE_URL		 = "dataSource.url";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD  = "dataSource.password";  
    private static final String PROPERTY_NAME_DATABASE_USERNAME  = "dataSource.username";  
	
    @Autowired
    private Environment environment;
    
    @Bean
    public JamonPerformanceMonitorInterceptor jamonPerformanceMonitorInterceptor(){
    	JamonPerformanceMonitorInterceptor jamon = new JamonPerformanceMonitorInterceptor();
    	jamon.setTrackAllInvocations(true);
    	jamon.setUseDynamicLogger(true);
    	return jamon; 
    }
    
    @Bean
    public BeanNameAutoProxyCreator autoProxyCreator(){
    	BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
    	autoProxyCreator.setBeanNames(new String[]{"EmployeeDAO"});
    	autoProxyCreator.setInterceptorNames(new String[]{"jamonPerformanceMonitorInterceptor"});
    	return autoProxyCreator;
    }
    
    @Bean
	public DataSourceTransactionManager transactionManager() throws SQLException {
    	DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource());
		return txManager;
	}
    
    @Bean
    public DataSource dataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();  
		dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));  
        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));  
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));  
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));  
        return new JAMonDataSource(dataSource);
    }
   
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    	sessionFactoryBean.setDataSource( dataSource());
    	sessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    	return sessionFactoryBean.getObject();
    }
    
    @Bean
    public SqlSession sqlSessionTemplate() throws Exception{
    	return new SqlSessionTemplate(sqlSessionFactoryBean());
    }
}
