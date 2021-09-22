package com.hardware.procurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProcurementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcurementApplication.class, args);
	}

}
