package domainMany2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String contactNo;
	
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

	public List<Jeep> getJeep() {
		return jeep;
	}

	public void setJeep(List<Jeep> jeep) {
		this.jeep = jeep;
	}

	@ManyToMany(mappedBy ="owner",targetEntity = Jeep.class)
	private List<Jeep> jeep=new ArrayList<>();
	
	
}
