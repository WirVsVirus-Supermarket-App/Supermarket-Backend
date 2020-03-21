package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.User;
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

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> params) {
		if (!params.containsKey("email") || !params.containsKey("password")) {
			return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Missing parameters."));
		}

		var email = params.get("email");
		var password = params.get("password");
		var hashedPassword = hash(password);
		var user = this.userService.getFirst(x -> x.getEmail() == email && x.getPassword() == hashedPassword);
		if (user.isEmpty()) {
			return ResponseEntity.ok(Map.of("success", false, "message", "User not found."));
		}

		return ResponseEntity.ok(Map.of("success", true, "token", user.get().getToken()));
	}

	public String hash(String password) {
		try {
			var md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			var sb = new StringBuilder();
			for (byte aByte : bytes) {
				sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
