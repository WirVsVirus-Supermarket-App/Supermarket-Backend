package com.supermarket.backend.controllers;

import com.supermarket.backend.entities.Supermarket;
import com.supermarket.backend.entities.reduced.ReducedSupermarket;
import com.supermarket.backend.modules.HashingModule;
import com.supermarket.backend.services.SupermarketService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Collin Alpert
 */
@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

	private final SupermarketService supermarketService;
	private final HashingModule hashingModule;

	public SupermarketController(SupermarketService supermarketService, HashingModule hashingModule) {
		this.supermarketService = supermarketService;
		this.hashingModule = hashingModule;
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Map<String, Object>> register(String name, String email, String password, int capacity, String street, String houseNumber, int postalCode) throws SQLException {
		var hashedPassword = this.hashingModule.hashSha265(password);
		var user = new Supermarket(name, email, hashedPassword, capacity, street, houseNumber, postalCode);
		var id = this.supermarketService.create(user);
		var fetchedUser = this.supermarketService.getById(id);
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
		var user = this.supermarketService.getFirst(x -> x.getEmail() == email && x.getPassword() == hashedPassword);
		if (user.isEmpty()) {
			return ResponseEntity.ok(Map.of("success", false, "message", "Supermarket not found."));
		}

		return ResponseEntity.ok(Map.of("success", true, "token", user.get().getToken()));
	}

	@GetMapping(value = "/nearest", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<List<ReducedSupermarket>> nearest(int postalCode) {
		return ResponseEntity.ok(this.supermarketService.getMultiple(x -> x.getPostalCode() == postalCode).limit(5).toStream().map(s -> new ReducedSupermarket(s.getId(), s.getName(), s.getCapacity(), s.getStreet(), s.getHouseNumber(), s.getPostalCode())).collect(Collectors.toUnmodifiableList()));
	}
}
