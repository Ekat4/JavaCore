package ru.innopolis.jpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Users { // Изменено на User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указана стратегия генерации
    private Long id;
    private String fullName; // Полное имя пользователя
}
