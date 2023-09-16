package io.renatofreire.poc_spring_kafka.controller;

import io.renatofreire.poc_spring_kafka.model.User;
import io.renatofreire.poc_spring_kafka.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/producer")
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public String publish(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return message;
    }

    @PostMapping("/user")
    public User publish(@RequestBody User user){
        kafkaProducer.sendMessage(user.toJson());
        return user;
    }

}
