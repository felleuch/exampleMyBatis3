/**
 * Name        : com.malcolm.daotest.hibernate.HibernateModelMapper.java
 * Author      : Malcolm
 * Created on  : Jun 11, 2014
 *
 * Description : Model Mapper for Hibernate  Model to BDO Object 
 */
package com.malcolm.daotest.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.malcolm.daotest.hibernate.model.Department;
import com.malcolm.daotest.hibernate.model.Designation;
import com.malcolm.daotest.hibernate.model.Employee;
import com.malcolm.daotest.hibernate.model.Project;
import com.malcolm.daotest.hibernate.model.ProjectEmployee;
import com.malcolm.daotest.hibernate.model.Role;
import com.malcolm.daotest.hibernate.model.RoleEmployee;
import com.malcolm.daotest.service.bdo.DepartmentBDO;
import com.malcolm.daotest.service.bdo.DesignationBDO;
import com.malcolm.daotest.service.bdo.EmployeeBDO;
import com.malcolm.daotest.service.bdo.ProjectBDO;
import com.malcolm.daotest.service.bdo.RoleBDO;

/**
 * Model Mapper for Hibernate  Model to BDO Object
 * 
 * @author Malcolm
 */
public class HibernateModelMapper {
	/**
	 * Model Mapper
	 */
	private static final ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * Core Employee Details
	 */
	private static final PropertyMap<Employee, EmployeeBDO> corePropertyMap = new PropertyMap<Employee, EmployeeBDO>() {
		protected void configure() {
			map().setEmployeeID(source.getEmp_id());
			map().setEmployeeFirstName(source.getEmp_first_name());
			map().setEmployeeLastName(source.getEmp_last_name());
			map().setEmployeeStartDate(source.getEmp_start_date());
			map().setEmployeeEndDate(source.getEmp_end_date());
			map().setUpdateUser(source.getUpdate_user());
			map().setUpdateDate(source.getUpdate_date());
		}
	};
	
	/**
	 * Employee Designation Details
	 */
	private static final PropertyMap<Designation, DesignationBDO> designationPropertyMap = new PropertyMap<Designation, DesignationBDO>() {
		protected void configure() {
			map().setDesignationID(source.getDesignation_id());
			map().setDesignationName(source.getDesignation_name());
			map().setDesignationDesc(source.getDesignation_desc());
		}
	};

	/**
	 * Employee Department Details
	 */
	private static final PropertyMap<Department, DepartmentBDO> departmentPropertyMap = new PropertyMap<Department, DepartmentBDO>() {
		protected void configure() {
			map().setDepartmentID(source.getDept_id());
			map().setDepartmentName(source.getDept_name());
			map().setDepartmentDesc(source.getDept_desc());
		}
	};
	
	/**
	 * Employee Roles Details
	 */
	private static final PropertyMap<Role, RoleBDO> rolesPropertyMap = new PropertyMap<Role, RoleBDO>() {
		protected void configure() {
			map().setRoleID(source.getRole_id());
			map().setRoleName(source.getRole_name());
			map().setRoleDesc(source.getRole_desc());
		}
	};
	

	/**
	 * Employee Project Details
	 */
	private static final PropertyMap<Project, ProjectBDO> projectsPropertyMap = new PropertyMap<Project, ProjectBDO>() {
		protected void configure() {
			map().setProjectID(source.getProject_id());
			map().setProjectName(source.getProject_name());
			map().setProjectDesc(source.getProject_desc());
			map().setProjectStartDate(source.getProject_startdate());
			map().setProjectEndDate(source.getProject_enddate());
			map().setUpdateUser(source.getUpdate_user());
			map().setUpdateDate(source.getUpdate_date());
		}
	};
	
	static{
		modelMapper.addMappings(corePropertyMap);
		modelMapper.addMappings(designationPropertyMap);
		modelMapper.addMappings(departmentPropertyMap);
		modelMapper.addMappings(rolesPropertyMap);
		modelMapper.addMappings(projectsPropertyMap);
		
	}
	
	/**
	 * Map Employee Object
	 * 
	 * @param employee
	 * @return
	 */
	public static EmployeeBDO mapEmployeeBDO(Employee employee){
		return mapEmployeeInfo(employee);
	}
	
	/**
	 * Map Employee Core Details
	 * 
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeInfo(Employee employee){
		EmployeeBDO employeeBDO = modelMapper.map(employee, EmployeeBDO.class);
		//Designation Info
		if(employee.getDesignation_id() != null && employee.getDesignation_id() > 0 && employee.getDesignation() != null){
			mapEmployeeDesignationInfo(employeeBDO, employee);
		}
		//Department Info
		if(employee.getDept_id() != null && employee.getDept_id() > 0 && employee.getDepartment() != null){
			mapEmployeeDepartmentInfo(employeeBDO, employee);
		}
		//Manager Info
		if(employee.getMgr_id() != null && employee.getMgr_id() > 0 && employee.getManager() != null){
			mapEmployeeManagerInfo(employeeBDO, employee);
		}
		//Employee Roles
		if(employee.getEmployeeRoleAssn() != null && !employee.getEmployeeRoleAssn().isEmpty()){
			mapEmployeeRolesInfo(employeeBDO, employee);
		}
		//Employee Projects
		if(employee.getEmployeeProjectAssn() != null && !employee.getEmployeeProjectAssn().isEmpty()){
			mapEmployeeProjectsInfo(employeeBDO, employee);
		}
		return employeeBDO;
	}
	
	/**
	 * Map Employee Designation Info
	 * 
	 * @param employeeBDO
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeDesignationInfo(EmployeeBDO employeeBDO, Employee employee) {
		employeeBDO.setEmployeeDesignation(modelMapper.map(employee.getDesignation(), DesignationBDO.class));
		return employeeBDO;
	}
	
	/**
	 * Map Employee Department Info
	 * 
	 * @param employeeBDO
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeDepartmentInfo(EmployeeBDO employeeBDO, Employee employee) {
		employeeBDO.setEmployeeDepartment(modelMapper.map(employee.getDepartment(), DepartmentBDO.class));
		if (employeeBDO.getEmployeeDepartment() != null
				&& employee.getDepartment().getDept_mgr() != null
				&& employee.getDepartment().getDept_mgr() > 0
				&& employee.getDepartment().getDept_mgr() != employee.getEmp_id()
				&& employee.getDepartment().getDeptManager() != null) {
			employeeBDO.getEmployeeDepartment().setDepartmentManager(mapEmployeeInfo(employee.getDepartment().getDeptManager()));
		}
		return employeeBDO;
	}

	/**
	 *  Map Employee Manager Info
	 * 
	 * @param employeeBDO
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeManagerInfo(EmployeeBDO employeeBDO, Employee employee) {
		employeeBDO.setEmployeeManager(modelMapper.map(employee.getManager(), EmployeeBDO.class));
		return employeeBDO;
	}
	
	/**
	 * Map Employee Roles Info
	 * 
	 * @param employeeBDO
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeRolesInfo(EmployeeBDO employeeBDO, Employee employee) {
		List<RoleBDO> 	   employeeRoleBDOList = new ArrayList<RoleBDO>();
		Set<RoleEmployee> employeeRoleList = employee.getEmployeeRoleAssn();
		for (RoleEmployee roleEmployee : employeeRoleList) {
			if(roleEmployee.getRole() != null){
				employeeRoleBDOList.add(modelMapper.map(roleEmployee.getRole(), RoleBDO.class));
			}
		}
		if(!employeeRoleBDOList.isEmpty()){
			employeeBDO.setEmployeeRoles(employeeRoleBDOList);
		}
		return employeeBDO;
	}
	
	/**
	 * Map Employee Projects Info
	 * 
	 * @param employeeBDO
	 * @param employee
	 * @return
	 */
	private static EmployeeBDO mapEmployeeProjectsInfo(EmployeeBDO employeeBDO, Employee employee) {
		List<ProjectBDO> 	 	employeeProjectBDOList  = new ArrayList<ProjectBDO>();
		Set<ProjectEmployee>	employeeProjectList 	= employee.getEmployeeProjectAssn();
		for (ProjectEmployee projectEmployee : employeeProjectList) {
			if(projectEmployee.getProject() != null){
				ProjectBDO project = modelMapper.map(projectEmployee.getProject(), ProjectBDO.class);
				if (projectEmployee.getProject().getManager() != null
						&& projectEmployee.getProject().getManager().getEmp_id() != employee.getEmp_id()) {
					project.setProjectManager(mapEmployeeInfo(projectEmployee.getProject().getManager()));
				}
				employeeProjectBDOList.add(project);
			}
		}
		if(!employeeProjectBDOList.isEmpty()){
			employeeBDO.setEmployeeProjects(employeeProjectBDOList);
		}		
		return employeeBDO;
	}
}
