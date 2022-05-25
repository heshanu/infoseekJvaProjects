package com.heshan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heshan.flightReserv.entities.Flight;
import com.heshan.flightReserv.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
