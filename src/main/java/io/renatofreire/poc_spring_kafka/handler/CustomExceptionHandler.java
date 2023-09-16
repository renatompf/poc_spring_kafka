package io.renatofreire.poc_spring_kafka.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
     ResponseEntity<String> EntityNotFoundExceptionHandler(NoSuchElementException exception){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
