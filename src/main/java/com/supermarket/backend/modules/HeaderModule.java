package com.supermarket.backend.modules;

import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * @author Collin Alpert
 */
@Component
public class HeaderModule {

	private static final int basicStartIndex = "Basic".length();

	public String getBasicAuthorizationToken(String authorizationHeader) {
		var token = authorizationHeader.substring(basicStartIndex).trim();

		return new String(Base64.getDecoder().decode(token));
	}
}
