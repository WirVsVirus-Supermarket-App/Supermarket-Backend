package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.User;
import com.supermarket.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Collin Alpert
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") long id) {
		return ResponseEntity.of(this.userService.getById(id));
	}
}
