/**
 * Name        : com.malcolm.daotest.mybatis.dao.BaseDAO.java
 * Author      : Malcolm
 * Created on  : Apr 22, 2014
 *
 * Description : Base DAO
 *               
 */
package com.malcolm.daotest.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base DAO
 * 
 * @author Malcolm
 */
public class BaseDAO {
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Return the Mapper Class
	 * 
	 * @param t
	 * @return
	 */
	protected <T> T getMapper(Class<T> t){
		return sqlSession.getMapper(t);	
	}
}