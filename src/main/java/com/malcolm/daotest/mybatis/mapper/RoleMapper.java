/**
 * Name        : com.malcolm.daotest.mybatis.mapper.RoleMapper.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 */
package com.malcolm.daotest.mybatis.mapper;

import com.malcolm.daotest.mybatis.model.Role;

/**
 * Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 * 
 * @author Malcolm
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer role_emp_assn_id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer role_emp_assn_id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}