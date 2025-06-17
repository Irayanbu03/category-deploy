package com.example.category_service.configuration;

import java.util.HashMap;

import java.util.Map;
 
import org.apache.kafka.clients.admin.NewTopic;
 
import org.apache.kafka.clients.consumer.ConsumerConfig;
 
import org.apache.kafka.common.serialization.StringDeserializer;
 
import org.springframework.context.annotation.Bean;
 
import org.springframework.context.annotation.Configuration;
 
import org.springframework.kafka.annotation.EnableKafka;
 
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

 
import org.springframework.kafka.core.ConsumerFactory;
 
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
 
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.category_service.dto.Product;
 
 
 
//Annotation
 
@EnableKafka
 
@Configuration
 
//Class
 
public class KafkaConfiguration {
 
	
 
	@Bean
 
	public ConsumerFactory<String, Product> consumerFactory() {
 
		// Creating a map of string-object type
 
		Map<String, Object> config = new HashMap<>();
 
		// Adding the Configuration
 
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
 
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
 
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
 
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
 
		// Returning message in JSON format
 
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Product.class));
 
	}
 
	// Creating a Listener
 
	@Bean
 
	public ConcurrentKafkaListenerContainerFactory<String, Product> productListener() {
 
		ConcurrentKafkaListenerContainerFactory<String, Product> factory = new ConcurrentKafkaListenerContainerFactory<>();
 
		factory.setConsumerFactory(consumerFactory());
 
		return factory;
 
	}
 
 
}
 