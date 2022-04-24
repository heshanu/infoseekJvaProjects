package entity;

import javax.persistence.*;

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "enrollment_id", nullable = false)
	private String enrollmentID;

	private String name;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "guide_id")
	private Guide guide;

	public Student() {
	}

	public Student(String enrollmentID, String name, Guide guide) {
		this.enrollmentID = enrollmentID;
		this.name = name;
		this.guide = guide;
	}

}
