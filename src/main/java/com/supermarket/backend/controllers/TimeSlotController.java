package com.supermarket.backend.controllers;

import com.supermarket.backend.services.TimeSlotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Collin Alpert
 */
@RestController
@RequestMapping("/time-slot")
public class TimeSlotController {

	private final TimeSlotService timeSlotService;

	public TimeSlotController(TimeSlotService timeSlotService) {
		this.timeSlotService = timeSlotService;
	}
}
