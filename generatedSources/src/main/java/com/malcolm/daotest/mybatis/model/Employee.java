package com.malcolm.daotest.mybatis.model;

import java.sql.Timestamp;

public class Employee {
    private Integer emp_id;

    private String emp_first_name;

    private String emp_last_name;

    private Timestamp emp_start_date;

    private Timestamp emp_end_date;

    private Integer designation_id;

    private Integer dept_id;

    private Integer mgr_id;

    private String update_user;

    private Timestamp update_date;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_first_name() {
        return emp_first_name;
    }

    public void setEmp_first_name(String emp_first_name) {
        this.emp_first_name = emp_first_name;
    }

    public String getEmp_last_name() {
        return emp_last_name;
    }

    public void setEmp_last_name(String emp_last_name) {
        this.emp_last_name = emp_last_name;
    }

    public Timestamp getEmp_start_date() {
        return emp_start_date;
    }

    public void setEmp_start_date(Timestamp emp_start_date) {
        this.emp_start_date = emp_start_date;
    }

    public Timestamp getEmp_end_date() {
        return emp_end_date;
    }

    public void setEmp_end_date(Timestamp emp_end_date) {
        this.emp_end_date = emp_end_date;
    }

    public Integer getDesignation_id() {
        return designation_id;
    }

    public void setDesignation_id(Integer designation_id) {
        this.designation_id = designation_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(Integer mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}