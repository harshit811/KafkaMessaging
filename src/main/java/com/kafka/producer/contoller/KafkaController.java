package com.kafka.producer.contoller;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.domain.InventoryAvailabilityRequest;

@Component
@CrossOrigin("*")
@RestController

public class KafkaController {

	/*
	 * @PostMapping(value = "${kafka.dataprocess.api}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public void process(@RequestBody
	 * InventoryAvailabilityRequest inventoryAvailabilityRequest) {
	 */

	@PostMapping(value = "${kafka.dataprocess.api}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void getInventoryAvailabilityByProductAndLocation(@RequestHeader HttpHeaders headers,
			@RequestBody InventoryAvailabilityRequest inventoryAvailabilityRequest) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

		KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);

		ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>("mytopic","H1234",
				inventoryAvailabilityRequest.toString().getBytes());
		producer.send(record);

		producer.close();
	}

}
