package ru.innopolis.StyleFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.models.Trainer;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findAll();
    void deleteAll();
    Optional<Trainer> findById(Long id);
    List<Trainer> findByWorkouts_WorkoutDate(Date date);
}
