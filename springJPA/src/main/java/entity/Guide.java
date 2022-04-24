package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Guide {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "straff_id", nullable = false)
	private String staff_id;
	private String name;
	private Integer salary;

	
	public Guide() {
	}

	public Guide(String staffId, String name, Integer salary) {
		this.staff_id = staffId;
		this.name = name;
		this.salary = salary;
	}

}
