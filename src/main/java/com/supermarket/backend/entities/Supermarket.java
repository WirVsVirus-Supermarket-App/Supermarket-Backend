package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.Default;
import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

/**
 * @author Collin Alpert
 */
@TableName("supermarket")
public class Supermarket extends BaseEntity {

	private String name;
	private String email;
	private String password;

	@Default
	private String token;

	private int capacity;
	private String street;
	private String houseNumber;
	private int postalCode;
	private String town;

	public Supermarket(String name, String email, String password, int capacity, String street, String houseNumber, int postalCode, String town) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.capacity = capacity;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
		this.town = town;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getTown() {
		return town;
	}
}
