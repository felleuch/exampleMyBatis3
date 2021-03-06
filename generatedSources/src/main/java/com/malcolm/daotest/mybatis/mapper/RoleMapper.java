package com.malcolm.daotest.mybatis.mapper;

import com.malcolm.daotest.mybatis.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer role_id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}