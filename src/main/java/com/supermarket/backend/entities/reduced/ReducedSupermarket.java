package com.supermarket.backend.entities.reduced;

/**
 * @author Collin Alpert
 */
public class ReducedSupermarket {

	private long id;
	private String name;
	private int capacity;
	private String street;
	private String houseNumber;
	private int postalCode;

	public ReducedSupermarket(long id, String name, int capacity, String street, String houseNumber, int postalCode) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
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
}
