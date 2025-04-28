package ru.innopolis.StyleFit.dto;

import java.util.Objects;

public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    // Default constructor
    public ClientDto() {}

    // Parameterized constructor
    public ClientDto(Long id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDto clientDto)) return false;
        return Objects.equals(id, clientDto.id) &&
                Objects.equals(name, clientDto.name) &&
                Objects.equals(email, clientDto.email) &&
                Objects.equals(phoneNumber, clientDto.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber);
    }

    // Optional: Override toString for easier debugging
    @Override
    public String toString() {
        return "ClientDto{id=" + id + ", name='" + name + "', email='" + email + "', phoneNumber='" + phoneNumber + "'}";
    }
}
