package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.User;
import com.supermarket.backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
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

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> registerUser(String name, String email, String password, String street, String houseNumber, int postalCode) throws SQLException {
		var hashedPassword = hash(password);
		var user = new User(name, email, hashedPassword, street, houseNumber, postalCode);
		var id = this.userService.create(user);
		var fetchedUser = this.userService.getById(id);
		if (fetchedUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(Map.of("success", true, "token", fetchedUser.get().getToken()));
	}

	public String hash(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			return new String(digest.digest(input.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

			return null;
		}
	}

}
