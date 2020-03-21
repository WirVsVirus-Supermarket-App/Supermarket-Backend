package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.ForeignKeyEntity;
import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

import java.time.LocalTime;
import java.util.StringJoiner;

/**
 * @author Collin Alpert
 */
@TableName("timeSlot")
public class TimeSlot extends BaseEntity {

	private long id;
	private LocalTime begin;
	private LocalTime end;

	private long supermarketId;

	@ForeignKeyEntity("supermarketId")
	private Supermarket supermarket;

	public TimeSlot(LocalTime begin, LocalTime end, long supermarketId) {
		this.begin = begin;
		this.end = end;
		this.supermarketId = supermarketId;
	}

	public TimeSlot() {
	}

	@Override
	public long getId() {
		return id;
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

	public Supermarket getSupermarket() {
		return supermarket;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", TimeSlot.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("begin=" + begin)
				.add("end=" + end)
				.add("supermarketId=" + supermarketId)
				.add("supermarket=" + supermarket)
				.toString();
	}
}
