package ru.innopolis.StyleFit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainer", schema = "public")

public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "trainer")
    private List<Workout> workouts;

    // Геттеры и сеттеры
}
