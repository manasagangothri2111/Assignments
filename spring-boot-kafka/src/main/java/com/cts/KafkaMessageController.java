package com.cts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class KafkaMessageController {

	private final KafkaProducer producer;

	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String message) {

		producer.sendMessage(message);

		return ResponseEntity.ok("Message Sent to the Topic Successfully!");

	}

}
