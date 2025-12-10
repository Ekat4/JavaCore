package ru.innopolis.StyleFit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Result; // Импортируйте класс Result
import ru.innopolis.StyleFit.repositories.ResultRepository;
import ru.innopolis.StyleFit.service.ResultAnalysisService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ResultAnalysisServiceTest {

    @InjectMocks
    private ResultAnalysisService resultAnalysisService;

    @Mock
    private ResultRepository resultRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class CalculateAverageResultsTests {

        @Test
        void testCalculateAverageResults_WithResults() {

            Long athleteId = 1L;
            Athlete athlete = new Athlete();
            athlete.setId(athleteId);

            List<Result> results = Arrays.asList(
                    new Result(1L, athlete, "Event1", 5.0, new Date()),
                    new Result(2L, athlete, "Event2", 10.0, new Date()),
                    new Result(3L, athlete, "Event3", 15.0, new Date())
            );


            when(resultRepository.findByAthlete_Id(athleteId)).thenReturn(results);

            // Вызов метода
            double average = resultAnalysisService.calculateAverageResults(athleteId);

            // Отладочная информация
            System.out.println("Average calculated: " + average);

            // Проверка
            assertEquals(10.0, average, 0.01);
        }

        @Test
        void testCalculateAverageResults_WithoutResults() {
            // Настройка мока
            Long athleteId = 1L;
            when(resultRepository.findByAthlete_Id(athleteId)).thenReturn(Collections.emptyList());

            // Вызов метода
            double average = resultAnalysisService.calculateAverageResults(athleteId);

            // Проверка
            assertEquals(0.0, average, 0.01); // Проверяем, что среднее значение равно 0.0
        }
    }
}
