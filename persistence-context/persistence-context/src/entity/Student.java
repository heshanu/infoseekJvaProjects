package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
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
	
	@Column(nullable = false)
	private String name;
	
	@Column(name="enrollment_id", nullable = false, unique = true)
	private String enrollmentId;

	public Student() {}
	public Student(String enrollmentId, String name) {
		this.enrollmentId = enrollmentId;
		this.name = name;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return this.getEnrollmentId().hashCode();
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollmentId=" + enrollmentId + ", name=" + name + "]";
	}

}
