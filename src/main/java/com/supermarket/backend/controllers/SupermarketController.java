package com.supermarket.backend.controllers;

import com.supermarket.backend.services.SupermarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @author Collin Alpert
 */
@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

	private final SupermarketService supermarketService;

	public SupermarketController(SupermarketService supermarketService) {
		this.supermarketService = supermarketService;
	}


}
