/**
 * Name        : com.malcolm.daotest.hibernate.dao.hibernateimpl.EmployeeDAOHibernateImpl.java
 * Author      : Malcolm
 * Created on  : Jun 6, 2014
 *
 * Description : Hibernate Base Implementation for Employee DAO 
 */
package com.malcolm.daotest.hibernate.dao.hibernateimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.malcolm.daotest.hibernate.dao.IEmployeeDAO;
import com.malcolm.daotest.hibernate.model.Employee;


/**
 * Hibernate Base Implementation for Employee DAO
 * 
 * @author Malcolm
 */
@Repository
@Qualifier("employeeDAOHibernateImpl")
public class EmployeeDAOHibernateImpl implements IEmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployeesSimple() {
		try{
			return this.sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		try{
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			return criteria.list();
			//return this.sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByProjectId(Integer projectId) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.createAlias("employeeProjectAssn","employeeProjectAssnVal");
			criteria.add(Restrictions.eq("employeeProjectAssnVal.project_id",projectId));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByProjectName(String projectName) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.createAlias("employeeProjectAssn","employeeProjectAssnVal");
			criteria.createAlias("employeeProjectAssnVal.project","employeeProjectAssnProjectVal");
			criteria.add(Restrictions.eq("employeeProjectAssnProjectVal.project_name",projectName));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByRoleId(Integer roleId) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.setFetchMode("employeeRoleAssn", FetchMode.JOIN);
			criteria.createAlias("employeeRoleAssn","employeeRoleAssnVal");
			criteria.add(Restrictions.eq("employeeRoleAssnVal.role_id",roleId));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByRoleName(String roleName) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.setFetchMode("employeeRoleAssn", FetchMode.JOIN);
			criteria.createAlias("employeeRoleAssn","employeeRoleAssnVal");
			criteria.createAlias("employeeRoleAssnVal.role","employeeRoleAssnValRoleVal");
			criteria.add(Restrictions.eq("employeeRoleAssnValRoleVal.role_name",roleName));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.add(Restrictions.eq("dept_id",departmentId));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByDepartmentName(String departmentName) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.createAlias("department","departmentVal");
			criteria.add(Restrictions.eq("departmentVal.dept_name",departmentName));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByManagerId(Integer managerId) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.add(Restrictions.eq("mgr_id",managerId));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesByFirstName(String employeeName) {
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
			criteria.setFetchMode("employeeProjectAssn", FetchMode.JOIN);
			criteria.add(Restrictions.like("emp_first_name",employeeName,MatchMode.START));
			return criteria.list();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}
}
