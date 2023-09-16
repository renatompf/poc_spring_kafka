package io.renatofreire.poc_spring_kafka.controller;

import io.renatofreire.poc_spring_kafka.model.User;
import io.renatofreire.poc_spring_kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saved-users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("{userEmail}")
    ResponseEntity<User> getByEmail(@PathVariable String userEmail){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getByEmail(userEmail));
    }

}
