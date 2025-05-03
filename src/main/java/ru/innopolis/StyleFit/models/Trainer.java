package ru.innopolis.StyleFit.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "trainer")
    private List<Workout> workouts; // Убедитесь, что это поле есть

    // Геттеры и сеттеры
}
