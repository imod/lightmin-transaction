package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;

@SpringBootTest
class LightminTransactionApplicationTests {

	@Autowired
	PersonRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void personsMustBePersisted() throws Exception {
		Iterable<Person> all = repository.findAll();
		assertTrue(all.iterator().hasNext());
	}

}
