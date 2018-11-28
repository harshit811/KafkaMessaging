/*package com.kafka.producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.kafka.producer" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SimpleStringProducer  {
	public static void main(String[] args) {
		SpringApplication.run(SimpleStringProducer.class, args);
	}
}
*/

package com.kafka.producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.kafka.producer" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SimpleStringProducer extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SimpleStringProducer.class, args);
	}
	
	/**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(SimpleStringProducer.class);
	}
}






//package com.kafka.producer;
//
//import java.util.Properties;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//
//public class SimpleStringProducer {
//
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i < 100; i++) {
//            ProducerRecord<String, String> record = new ProducerRecord<>("mytopic", "value-" + i);
//            producer.send(record);
//        }
//
//        producer.close();
//    }
//}
