package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.TimeSlot;
import com.supermarket.backend.entities.TimeslotReservation;
import com.supermarket.backend.entities.reduced.ReducedTimeslot;
import com.supermarket.backend.services.TimeSlotService;
import com.supermarket.backend.services.TimeslotReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Theiner
 */
@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {

	private final TimeSlotService timeSlotService;
	private final TimeslotReservationService timeslotReservationService;

	public TimeSlotController(TimeSlotService timeSlotService, TimeslotReservationService timeslotReservationService) {
		this.timeSlotService = timeSlotService;
		this.timeslotReservationService = timeslotReservationService;
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> add(LocalTime begin, LocalTime end, long market) throws SQLException {
		var slot = new TimeSlot(begin, end, market);
		var id = this.timeSlotService.create(slot);
		var fetchedSlot = this.timeSlotService.getById(id);
		if(fetchedSlot.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/request", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> request(long slot) throws SQLException {

		var slotReservations = this.timeslotReservationService.getMultiple(timeslotReservation -> timeslotReservation.getSlotId() == slot).toList();
		if(!slotReservations.isEmpty() && slotReservations.size() >= slotReservations.get(0).getTimeSlot().getSupermarket().getCapacity()) {
			return ResponseEntity.status(HttpStatus.LOCKED).build();
		}

		//TODO: get user id once auth has been implemented
		var reservation = new TimeslotReservation(1, slot);

		var id = this.timeslotReservationService.create(reservation);
		var fetchedReservation = this.timeslotReservationService.getById(id);
		if(fetchedReservation.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> delete(long id) throws SQLException {
		this.timeSlotService.delete(id);
		return ResponseEntity.ok().build();
	}


	@GetMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<List<ReducedTimeslot>> all(long market) {
		var timeslots = this.timeSlotService.getMultiple(timeSlot -> timeSlot.getSupermarketId() == market).toList();

		var reservations = new ArrayList<ReducedTimeslot>();

		for(var slot : timeslots) {
			var id = slot.getId();
			var slotReservations = this.timeslotReservationService.getMultiple(timeslotReservation -> timeslotReservation.getSlotId() == id).toList();

			reservations.add(new ReducedTimeslot(slot.getBegin(), slot.getEnd(), slotReservations.size()));
		}

		return ResponseEntity.ok(reservations);
	}
}
