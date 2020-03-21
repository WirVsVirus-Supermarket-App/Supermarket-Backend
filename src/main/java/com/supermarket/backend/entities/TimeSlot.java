package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

import java.time.LocalTime;

/**
 * @author Collin Alpert
 */
@TableName("timeSlot")
public class TimeSlot extends BaseEntity {

	private LocalTime begin;
	private LocalTime end;
	private long supermarketId;

	public TimeSlot(LocalTime begin, LocalTime end, long supermarketId) {
		this.begin = begin;
		this.end = end;
		this.supermarketId = supermarketId;
	}

	public TimeSlot() {
	}

	public LocalTime getBegin() {
		return begin;
	}

	public LocalTime getEnd() {
		return end;
	}

	public long getSupermarketId() {
		return supermarketId;
	}
}
