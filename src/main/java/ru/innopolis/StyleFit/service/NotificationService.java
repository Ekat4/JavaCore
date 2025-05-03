package ru.innopolis.StyleFit.service;

import org.springframework.stereotype.Service;

import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Client;
import ru.innopolis.StyleFit.models.Result;
import ru.innopolis.StyleFit.models.Workout;



@Service
public class NotificationService {

    public void sendResultsUpdate(Athlete athlete, Result result) {
        if (result != null) {
            String message = String.format("Поздравляем, %s! Ваш новый результат: %f.",
                    athlete.getFirstName(), result.getTotalWorkouts());
            // Логика отправки уведомления
            System.out.println(message);
        } else {
            System.out.println("Результат не найден.");
        }
    }

    public void sendWorkoutReminder(Client client, Workout workout) {
    }
}

    // Другие методы для уведомлений


