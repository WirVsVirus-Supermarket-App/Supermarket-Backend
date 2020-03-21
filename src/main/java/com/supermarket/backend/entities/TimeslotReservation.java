package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.ForeignKeyEntity;
import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

/**
 * @author Collin Alpert
 */
@TableName("timeslot_reservation")
public class TimeslotReservation extends BaseEntity {

	private long id;

	private long userId;

	@ForeignKeyEntity("userId")
	private User user;

	private long slotId;

	@ForeignKeyEntity("slotId")
	private TimeSlot timeSlot;

	public TimeslotReservation(long userId, long slotId) {
		this.userId = userId;
		this.slotId = slotId;
	}

	public TimeslotReservation() {
	}

	@Override
	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public User getUser() {
		return user;
	}

	public long getSlotId() {
		return slotId;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
}
