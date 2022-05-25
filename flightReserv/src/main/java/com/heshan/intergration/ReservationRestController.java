package com.heshan.intergration;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heshan.dto.CreateReservation;
import com.heshan.dto.UpdateReservationRequest;
import com.heshan.flightReserv.entities.Flight;
import com.heshan.flightReserv.entities.Passenger;
import com.heshan.flightReserv.entities.Reservation;
import com.heshan.repos.FlightRepository;
import com.heshan.repos.PassengerRepository;
import com.heshan.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	FlightRepository flightrepository;

	@Autowired
	PassengerRepository passengerrepository;

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public List<Flight> findFlights() {
		return flightrepository.findAll();
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.POST)
	// transaction all should happen or nothing should happen
	@org.springframework.transaction.annotation.Transactional
	public Reservation saveReservation(CreateReservation request) {
		Flight flight = flightrepository.findById(request.getFlightId()).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savepassenger = passengerrepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savepassenger);
		reservation.setCheckedIn(false);

		return reservationRepository.save(reservation);

	}

	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.POST)
	public Reservation findReservation(@PathVariable("id") int id) {
		return reservationRepository.findById(id).get();

	}

	@RequestMapping(value = "/reservations", method = RequestMethod.PUT)
	public Reservation updateReservation(UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckIn());
		return reservationRepository.save(reservation);

	}
}
