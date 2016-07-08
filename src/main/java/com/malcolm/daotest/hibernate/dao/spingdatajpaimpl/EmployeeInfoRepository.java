/**
 * Name        : com.malcolm.daotest.hibernate.dao.spingdatajpaimpl.EmployeeInfoRepository.java
 * Author      : Malcolm
 * Created on  : Jun 10, 2014
 *
 * Description : Spring Data JPA Based Employee Repository
 */
package com.malcolm.daotest.hibernate.dao.spingdatajpaimpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.malcolm.daotest.hibernate.model.Employee;

/**
 * Spring Data JPA Based Employee Repository. Spring-Data JPA Repository allows
 * to wrap JPA Entity Manager and smartly generate basic CRUD operations Smart
 * findByXXXX operations also can be generated. However custom query will incur
 * n+1 issues in not properly tagged with fetch join (need to watch out for
 * cartesian products!!!) One Advantage the JPA custom query offers is do
 * declare JPA queries here without cluttering the model entity objects and also
 * switch between different JPA implementations.
 * 
 * 
 * @author Malcolm
 */
public interface EmployeeInfoRepository extends JpaRepository<Employee, Integer> {
	
	
	/**
	 * Get all employee simple
	 * 
	 * @return
	 */
	@Query(getAllEmployeesSimpleQuery)
	public List<Employee> getAllEmployeesSimple();
	public final static String getAllEmployeesSimpleQuery = "SELECT employeeInfo FROM Employee employeeInfo "
															+ "LEFT OUTER JOIN FETCH employeeInfo.designation "
															+ "LEFT OUTER JOIN FETCH employeeInfo.department "
															+ "LEFT OUTER JOIN FETCH employeeInfo.manager "
															+ "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn "
															+ "LEFT OUTER JOIN FETCH employeeInfo.employeeRoleAssn ";
	/**
	 * Get all employee
	 * @return
	 */
	@Query(getAllEmployeesQuery)
	public List<Employee> getAllEmployees();
	public final static String  getAllEmployeesQuery = "SELECT employeeInfo FROM Employee employeeInfo "
														+ "LEFT OUTER JOIN FETCH employeeInfo.designation "
														+ "LEFT OUTER JOIN FETCH employeeInfo.department "
														+ "LEFT OUTER JOIN FETCH employeeInfo.manager "
														+ "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
														+ "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
														+ "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
														+ "LEFT OUTER JOIN FETCH projectMgrVal.designation "
														+ "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
														+ "LEFT OUTER JOIN FETCH deprtVal.deptManager "
														+ "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
														+ "LEFT OUTER JOIN FETCH mgrVal.designation "
														+ "LEFT OUTER JOIN FETCH mgrVal.department ";
	
	/**
	 * Get Employee List by Project ID
	 * 
	 * @param projectId
	 * @return
	 */
	@Query(getEmployeesByProjectIdQuery)
	public List<Employee> getEmployeesByProjectId(@Param("project_id") Integer projectId);
	public final static String getEmployeesByProjectIdQuery = "SELECT employeeInfo FROM Employee employeeInfo "
															  + "LEFT OUTER JOIN FETCH employeeInfo.designation "
															  + "LEFT OUTER JOIN FETCH employeeInfo.department "
															  + "LEFT OUTER JOIN FETCH employeeInfo.manager "
															  + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
															  + "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
															  + "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.designation "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
															  + "LEFT OUTER JOIN FETCH deprtVal.deptManager "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
															  + "LEFT OUTER JOIN FETCH mgrVal.designation "
															  + "LEFT OUTER JOIN FETCH mgrVal.department "
															  + "WHERE projectMangerVal.project_id = :project_id " ;
	/**
	 * Get Employee List by Project Name
	 * 
	 * @param projectName
	 * @return
	 */
	@Query(getEmployeesByProjectNameQuery)
	public List<Employee> getEmployeesByProjectName(@Param("projectName") String projectName);
	public final static String  getEmployeesByProjectNameQuery = "SELECT employeeInfo FROM Employee employeeInfo "
																 + "LEFT OUTER JOIN FETCH employeeInfo.designation "
																 + "LEFT OUTER JOIN FETCH employeeInfo.department "
																 + "LEFT OUTER JOIN FETCH employeeInfo.manager "
																 + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
																 + "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
																 + "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
																 + "LEFT OUTER JOIN FETCH projectMgrVal.designation "
																 + "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
																 + "LEFT OUTER JOIN FETCH deprtVal.deptManager "
																 + "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
																 + "LEFT OUTER JOIN FETCH mgrVal.designation "
																 + "LEFT OUTER JOIN FETCH mgrVal.department "
																 + "WHERE projectMangerVal.project_name = :projectName ";
	
	
	/**
	 * Get Employee List by Role ID
	 * 
	 * @param roleId
	 * @return
	 */
	@Query(getEmployeesByRoleIdQuery)
	public List<Employee> getEmployeesByRoleId(@Param("role_id") Integer roleId); 
	public final static String getEmployeesByRoleIdQuery = "SELECT employeeInfo FROM Employee employeeInfo "
															+ "LEFT OUTER JOIN FETCH employeeInfo.designation "
															+ "LEFT OUTER JOIN FETCH employeeInfo.department "
															+ "LEFT OUTER JOIN FETCH employeeInfo.manager "
															+ "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
															+ "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
															+ "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
															+ "LEFT OUTER JOIN FETCH projectMgrVal.designation "
															+ "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
															+ "LEFT OUTER JOIN FETCH deprtVal.deptManager "
															+ "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
															+ "LEFT OUTER JOIN FETCH mgrVal.designation "
															+ "LEFT OUTER JOIN FETCH mgrVal.department "
															+ "LEFT OUTER JOIN FETCH employeeInfo.employeeRoleAssn employeeRoleAssnVal "
															+ "LEFT OUTER JOIN FETCH employeeRoleAssnVal.role employeeRole "
															+ "WHERE employeeRole.role_id = :role_id ";
	
	/**
	 * Get Employee List by Role Name
	 * 
	 * @param roleName
	 * @return
	 */
	@Query(getEmployeesByRoleNameQuery)
	public List<Employee> getEmployeesByRoleName(@Param("role_name") String roleName);
	public final static String  getEmployeesByRoleNameQuery = "SELECT employeeInfo FROM Employee employeeInfo "
															  + "LEFT OUTER JOIN FETCH employeeInfo.designation "
															  + "LEFT OUTER JOIN FETCH employeeInfo.department "
															  + "LEFT OUTER JOIN FETCH employeeInfo.manager "
															  + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
															  + "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
															  + "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.designation "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
															  + "LEFT OUTER JOIN FETCH deprtVal.deptManager "
															  + "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
															  + "LEFT OUTER JOIN FETCH mgrVal.designation "
															  + "LEFT OUTER JOIN FETCH mgrVal.department "
															  + "LEFT OUTER JOIN FETCH employeeInfo.employeeRoleAssn employeeRoleAssnVal "
															  + "LEFT OUTER JOIN FETCH employeeRoleAssnVal.role employeeRole "
															  + "WHERE employeeRole.role_name = :role_name ";
	
	
	/**
	 * Get Employee List by Department ID
	 * 
	 * @param departmentId
	 * @return
	 */
	@Query(getEmployeesByDepartmentIdQuery)
	public List<Employee> getEmployeesByDepartmentId(@Param("dept_id") Integer departmentId);
	public final static String getEmployeesByDepartmentIdQuery = "SELECT employeeInfo FROM Employee employeeInfo "
																  + "LEFT OUTER JOIN FETCH employeeInfo.designation "
																  + "LEFT OUTER JOIN FETCH employeeInfo.department empDeptVal "
																  + "LEFT OUTER JOIN FETCH employeeInfo.manager "
																  + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
																  + "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
																  + "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
																  + "LEFT OUTER JOIN FETCH projectMgrVal.designation "
																  + "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
																  + "LEFT OUTER JOIN FETCH deprtVal.deptManager "
																  + "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
																  + "LEFT OUTER JOIN FETCH mgrVal.designation "
																  + "LEFT OUTER JOIN FETCH mgrVal.department "
																  + "WHERE empDeptVal.dept_id = :dept_id " ;
	
	/**
	 * Get Employee List by Department Name
	 * 
	 * @param departmentName
	 * @return
	 */
	@Query(getEmployeesByDepartmentNameQuery)
	public List<Employee> getEmployeesByDepartmentName(@Param("dept_name") String departmentName);
	public final static String getEmployeesByDepartmentNameQuery = "SELECT employeeInfo FROM Employee employeeInfo "
																   + "LEFT OUTER JOIN FETCH employeeInfo.designation "
																   + "LEFT OUTER JOIN FETCH employeeInfo.department empDeptVal "
																   + "LEFT OUTER JOIN FETCH employeeInfo.manager "
																   + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
																   + "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
																   + "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
																   + "LEFT OUTER JOIN FETCH projectMgrVal.designation "
																   + "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
																   + "LEFT OUTER JOIN FETCH deprtVal.deptManager "
																   + "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
																   + "LEFT OUTER JOIN FETCH mgrVal.designation "
																   + "LEFT OUTER JOIN FETCH mgrVal.department "
																   + "WHERE empDeptVal.dept_name = :dept_name ";
	
	
	/**
	 * Get Employee List by Manager Id
	 * 
	 * @param managerId
	 * @return
	 */
	@Query(getEmployeesByManagerIdQuery)
	public List<Employee> getEmployeesByManagerId(@Param("mgr_id") Integer managerId);
	public final static String  getEmployeesByManagerIdQuery = "SELECT employeeInfo FROM Employee employeeInfo "
																+ "LEFT OUTER JOIN FETCH employeeInfo.designation "
																+ "LEFT OUTER JOIN FETCH employeeInfo.department empDeptVal "
																+ "LEFT OUTER JOIN FETCH employeeInfo.manager empMgr "
																+ "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
																+ "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
																+ "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.designation "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
																+ "LEFT OUTER JOIN FETCH deprtVal.deptManager "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
																+ "LEFT OUTER JOIN FETCH mgrVal.designation "
																+ "LEFT OUTER JOIN FETCH mgrVal.department "
																+ "WHERE empMgr.emp_id = :mgr_id ";
	
	/**
	 * Get Employee List by First Name
	 * 
	 * @param employeeName
	 * @return
	 */
	@Query(getEmployeesByFirstNameQuery)
	public List<Employee> getEmployeesByFirstName(@Param("employeeName") String employeeName);
	public final static String  getEmployeesByFirstNameQuery = "SELECT employeeInfo FROM Employee employeeInfo "
																+ "LEFT OUTER JOIN FETCH employeeInfo.designation "
																+ "LEFT OUTER JOIN FETCH employeeInfo.department empDeptVal "
																+ "LEFT OUTER JOIN FETCH employeeInfo.manager empMgr "
																+ "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn projectVal "
																+ "LEFT OUTER JOIN FETCH projectVal.project projectMangerVal "
																+ "LEFT OUTER JOIN FETCH projectMangerVal.manager projectMgrVal "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.designation "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.department deprtVal "
																+ "LEFT OUTER JOIN FETCH deprtVal.deptManager "
																+ "LEFT OUTER JOIN FETCH projectMgrVal.manager mgrVal "
																+ "LEFT OUTER JOIN FETCH mgrVal.designation "
																+ "LEFT OUTER JOIN FETCH mgrVal.department "
																+ "WHERE employeeInfo.emp_first_name LIKE :employeeName ";
	
}
