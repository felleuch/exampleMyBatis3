/**
 * Name        : com.malcolm.daotest.mybatis.mapper.DepartmentMapper.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 */
package com.malcolm.daotest.mybatis.mapper;

import com.malcolm.daotest.mybatis.model.Department;

/**
 * Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 * 
 * @author Malcolm
 */
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer dept_id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer dept_id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}