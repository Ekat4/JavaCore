package ru.innopolis.StyleFit.models;

import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    private Date workoutDate;
    private int totalWorkouts;

    public Object getWorkoutDate() {
        return null;
    }

    public Client getClient() {
        return null;
    }

    // Геттеры и сеттеры
}


