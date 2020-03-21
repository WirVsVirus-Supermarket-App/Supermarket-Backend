package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.User;
import com.supermarket.backend.modules.HashingModule;
import com.supermarket.backend.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Collin Alpert
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	private final HashingModule hashingModule;

	public UserController(UserService userService, HashingModule hashingModule) {
		this.userService = userService;
		this.hashingModule = hashingModule;
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Map<String, Object>> register(String name, String email, String password, String street, String houseNumber, int postalCode) throws SQLException {
		var hashedPassword = this.hashingModule.hashSha265(password);
		var user = new User(name, email, hashedPassword, street, houseNumber, postalCode);
		var id = this.userService.create(user);
		var fetchedUser = this.userService.getById(id);
		if (fetchedUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(Map.of("success", true, "token", fetchedUser.get().getToken()));
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Map<String, Object>> login(String email, String password) {
		if (email == null || password == null) {
			return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Missing parameters."));
		}

		var hashedPassword = this.hashingModule.hashSha265(password);
		var user = this.userService.getFirst(x -> x.getEmail() == email && x.getPassword() == hashedPassword);
		if (user.isEmpty()) {
			return ResponseEntity.ok(Map.of("success", false, "message", "User not found."));
		}

		return ResponseEntity.ok(Map.of("success", true, "token", user.get().getToken()));
	}
}
