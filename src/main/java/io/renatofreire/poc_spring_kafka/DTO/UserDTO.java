package io.renatofreire.poc_spring_kafka.DTO;

import java.util.Date;

public class UserDTO {
    private String name;
    private Date dateOfBirth;
    private String email;
    private Long phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String name, Date dateOfBirth, String email, Long phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
