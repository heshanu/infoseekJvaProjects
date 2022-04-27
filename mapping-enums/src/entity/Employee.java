package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	//for Hibernate 4.3.x Users
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	private String name;
	
	@Column(name="employee_id", unique=true)
	private String employeeId;
	
	@Enumerated
	//@Enumerated(EnumType.STRING)
	//@Enumerated(EnumType.ORDINAL)
	@Column(name="employee_status")
	private EmployeeStatus employeeStatus;

	public Employee() {}
	public Employee(String name, String employeeId, EmployeeStatus employeeStatus) {
		this.name = name;
		this.employeeId = employeeId;
		this.employeeStatus = employeeStatus;
	}
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employeeId="
				+ employeeId + ", employeeStatus=" + employeeStatus + "]";
	}
	
	
	
}
