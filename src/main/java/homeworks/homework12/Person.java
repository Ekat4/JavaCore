package homeworks.homework12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate; // формат dd.mm.yyyy
    private long phoneNumber; // беззнаковое целое
    private char gender; // 'f' или 'm'
    private int age;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(String birthDate) {
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Дата рождения должна быть в формате dd.mm.yyyy");
        }
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Пол должен быть 'f' или 'm'");
        }
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return surname + name + patronymic + birthDate + " " + phoneNumber + " " + gender;
    }
}