package com.example.techtask.service.impl;

import com.example.techtask.repository.OrderRepository;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.model.Order;
import com.example.techtask.model.User;
import com.example.techtask.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public Order findOrder() {
        return orderRepository.findFirstByQuantityGreaterThanOrderByCreatedAtDesc(1)
                .orElseThrow(() -> new NoSuchElementException("No orders found with more than one item"));
    }

    @Override
    public List<Order> findOrders() {
        List<User> usersWithActiveStatus = userRepository.findByActiveUserStatus()
                .orElseThrow(() -> new NoSuchElementException("No active users found"));

        return usersWithActiveStatus.stream()
                .flatMap(u -> u.getOrders().stream())
                .sorted(Comparator.comparing(Order::getCreatedAt))
                .collect(Collectors.toList());
    }
}
