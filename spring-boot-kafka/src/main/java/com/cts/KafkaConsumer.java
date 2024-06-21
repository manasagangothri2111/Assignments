package com.cts;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import static java.lang.String.format;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "Topic1", groupId = "myGroup")
	public void consume(String message) {
		log.info(format("Consuming the message from Topic1 :: %s", message));
	}

}
