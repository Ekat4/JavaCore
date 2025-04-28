package ru.innopolis.StyleFit.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.StyleFit.models.Athlete;

import java.util.Date;
import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    List<Athlete> findByResults_WorkoutDate(Date workoutDate);
}
