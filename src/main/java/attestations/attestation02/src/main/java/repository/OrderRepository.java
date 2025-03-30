package ru.innopolis.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.jpademo.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDate(LocalDate orderDate); // Получение заказов по дате
}
