package com.cts.boot.boot_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cts.components.EmailClient;

@SpringBootApplication
@ComponentScan(basePackages = "com.cts.components")
public class BootDemoApplication implements CommandLineRunner {

	@Value("${email.message}")
	private String message;

	private EmailClient client;

	public BootDemoApplication(EmailClient client) {
		this.client = client;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		client.sendEmail(message);
	}
}
