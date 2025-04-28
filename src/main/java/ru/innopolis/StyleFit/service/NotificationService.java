package ru.innopolis.StyleFit.service;
import org.springframework.stereotype.Service;
import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.models.Result;
import ru.innopolis.StyleFit.models.Workout;

@Service
public class NotificationService {

    public void sendWorkoutReminder(Client client, Workout workout) {
        String message = String.format("Здравствуйте, %s! Не забудьте о вашей тренировке %s.",
                client.getFirstName(), workout.getWorkoutDate());
        // Логика отправки уведомления (например, через почту или SMS)
        System.out.println(message);
    }

    public void sendResultsUpdate(Athlete athlete) {
        Result result = null;
        String message = String.format("Поздравляем, %s! Ваш новый результат: %d.",
                athlete.getFirstName(), result.getTotalWorkouts());
        // Логика отправки уведомления
        System.out.println(message);
    }

    // Другие методы для уведомлений
}


