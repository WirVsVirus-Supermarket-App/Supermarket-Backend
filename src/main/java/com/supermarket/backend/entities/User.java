package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.Default;
import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

/**
 * @author Collin Alpert
 */
@TableName("user")
public class User extends BaseEntity {

	private String name;
	private String email;
	private String password;

	@Default
	private String token;

	private String street;
	private String houseNumber;
	private int postalCode;

	public User(String name, String email, String password, String street, String houseNumber, int postalCode) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
	}

	public User() {
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

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}
}
