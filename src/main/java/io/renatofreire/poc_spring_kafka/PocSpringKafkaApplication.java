package io.renatofreire.poc_spring_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocSpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocSpringKafkaApplication.class, args);
        System.out.println("Hello from my Kafka Application");
    }

}
