package io.renatofreire.poc_spring_kafka.Kafka;

import io.renatofreire.poc_spring_kafka.DTO.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);



    @KafkaListener(topics = "newTopicJson", groupId = "group")
    public void consume(UserDTO message){
        logger.info("Read message { " + message.getEmail() +" } from the Kafka Topic");
    }
}
