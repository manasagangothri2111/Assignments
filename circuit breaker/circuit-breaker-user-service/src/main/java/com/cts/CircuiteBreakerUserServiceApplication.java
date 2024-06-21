package com.cts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@RequestMapping("/user-service")
@Slf4j
@EnableDiscoveryClient
public class CircuiteBreakerUserServiceApplication {

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	private static final String BASEURL = "http://CIRCUITE-BREAKER-CATALOG-SERVICE/api/v1/catalogs";

	private static final String USER_SERVICE = "userService";

	@GetMapping("/displayProducts")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "fallBack")
	public List<Product> displayProducts(@RequestParam(value = "category", required = false) String category) {
		String url = category == null ? BASEURL : BASEURL + "/" + category;
		log.info("inside displayproducts method of user service application");
		return restTemplate.getForObject(url, List.class);
	}

	public List<Product> fallBack(String param, Throwable throwable) {
		log.info("Response from FallBack Method");
		return Stream.of(new Product(1001, "LED TV", "electronics", "black", 25000.0),
				new Product(2002, "mac air", "electronics", "black", 85000.0),
				new Product(3003, "oneplus", "electronics", "black", 45000.0)).collect(Collectors.toList());
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CircuiteBreakerUserServiceApplication.class, args);
	}
}