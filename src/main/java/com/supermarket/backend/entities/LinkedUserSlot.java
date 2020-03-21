package com.supermarket.backend.entities;

import com.github.collinalpert.java2db.annotations.ForeignKeyEntity;
import com.github.collinalpert.java2db.annotations.TableName;
import com.github.collinalpert.java2db.entities.BaseEntity;

/**
 * @author Collin Alpert
 */
@TableName("linkedUserSlot")
public class LinkedUserSlot extends BaseEntity {

	private long userId;

	@ForeignKeyEntity("userId")
	private User user;

	private long slotId;

	@ForeignKeyEntity("slotId")
	private TimeSlot timeSlot;

	public LinkedUserSlot(long userId, long slotId) {
		this.userId = userId;
		this.slotId = slotId;
	}

	public LinkedUserSlot() {
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
