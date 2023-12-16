package com.tech.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.tech.constant.ApplicationConstant;

public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String payload) {
		LOGGER.info("sending payload='{}'", payload);
		kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, payload);
	}

}
