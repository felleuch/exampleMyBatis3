/**
 * Name        : com.malcolm.daotest.mybatis.dao.EmployeeDAO.java
 * Author      : Malcolm
 * Created on  : May 23, 2014
 *
 * Description : DAO for Employee Details 
 *               
 */
package com.malcolm.daotest.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.malcolm.daotest.mybatis.mapper.EmployeeMapper;
import com.malcolm.daotest.mybatis.mapper.EmployeeMapperExt;
import com.malcolm.daotest.mybatis.model.Employee;

/**
 * DAO for Employee Details
 * 
 * @author Malcolm
 */
@Service
@Qualifier("employeeDAO")
public class EmployeeDAO extends BaseDAO implements EmployeeMapper, EmployeeMapperExt {

	/**
	 * Employee MyBatis Mapper 
	 */
	private Class<EmployeeMapper> 	 mapperClazz = EmployeeMapper.class;
	
	/**
	 * Employee MyBatis Mapper Extension
	 */
	private Class<EmployeeMapperExt> mapperClazzExt=EmployeeMapperExt.class;
	
	@Override
	public List<Employee> getAllEmployeesSimple() {
		try {
			return super.getMapper(mapperClazzExt).getAllEmployeesSimple();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		try {
			return super.getMapper(mapperClazzExt).getAllEmployees();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Integer projectId) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByProjectId(projectId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByProjectName(String projectName) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByProjectName(projectName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByRoleId(Integer roleId) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByRoleId(roleId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByRoleName(String roleName) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByRoleName(roleName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByDepartmentId(departmentId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByDepartmentName(String departmentName) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByDepartmentName(departmentName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByManagerId(Integer managerId) {
		try {
			return super.getMapper(mapperClazzExt).getEmployeesByManagerId(managerId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String employeeName) {
		try {
			employeeName = employeeName + "%";
			return super.getMapper(mapperClazzExt).getEmployeesByFirstName(employeeName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int deleteByPrimaryKey(Integer emp_id) {
		try {
			return super.getMapper(mapperClazz).deleteByPrimaryKey(emp_id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int insert(Employee record) {
		try {
			int row = super.getMapper(mapperClazz).insert(record);
			try {
				Object identity = record.getEmp_id();
				if (identity == null) {
					return row;
				} else {
					return (Integer) identity;
				}
			} catch (Exception e) {
				return -1;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int insertSelective(Employee record) {
		try {
			int row = super.getMapper(mapperClazz).insertSelective(record);
			try {
				Object identity = record.getEmp_id();
				if (identity == null) {
					return row;
				} else {
					return (Integer) identity;
				}
			} catch (Exception e) {

				return -1;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Employee selectByPrimaryKey(Integer emp_id) {
		try {
			return this.getMapper(mapperClazz).selectByPrimaryKey(emp_id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		try {
			return super.getMapper(mapperClazz).updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		try {
			return super.getMapper(mapperClazz).updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
