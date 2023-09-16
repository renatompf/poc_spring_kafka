package io.renatofreire.poc_spring_kafka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "users")

public class User {
    private String name;

    @Id
    private String email;
    private Date dateOfBirth;
    private Long phoneNumber;

    public User() {
    }

    public User(String name, String email, Date dateOfBirth, Long phoneNumber) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return "{" +
                "\"name\":\""  + name + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"dateOfBirth\":\"" + sdf.format(dateOfBirth) + '\"' +
                ", \"phoneNumber\":" + phoneNumber
                + '}';
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
