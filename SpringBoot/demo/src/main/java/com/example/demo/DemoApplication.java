package com.example.demo;

import com.example.demo.components.EmailClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Value("${email.message}")
	private String message;
	private String email;
	private EmailClient client;
	public DemoApplication(EmailClient client) {

		this.client = client;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		client.sendEmail(message);
	}
}
