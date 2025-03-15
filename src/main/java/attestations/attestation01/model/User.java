package attestations.attestation01.model;

import java.time.LocalDateTime;

public class User {
    private String id;
    private LocalDateTime dateAdded;
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User(String id, String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName,
                Integer age, boolean isWorker) {
        this.id = id;
        this.dateAdded = LocalDateTime.now();
        setLogin(login);
        setPassword(password, confirmPassword);
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
        setAge(age);
        this.isWorker = isWorker;
    }

    public User(String validLogin, String validPassword) {
    }

    public User(String number, LocalDateTime now, String user1, String password1, String password11, String иванов, String иван, Object o, int i, boolean b) {
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setAge(Integer age) {
        this.age = age; // Можно добавить валидацию, если нужно
    }

    private void setFirstName(String firstName) {
        if (!firstName.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
            throw new IllegalArgumentException("Имя должно содержать только буквы");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (!lastName.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
            throw new IllegalArgumentException("Фамилия должна содержать только буквы");
        }
        this.lastName = lastName;
    }

    private void setPassword(String password, String confirmPassword) {
        if (password.length() > 20 || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[0-9].*") || !password.matches(".*_.*")) {
            throw new IllegalArgumentException("Пароль должен содержать буквы, цифры и знак подчеркивания, и быть менее 20 символов");
        }
        this.password = password;
    }


    private void setLogin(String login) {
        if (login.matches("\\d+")) {
            throw new IllegalArgumentException("Логин не может состоять только из цифр");
        }
        if (!login.matches("^[a-zA-Z0-9_]{1,20}$")) {
            throw new IllegalArgumentException("Логин должен содержать буквы, цифры и знак подчеркивания, и быть менее 20 символов");
        }
        this.login = login;
    }

    private void setMiddleName(String middleName) {
        if (middleName != null && !middleName.matches("[a-zA-Zа-яА-ЯёЁ]*")) {
            throw new IllegalArgumentException("Отчество должно содержать только буквы");
        }
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return String.join(",", id, dateAdded.toString(), login, password,
                lastName, firstName, middleName != null ? middleName : "",
                age != null ? age.toString() : "", String.valueOf(isWorker));
    }
}
