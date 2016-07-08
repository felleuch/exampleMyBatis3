/**
 * Name        : com.malcolm.daotest.hibernate.dao.jpaimpl.EmployeeDAOHibernateJPAImpl.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Hibernate JPA Base Implementation for Employee DAO  
 *               
 *               
 *
 *
 */
package com.malcolm.daotest.hibernate.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.malcolm.daotest.hibernate.dao.IEmployeeDAO;
import com.malcolm.daotest.hibernate.model.Employee;

/**
 * Hibernate JPA Base Implementation for Employee DAO  
 * 
 * @author Malcolm
 */
@Repository
@Qualifier("employeeDAOHibernateJPAImpl")
public class EmployeeDAOHibernateJPAImpl implements IEmployeeDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployeesSimple() {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
			        + "LEFT OUTER JOIN FETCH employeeInfo.designation "
			        + "LEFT OUTER JOIN FETCH employeeInfo.department "
			        + "LEFT OUTER JOIN FETCH employeeInfo.manager "
			        + "LEFT OUTER JOIN FETCH employeeInfo.employeeProjectAssn "
			        + "LEFT OUTER JOIN FETCH employeeInfo.employeeRoleAssn "
					;
			return (List<Employee>)entityManager.createQuery(query).getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			       ;
			return (List<Employee>)entityManager.createQuery(query).getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByProjectId(Integer projectId) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE projectMangerVal.project_id = :project_id "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("project_id", projectId);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByProjectName(String projectName) {
		try{	
			
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE projectMangerVal.project_name = :projectName "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("projectName", projectName);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByRoleId(Integer roleId) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE employeeRole.role_id = :role_id "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("role_id", roleId);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByRoleName(String roleName) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE employeeRole.role_name = :role_name "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("role_name", roleName);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE empDeptVal.dept_id = :dept_id "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("dept_id", departmentId);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByDepartmentName(String departmentName) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE empDeptVal.dept_name = :dept_name "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("dept_name", departmentName);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByManagerId(Integer managerId) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE empMgr.emp_id = :mgr_id "
			       ;
			Query q = entityManager.createQuery(query);
			q.setParameter("mgr_id", managerId);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByFirstName(String employeeName) {
		try{	
			String query = "SELECT employeeInfo FROM Employee employeeInfo "
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
			        + "WHERE employeeInfo.emp_first_name LIKE :employeeName "
			       ;
			Query q = entityManager.createQuery(query);
			employeeName = employeeName + "%";
			q.setParameter("employeeName", employeeName);
			return (List<Employee>)q.getResultList();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
}

