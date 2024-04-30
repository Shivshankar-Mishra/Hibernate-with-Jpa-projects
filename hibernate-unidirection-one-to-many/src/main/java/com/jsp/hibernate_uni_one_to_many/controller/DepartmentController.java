package com.jsp.hibernate_uni_one_to_many.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_uni_one_to_many.dto.Department;
import com.jsp.hibernate_uni_one_to_many.dto.Employee;
import com.jsp.hibernate_uni_one_to_many.service.DepartmentService;

public class DepartmentController {
	public static void main(String[] args) {
		DepartmentService service = new DepartmentService();
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		System.out.println("************* Hibernate Crud Operation One to Many Mapping *************");
		while (flag) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(
					"1. Insert Department & Employee Data\n2. Update Department Data\n3. Update employee Data\n4. Delete Department Data\n5. Delete Employee Data\n6. Display One Data\n7. Display All Product Data\n8. Press any key other than options to exit");
			System.out.println("-----------------------");
			System.out.println("Choose your option: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("_________You want to insert data_________");
				System.out.println("Please enter the department and employee details: ");
				System.out.println("Enter department num: ");
				int dnum = in.nextInt();
				System.out.println("Enter department name: ");
				in.nextLine();
				String dname = in.nextLine();
				System.out.println("Enter department location: ");
				String dloc = in.nextLine();
				System.out.println("Enter number of employees in department: ");
				int n = in.nextInt();
				List<Employee> employees = new ArrayList<Employee>();
				for (int i = 1; i <= n; i++) {
					System.out.println("Enter employee "+i+" details: ");
					System.out.println("Enter employee name: ");
					in.nextLine();
					String emp_name = in.nextLine();
					System.out.println("Enter employee email: ");
					String emp_email = in.next();
					System.out.println("Enter employee phone: ");
					long emp_phone = in.nextLong();
					System.out.println("Enter employee salary: ");
					double emp_salary = in.nextDouble();
					Employee employee = new Employee(emp_name, emp_email, emp_phone, emp_salary);
					employees.add(employee);
				}
				Department department = new Department(dnum, dname, dloc, employees);
				System.out.println("data inserted.....: "+ service.insertDepartmentData(department));

				break;
			case 2:
				System.out.println("_________You want to update department data_________");
				System.out.println("Enter department number which you want to update: ");
				int dpt_num = in.nextInt();
				System.out.println("Enter department name: ");
				in.nextLine();
				String dpt_name = in.nextLine();
				System.out.println("Enter department location: ");
				String dpt_loc = in.nextLine();
				Department department2 = new Department();
				department2.setDname(dpt_name);
				department2.setDloc(dpt_loc);
				department2.setDnum(dpt_num);
				System.out.println(service.updateDepartmentData(department2));
				break;
			case 3:
				System.out.println("_________You want to update employee data_________");
				System.out.println("Enter department number of that employee: ");
				int d_number = in.nextInt();
				System.out.println("Enter employee id: ");
				int e_id = in.nextInt();
				System.out.println("Enter employee name: ");
				in.nextLine();
				String e_name = in.nextLine();
				System.out.println("Enter employee email: ");
				String e_email = in.next();
				System.out.println("Enter employee phone: ");
				long e_phone = in.nextLong();
				System.out.println("Enter employee salary: ");
				double e_salary = in.nextDouble();
				System.out.println(service.updateEmployeeData(d_number, new Employee(e_id,e_name,e_email,e_phone,e_salary)));
				break;
			case 4:
				System.out.println("_________You want to delete department data_________");
				System.out.println("Enter department id: ");
				service.deleteDepartmentData(in.nextInt());
				System.out.println("Department data deleted...");
				break;
			case 5:
				System.out.println("_________You want to delete employee data_________");
				System.out.println("Enter department id: ");
				int did = in.nextInt();
				System.out.println("Enter employee id: ");
				int eid = in.nextInt();
				service.deleteEmployeeData(did, eid);
				System.out.println("employee data deleted...");
				break;
			case 6:
				System.out.println("_________You want to display data_________");
				System.out.println("Enter department id: ");
				System.out.println(service.getDepartmentData(in.nextInt()));
				break;
			case 7:
				System.out.println("_________Displaying All Person data_________");
				service.getAllDepartment().forEach(dep->System.out.println(dep));
				break;
			default:
				flag = false;
				System.out.println("Thank You for your time");
				System.out.println("*****************************************************");
			}
		}
		in.close();
	}

}
