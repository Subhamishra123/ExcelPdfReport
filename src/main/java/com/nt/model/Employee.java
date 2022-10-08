package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "emp")
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private String mgr;
	private String job;
	@Column(name = "sal")
	private Double salary;

}
