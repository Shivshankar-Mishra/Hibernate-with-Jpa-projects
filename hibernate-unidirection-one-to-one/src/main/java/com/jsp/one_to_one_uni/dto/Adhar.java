package com.jsp.one_to_one_uni.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the Adhar entity.
 * 
 * @author Shivshankar Mishra
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adhar {
    @Id
    private long adhar_num;
    private LocalDate dob;
    private String father_name;
    private String address;
}
