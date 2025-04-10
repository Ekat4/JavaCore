package ru.innopolis.springaop.util;

import lombok.Data;

import java.util.Collection;

/**
 * Класс с настройкой Generic, который помогает единообразно обработать
 * ответ базы данных
 * @param <T>
 */
@Data
public class CustomResponse<T> {
    private int code; //код ответа сервиса
    private String message; //сообщение сервиса
    private Collection<T> responseList;

    public CustomResponse(Collection<T> response, CustomStatus customStatus) {
        this.code = customStatus.getCode();
        this.message = customStatus.getMessage();
        this.responseList = response;
    }
}
