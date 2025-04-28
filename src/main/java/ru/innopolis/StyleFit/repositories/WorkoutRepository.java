package ru.innopolis.StyleFit.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.StyleFit.models.Workout;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findAll();
    void deleteAll();
    Optional<Workout> findById(Long id);
    List<Workout> findByWorkoutDate(Date date);
}
