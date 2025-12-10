package ru.innopolis.StyleFit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Result;
import ru.innopolis.StyleFit.service.NotificationService;

import static org.mockito.Mockito.when;

class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private Athlete athlete;

    @Mock
    private Result result;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendResultsUpdate_WithValidResult() {
        // Настройка
        when(athlete.getFirstName()).thenReturn("Иван");
        when(result.getTotalWorkouts()).thenReturn(5.0); // Возвращаем Double

        // Вызов метода
        notificationService.sendResultsUpdate(athlete, result);

        // Проверка
        // В данном случае можно использовать System.out или другой механизм для проверки вывода
    }


    @Test
    public void testSendResultsUpdate_WithNullResult() {
        // Настройка
        when(athlete.getFirstName()).thenReturn("Иван");

        // Вызов метода
        notificationService.sendResultsUpdate(athlete, null);

        // Проверка
        // Здесь также можно проверить вывод или поведение
    }

    // Здесь можно добавить дополнительные тесты для метода sendWorkoutReminder
}