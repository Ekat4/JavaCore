package ru.innopolis.StyleFit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Athlete athlete;

    private String event;
    private double score; // Изменено на double
    private Date workoutDate;

    public Result() {
    }

    public Result(Long id, Athlete athlete, String event, double score, Date workoutDate) {
        this.id = id;
        this.athlete = athlete;
        this.event = event;
        this.score = score;
        this.workoutDate = workoutDate;
    }

    public Result(long l, Long athleteId, double v) {
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public String getEvent() {
        return event;
    }

    public double getScore() {
        return score; // Изменено на double
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    // Сеттеры
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setScore(double score) { // Изменено на double
        this.score = score;
    }

    public void setWorkoutDate(Date workoutDate) {
        this.workoutDate = workoutDate;
    }

    public Object getTotalWorkouts() {
        return null;
    }
}
