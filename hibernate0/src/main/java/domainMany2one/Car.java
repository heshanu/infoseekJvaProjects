package domainMany2one;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId;
	private String make;
	private String model;

	@OneToMany(mappedBy = "car")
	private List<Driver> drivers = new ArrayList<Driver>();

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
