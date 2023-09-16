package io.renatofreire.poc_spring_kafka.service;

import io.renatofreire.poc_spring_kafka.model.User;
import io.renatofreire.poc_spring_kafka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addNewUser(User newUser) {
        Optional<User> user = userRepository.findById(newUser.getEmail());
        if (user.isPresent()){
            return false;
        }

        userRepository.save(newUser);
        return true;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getByEmail(String email){
        return userRepository.findById(email).orElseThrow(NoSuchElementException::new);
    }

}
