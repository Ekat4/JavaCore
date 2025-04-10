package ru.innopolis.springaop.util;

import lombok.Getter;

/**
 * Ответ по поиску книги
 */
@Getter
public enum CustomStatus {

    SUCCESS(0, "Success"),
    NOT_FOUND(1, "Not found"),
    EXCEPTION(2, "Exception");

    private final int code;
    private final String message;

    CustomStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
