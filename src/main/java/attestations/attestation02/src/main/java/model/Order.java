package ru.innopolis.jpademo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id; // Уникальный идентификатор заказа

    @ManyToOne // Связь с покупателем
    @JoinColumn(name = "user_id", nullable = false)
    private ru.innopolis.jpademo.model.Users user; // Идентификатор покупателя

    private LocalDate orderDate; // Дата заказа
    private int totalQuantity; // Общее число заказов
    private double discount; // Скидка покупателя
}
