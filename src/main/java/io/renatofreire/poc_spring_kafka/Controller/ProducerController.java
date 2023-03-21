package io.renatofreire.poc_spring_kafka.Controller;

import io.renatofreire.poc_spring_kafka.Kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka/producer")
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping
    public String publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return message;
    }

}
