package com.example.techtask.service.impl;

import com.example.techtask.repository.UserRepository;
import com.example.techtask.model.Order;
import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import com.example.techtask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser() {

        Function<User, Double> sumOfOrder = (a) -> a.getOrders().stream()
                .filter((x) -> (x.getOrderStatus().equals(OrderStatus.DELIVERED) && x.getCreatedAt().getYear() == 2003))
                .mapToDouble(Order::getPrice)
                .sum();

        return userRepository.findAll().stream()
                .max(Comparator.comparing(sumOfOrder))
                .orElseThrow(() -> new NoSuchElementException("There is no user in orders from 2003"));
    }

    @Override
    public List<User> findUsers() {
        LocalDateTime startDate = LocalDateTime.of(2010, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2010, 12, 31, 23, 59);
        return userRepository.findUsersByCreatedAtTwoThousandsTenWithPaidStatus(startDate, endDate)
                .orElseThrow(() -> new NoSuchElementException("There is no user in orders from 2003"));
    }
}
