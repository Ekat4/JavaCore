package ru.innopolis.StyleFit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.StyleFit.models.Athlete;
import ru.innopolis.StyleFit.models.Result;
import ru.innopolis.StyleFit.service.NotificationService;
import ru.innopolis.StyleFit.service.ResultAnalysisService;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private ResultAnalysisService resultAnalysisService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notify/result")
    public ResponseEntity<String> notifyResultsUpdate(@RequestBody Result results) { // Замените Result на ваш класс
        Athlete athlete = results.getAthlete(); // Предполагая, что у вас есть метод getAthlete() в классе Result
        if (athlete != null) {
            notificationService.sendResultsUpdate(athlete);
            return ResponseEntity.ok("Уведомление о результате отправлено.");
        } else {
            return ResponseEntity.badRequest().body("Спортсмен не найден.");
        }
    }
}



