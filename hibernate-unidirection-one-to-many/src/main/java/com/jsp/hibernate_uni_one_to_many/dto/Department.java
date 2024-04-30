package com.jsp.hibernate_uni_one_to_many.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	private int dnum;
	private String dname;
	private String dloc;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employees;

}
