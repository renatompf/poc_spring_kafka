package io.renatofreire.poc_spring_kafka.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renatofreire.poc_spring_kafka.model.User;
import io.renatofreire.poc_spring_kafka.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final UserService userService;

    @Autowired
    public KafkaConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "newTopic", groupId = "group")
    public void consume(String message){
        try{
            User user = objectMapper.readValue(message, User.class);
            logger.info("A user was received:" + user.toString());
            userService.addNewUser(user);
        } catch (JsonProcessingException e) {
            logger.info("The message was not a to user, the message: " + message + " was sent");
        }

    }
}
