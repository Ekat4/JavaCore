package ru.innopolis.StyleFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.StyleFit.models.Client;
import java.util.Date;
import java.util.List;
import java.util.Optional;



public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAll();
    void deleteAll();
    Optional<Client> findById(Long id);
    List<Client> findByWorkouts_WorkoutDate(Date date);
}
