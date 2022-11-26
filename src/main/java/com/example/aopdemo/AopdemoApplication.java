package com.example.aopdemo;

import com.example.aopdemo.entity.Client;
import com.example.aopdemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Autowired
	ClientRepository repository;

	@Bean
	CommandLineRunner commandLineRunner() {
		return (args) -> {
			Client.ClientBuilder clientBuilder = Client.builder();
			Client client1 = clientBuilder
					.name("C1")
					.dob(LocalDate.of(2000, 11, 10))
					.registerDate(LocalDate.now())
					.build();

			Client client2 = clientBuilder
					.name("Client2")
					.dob(LocalDate.of(1989, 4, 21))
					.registerDate(LocalDate.now())
					.build();

			repository.save(client1);
			repository.save(client2);
		};
	}

}
