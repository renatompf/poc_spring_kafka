package io.renatofreire.poc_spring_kafka.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
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
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
    @KafkaListener(topics = "newTopic", groupId = "group")
    public void consume(String message){
        try{
            UserDTO user = objectMapper.readValue(message, UserDTO.class);
            logger.info("The message was a user, the user was:" + message);
        } catch (JsonMappingException e) {
            logger.info("Could not deserialize to user, the message was:" + message);
        } catch (JsonProcessingException e) {
            logger.info("Could not deserialize to user or String:" + message);
        }
        logger.info("I received " + message);
    }
}
