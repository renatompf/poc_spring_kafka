package io.renatofreire.poc_spring_kafka.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renatofreire.poc_spring_kafka.DTO.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserDTO userDTO){
        logger.info("Sent the user { " + userDTO.getEmail() +" } to the Kafka Topic");
        Message<UserDTO> message = MessageBuilder.withPayload(userDTO)
                        .setHeader(KafkaHeaders.TOPIC, "newTopicJson")
                        .build();

        kafkaTemplate.send(message);
    }
}
