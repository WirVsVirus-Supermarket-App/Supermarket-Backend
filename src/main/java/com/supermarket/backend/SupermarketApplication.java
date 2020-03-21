package com.supermarket.backend;

import com.github.collinalpert.java2db.database.DBConnection;
import com.supermarket.backend.config.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DatabaseConfiguration.class)
public class SupermarketApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SupermarketApplication.class, args);
		var databaseConfig = context.getBean(DatabaseConfiguration.class);

		DBConnection.HOST = databaseConfig.getHost();
		DBConnection.DATABASE = databaseConfig.getDatabaseName();
		DBConnection.USERNAME = databaseConfig.getUsername();
		DBConnection.PASSWORD = databaseConfig.getPassword();
	}

}
