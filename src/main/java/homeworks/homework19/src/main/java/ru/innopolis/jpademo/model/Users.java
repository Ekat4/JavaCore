package ru.innopolis.jpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;

}
