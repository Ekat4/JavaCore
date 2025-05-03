package ru.innopolis.StyleFit.models;

import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


        private Date workoutDate;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client client; // Убедитесь, что это поле есть

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    // Геттеры и сеттеры
    }


