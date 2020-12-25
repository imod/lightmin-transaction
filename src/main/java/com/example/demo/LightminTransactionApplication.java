package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tuxdevelop.spring.batch.lightmin.annotation.EnableLightminEmbedded;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;

import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;

@SpringBootApplication
@EnableLightminEmbedded
@EnableLightminJdbcConfigurationRepository
public class LightminTransactionApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LightminTransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LightminTransactionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			LOGGER.info("init data...");
			// save some persons
			repository.save(new Person("Starter", "Meister"));
			LOGGER.info("init data done");
		};
	}
}
