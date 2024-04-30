package com.jsp.one_to_one_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the Person entity.
 * 
 * @author Shivshankar Mishra
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private String email;
    private String gender;
    private long phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adhar_num")
    private Adhar adhar;

    /**
     * Parameterized constructor for creating a Person entity.
     */
    public Person(String name, String email, String gender, long phone, Adhar adhar) {
        super();
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.adhar = adhar;
    }
}
