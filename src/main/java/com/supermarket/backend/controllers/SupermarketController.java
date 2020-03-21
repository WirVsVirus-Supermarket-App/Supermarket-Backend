package com.supermarket.backend.controllers;

import com.supermarket.backend.services.SupermarketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
