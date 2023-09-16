package io.renatofreire.poc_spring_kafka.repository;

import io.renatofreire.poc_spring_kafka.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
