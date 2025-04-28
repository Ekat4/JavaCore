package ru.innopolis.StyleFit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.StyleFit.models.Result; // Убедитесь, что импортируете правильный класс
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByAthlete_Id(Long athleteId); // Метод для получения результатов по ID спортсмена
}
