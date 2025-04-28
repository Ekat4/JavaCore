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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация идентификатора
    private Long id;

    @ManyToOne // Указывает на связь с классом Athlete
    private Athlete athlete; // Поле для хранения объекта Athlete

    private String event; // Поле для события
    private String score; // Поле для результата
    private Date workoutDate; // Поле для даты тренировки

    // Конструктор без параметров (необходим для JPA)
    public Result() {
    }

    // Конструктор с параметрами
    public Result(Athlete athlete, String event, String score, Date workoutDate) {
        this.athlete = athlete;
        this.event = event;
        this.score = score;
        this.workoutDate = workoutDate; // Инициализация workoutDate
    }

    // Геттеры
    public Athlete getAthlete() {
        return athlete;
    }

    public String getEvent() {
        return event;
    }

    public String getScore() {
        return score;
    }

    public Date getWorkoutDate() {
        return workoutDate; // Геттер для workoutDate
    }

    // Сеттеры
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setWorkoutDate(Date workoutDate) { // Сеттер для workoutDate
        this.workoutDate = workoutDate;
    }

    // Метод для получения общего количества тренировок (можно уточнить логику)
    public double getTotalWorkouts() {
        return 0; // Здесь можно добавить логику для подсчета тренировок
    }

    // Геттер для id (если нужно)
    public Long getId() {
        return id;
    }
}
