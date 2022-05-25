package com.heshan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heshan.flightReserv.entities.Flight;
import com.heshan.flightReserv.entities.Passenger;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
