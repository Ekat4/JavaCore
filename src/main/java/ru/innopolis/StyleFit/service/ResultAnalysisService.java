package ru.innopolis.StyleFit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.StyleFit.repositories.ResultRepository;

import java.util.List;

@Service
public class ResultAnalysisService {

    @Autowired
    private ResultRepository resultRepository; // Репозиторий для получения результатов

    // Метод для расчета среднего результата
    public double calculateAverageResults(Long athleteId) {
        List<ru.innopolis.StyleFit.models.Result> results = resultRepository.findByAthlete_Id(athleteId); // Получаем результаты спортсмена
        if (results.isEmpty()) {
            return 0.0; // Возвращаем 0, если нет результатов
        }
        // Вычисляем среднее значение
        return results.stream()
                .mapToDouble(ru.innopolis.StyleFit.models.Result::getTotalWorkouts) // Предполагаем, что есть метод getTotalWorkouts
                .average()
                .orElse(0.0); // Возвращаем 0, если не удалось вычислить среднее
    }

    // Дополнительные методы для анализа результатов можно добавить здесь
}
