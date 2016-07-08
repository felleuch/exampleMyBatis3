/**
 * Name        : com.malcolm.daotest.mybatis.model.RoleEmployee.java
 * Author      : Malcolm
 * Created on  : May 22, 2014
 *
 * Description : Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 */
package com.malcolm.daotest.mybatis.model;

/**
 * Generated by MyBatis generator please check /src/main/resources/generatorConfig.xml
 * Additional updates are made to add Role Details for each Employee-Role Association 
 * 
 * @author Malcolm
 */
public class RoleEmployee {
    private Integer role_emp_assn_id;

    private Integer role_id;

    private Integer emp_id;
    
    private Role role;

    public Integer getRole_emp_assn_id() {
        return role_emp_assn_id;
    }

    public void setRole_emp_assn_id(Integer role_emp_assn_id) {
        this.role_emp_assn_id = role_emp_assn_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}