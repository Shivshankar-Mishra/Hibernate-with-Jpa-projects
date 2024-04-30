package com.jsp.hibernateJpqlProject.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Shivshankar Mishra
 * 
 * this is entity class used for transferring data in Java Application
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	private long phone;
	/**
	 * this is constructor without id field
	 * @param name
	 * @param email
	 * @param dob
	 * @param phone
	 */
	public User(String name, String email, LocalDate dob, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
	}
	

}
