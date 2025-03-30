package ru.innopolis.jpademo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.jpademo.model.Order;
import ru.innopolis.jpademo.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByDate(LocalDate date) {
        return orderRepository.findByOrderDate(date);
    }
}
