package com.jsp.hibernate_uni_one_to_many.service;

import java.util.List;

import com.jsp.hibernate_uni_one_to_many.dao.DepartmentDao;
import com.jsp.hibernate_uni_one_to_many.dto.Department;
import com.jsp.hibernate_uni_one_to_many.dto.Employee;

public class DepartmentService {
	DepartmentDao dao = new DepartmentDao();

	public Department insertDepartmentData(Department department) {
		return dao.insertData(department);
	}

	public Department updateDepartmentData(Department department) {
		return dao.updateDepartment(department);
	}

	public Department updateEmployeeData(int dnum, Employee employee) {
		return dao.updateEmployee(dnum, employee);
	}

	public void deleteDepartmentData(int dnum) {
		dao.deleteDepartment(dnum);
	}

	public void deleteEmployeeData(int dnum, int emp_id) {
		dao.deleteEmployee(dnum, emp_id);
	}

	public Department getDepartmentData(int id) {
		return dao.getDepartment(id);
	}

	public List<Department> getAllDepartment() {
		return dao.getAll();
	}

}
