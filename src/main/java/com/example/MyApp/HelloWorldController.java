package com.example.MyApp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Hello greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Hello(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/doSomething")
	public Hello doSomething(
			@RequestParam(value = "name", defaultValue = "2") Integer value) {
		return new Hello(value*value, "blahblah");
	}
}

// http://localhost:8080/greeting?name=blah
// ./mvnw spring-boot:run
