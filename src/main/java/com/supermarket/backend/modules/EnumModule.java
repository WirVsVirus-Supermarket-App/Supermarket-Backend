package com.supermarket.backend.modules;

import com.github.collinalpert.java2db.contracts.IdentifiableEnum;
import org.springframework.stereotype.Component;

/**
 * @author Collin Alpert
 */
@Component
public class EnumModule {

	public <T extends Enum<T> & IdentifiableEnum> T parse(long id, T[] enumTypes) {
		for (var e : enumTypes) {
			if (e.getId() == id) {
				return e;
			}
		}

		return null;
	}
}
