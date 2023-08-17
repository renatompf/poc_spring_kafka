package io.renatofreire.poc_spring_kafka.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renatofreire.poc_spring_kafka.DTO.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @KafkaListener(topics = "newTopic", groupId = "group")
    public void consume(String message){
        try{
            UserDTO user = objectMapper.readValue(message, UserDTO.class);
            logger.info("A user was received:" + user.toString());
        } catch (JsonProcessingException e) {
            logger.info("The message was not a to user, the message: " + message + " was sent");
        }

    }
}
