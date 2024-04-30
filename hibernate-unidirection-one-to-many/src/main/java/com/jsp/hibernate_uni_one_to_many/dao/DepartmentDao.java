package com.jsp.hibernate_uni_one_to_many.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_uni_one_to_many.dto.Department;
import com.jsp.hibernate_uni_one_to_many.dto.Employee;

public class DepartmentDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateOneTOManyUniProject");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public Department insertData(Department department) {
		transaction.begin();
		manager.persist(department);
		transaction.commit();
		return department;
	}

	public Department updateDepartment(Department department) {
		Department dpt = getDepartment(department.getDnum());
		dpt.setDname(department.getDname().isBlank() ? dpt.getDname() : department.getDname());
		dpt.setDloc(department.getDloc().isBlank() ? dpt.getDloc() : department.getDloc());
		transaction.begin();
		manager.merge(dpt);
		transaction.commit();
		return dpt;
	}

	public Department updateEmployee(int dnum, Employee employee) {
		Department dpt = getDepartment(dnum);
		dpt.setEmployees(dpt.getEmployees().stream().map(emp -> {
			if (emp.getEmp_id() == employee.getEmp_id()) {
				emp.setEmp_name(employee.getEmp_name().isBlank() ? emp.getEmp_name() : employee.getEmp_name());
				emp.setEmp_email(employee.getEmp_email().isBlank() ? emp.getEmp_email() : employee.getEmp_email());
				emp.setEmp_phone(employee.getEmp_phone() <= 0 ? emp.getEmp_phone() : employee.getEmp_phone());
				emp.setEmp_salary(employee.getEmp_salary() <= 0 ? emp.getEmp_salary() : employee.getEmp_salary());
			}
			return emp;
		}).collect(Collectors.toList()));
		transaction.begin();
		manager.merge(dpt);
		transaction.commit();
		return dpt;
	}

	public void deleteDepartment(int dnum) {
		transaction.begin();
		manager.remove(getDepartment(dnum));
		transaction.commit();
	}

	public void deleteEmployee(int dnum, int emp_id) {
		Department dpt = getDepartment(dnum);
		dpt.setEmployees(dpt.getEmployees().stream().filter(emp -> {
			if (emp.getEmp_id() != emp_id) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList()));
		transaction.begin();
		manager.merge(dpt);
		transaction.commit();
	}

	public Department getDepartment(int id) {
		return manager.find(Department.class, id);
	}

	public List<Department> getAll() {
		return manager.createQuery("from Department", Department.class).getResultList();
	}

}
