package domainMany2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	private String contactNo;

	@ManyToOne(targetEntity = Van.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "vanid")
	private Van van;

	public Van getVan() {
		return van;
	}

	public void setVan(Van van) {
		this.van = van;
	}

	@Override
	public String toString() {
		return "Driver [Id=" + Id + ", name=" + name + ", contactNo=" + contactNo + ", van=" + van + "]";
	}

}
