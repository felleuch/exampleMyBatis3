package com.malcolm.daotest.mybatis.model;

public class Department {
    private Integer dept_id;

    private String dept_name;

    private String dept_desc;

    private Integer dept_mgr;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }

    public Integer getDept_mgr() {
        return dept_mgr;
    }

    public void setDept_mgr(Integer dept_mgr) {
        this.dept_mgr = dept_mgr;
    }
}