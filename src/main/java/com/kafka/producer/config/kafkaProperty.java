package com.kafka.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class kafkaProperty {

	  @Bean
	    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	        //String activeProfile = System.getProperty("spring.profiles.active", "development");
	       // String propertiesFilename = "app-" + activeProfile + ".properties";

		  String propertiesFilename = "application" + ".properties";
	        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
	        configurer.setLocation(new ClassPathResource(propertiesFilename));

	        return configurer;
	    }
}
