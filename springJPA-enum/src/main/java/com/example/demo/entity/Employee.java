package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "emplyeeid", unique = true)
	private String emplyeeid;
	
	@Enumerated(EnumType.STRING)
	@Column(name="emplyee_status")
	private Employee_status employeeStatus;

	public Employee() {
	}

	public Employee(String name, String emplyeeid, Employee_status employee_status) {
		super();
		this.name = name;
		this.emplyeeid = emplyeeid;
		this.employeeStatus = employee_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmplyeeid() {
		return emplyeeid;
	}

	public void setEmplyeeid(String emplyeeid) {
		this.emplyeeid = emplyeeid;
	}

	public Employee_status getEmployee_status() {
		return employeeStatus;
	}

	public void setEmployee_status(Employee_status employee_status) {
		this.employeeStatus = employee_status;
	}
}
