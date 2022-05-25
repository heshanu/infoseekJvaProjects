package com.heshan.flightReserv.entities;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight extends AbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String flightNumber;
	private String operatingArilines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDepature;
	private Timestamp estimatedDepartureTime;

	

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingArilines() {
		return operatingArilines;
	}

	public void setOperatingArilines(String operatingArilines) {
		this.operatingArilines = operatingArilines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDepature() {
		return dateOfDepature;
	}

	public void setDateOfDepature(Date dateOfDepature) {
		this.dateOfDepature = dateOfDepature;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
