package io.renatofreire.poc_spring_kafka.Controller;

import io.renatofreire.poc_spring_kafka.DTO.UserDTO;
import io.renatofreire.poc_spring_kafka.Kafka.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/producer")
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
    public UserDTO publish(@RequestBody UserDTO user){
        kafkaProducer.sendMessage(user.toJson());
        return user;
    }

}
