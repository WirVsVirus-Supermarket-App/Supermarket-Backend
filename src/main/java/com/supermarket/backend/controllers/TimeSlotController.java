package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.TimeSlot;
import com.supermarket.backend.services.TimeSlotService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Johannes Theiner
 */
@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {

	private final TimeSlotService timeSlotService;

	public TimeSlotController(TimeSlotService timeSlotService) {
		this.timeSlotService = timeSlotService;
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> add(LocalTime begin, LocalTime end, long market) throws SQLException {
		var slot = new TimeSlot(begin, end, market);
		var id = this.timeSlotService.create(slot);
		var fetchedSlot = this.timeSlotService.getById(id);
		if(fetchedSlot.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/request", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> request(long timeslot) {
		//TODO: wie wird das gespeichert
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> delete(long id) throws SQLException {
		this.timeSlotService.delete(id);
		return ResponseEntity.ok().build();
	}


	@GetMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<List<TimeSlot>> all(long market) {
		return ResponseEntity.ok(this.timeSlotService.getMultiple(timeSlot -> timeSlot.getSupermarketId() == market).toList());
	}
}
