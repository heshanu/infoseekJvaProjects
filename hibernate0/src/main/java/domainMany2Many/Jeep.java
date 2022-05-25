package domainMany2Many;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Jeep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jeepId;
	private String model;
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Owner> getOwner() {
		return owner;
	}

	public void setOwner(List<Owner> owner) {
		this.owner = owner;
	}

	private Date date;
	
	@ManyToMany(targetEntity = Owner.class)
	private List<Owner> owner=new ArrayList<>();
	
}
