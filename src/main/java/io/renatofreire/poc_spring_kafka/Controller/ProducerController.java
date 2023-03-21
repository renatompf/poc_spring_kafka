package io.renatofreire.poc_spring_kafka.Controller;

import io.renatofreire.poc_spring_kafka.DTO.UserDTO;
import io.renatofreire.poc_spring_kafka.Kafka.KafkaJsonProducer;
import io.renatofreire.poc_spring_kafka.Kafka.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/producer")
public class ProducerController {

//    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public ProducerController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }


//    @GetMapping
//    public String publish(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
//        return message;
//    }

    @PostMapping
    public UserDTO publish(@RequestBody UserDTO user){
        kafkaJsonProducer.sendMessage(user);
        return user;
    }

}
