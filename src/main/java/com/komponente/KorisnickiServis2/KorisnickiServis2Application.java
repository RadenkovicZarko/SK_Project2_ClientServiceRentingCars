package com.komponente.KorisnickiServis2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KorisnickiServis2Application {

	public static void main(String[] args) {
		SpringApplication.run(KorisnickiServis2Application.class, args);
	}

}
