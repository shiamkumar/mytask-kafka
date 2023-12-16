package com.tech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1")
public class kafkaRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(kafkaRestController.class);

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping("/produce/{message}")
	public String sendMessage(@PathVariable String message) {
		kafkaProducer.sendMessage(message);
		LOGGER.info("Message Sent to Kafka:: " + message);
		return message;
	}

}
