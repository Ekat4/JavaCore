


package ru.innopolis.StyleFit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "client", schema = "public")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private double discount;

    @OneToMany(mappedBy = "client")
    private List<Workout> workouts;
    private String name;
    // Геттеры и сеттеры


    public String getFirstName() {
        return this.firstName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        String name = "Иван Иванов";
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }
}

