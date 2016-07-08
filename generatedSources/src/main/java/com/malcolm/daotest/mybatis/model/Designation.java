package com.malcolm.daotest.mybatis.model;

public class Designation {
    private Integer designation_id;

    private String designation_name;

    private String designation_desc;

    public Integer getDesignation_id() {
        return designation_id;
    }

    public void setDesignation_id(Integer designation_id) {
        this.designation_id = designation_id;
    }

    public String getDesignation_name() {
        return designation_name;
    }

    public void setDesignation_name(String designation_name) {
        this.designation_name = designation_name;
    }

    public String getDesignation_desc() {
        return designation_desc;
    }

    public void setDesignation_desc(String designation_desc) {
        this.designation_desc = designation_desc;
    }
}