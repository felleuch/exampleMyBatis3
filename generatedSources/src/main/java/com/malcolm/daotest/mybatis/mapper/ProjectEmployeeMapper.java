package com.malcolm.daotest.mybatis.mapper;

import com.malcolm.daotest.mybatis.model.ProjectEmployee;

public interface ProjectEmployeeMapper {
    int deleteByPrimaryKey(Integer project_emp_assn_id);

    int insert(ProjectEmployee record);

    int insertSelective(ProjectEmployee record);

    ProjectEmployee selectByPrimaryKey(Integer project_emp_assn_id);

    int updateByPrimaryKeySelective(ProjectEmployee record);

    int updateByPrimaryKey(ProjectEmployee record);
}