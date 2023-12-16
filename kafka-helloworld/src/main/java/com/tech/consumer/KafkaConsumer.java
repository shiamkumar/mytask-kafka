package com.tech.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.tech.constant.ApplicationConstant;

public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING, 
			topics = ApplicationConstant.TOPIC_NAME, 
			containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessage(String message) {
		LOGGER.info("Message Received using Kafka Listener:: " + message);
	}

}
