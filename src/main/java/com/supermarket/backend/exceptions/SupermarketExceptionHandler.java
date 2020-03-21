package com.supermarket.backend.exceptions;


import com.supermarket.backend.modules.LoggingModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Collin Alpert
 */
@ControllerAdvice
public class SupermarketExceptionHandler {

	private final LoggingModule logger;

	public SupermarketExceptionHandler(LoggingModule loggingModule) {
		this.logger = loggingModule;
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<Map<String, Object>> handleSQLException(SQLException exception) {
		exception.printStackTrace();
		this.logger.log(exception);

		return ResponseEntity.unprocessableEntity().body(Map.of("message", exception.getMessage(), "success", false));
	}

	@ExceptionHandler(EmptyOptionalException.class)
	public ResponseEntity<Map<String, Object>> handleEmptyOptionalException(EmptyOptionalException exception) {
		return ResponseEntity.badRequest().body(Map.of("message", exception.getMessage(), "success", false));
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<Map<String, Object>> handleIoException(IOException exception) {
		exception.printStackTrace();
		this.logger.log(exception);

		return ResponseEntity.badRequest().body(Map.of("message", exception.getMessage(), "success", false));
	}
}
