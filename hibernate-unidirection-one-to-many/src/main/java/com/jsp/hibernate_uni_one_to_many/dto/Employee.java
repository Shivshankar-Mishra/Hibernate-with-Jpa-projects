package com.jsp.hibernate_uni_one_to_many.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private String emp_email;
	private long emp_phone;
	private double emp_salary;
	public Employee(String emp_name, String emp_email, long emp_phone, double emp_salary) {
		super();
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_phone = emp_phone;
		this.emp_salary = emp_salary;
	}
	

}
