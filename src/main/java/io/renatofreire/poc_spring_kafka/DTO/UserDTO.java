package io.renatofreire.poc_spring_kafka.DTO;

public class UserDTO {
    private String name;
    private String email;
    private Long phoneNumber;

    public UserDTO() {
    }

    public UserDTO(String name, String email, Long phoneNumber) {
        this.name = name;
        this.email = email;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toJson() {
        return "{" +
                "\"name\":\""  + name + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"phoneNumber\":" + phoneNumber
                + '}';
    }
}
