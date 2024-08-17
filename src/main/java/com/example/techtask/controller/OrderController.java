package com.example.techtask.controller;

import com.example.techtask.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Attention! Only DI and service interaction applicable in this class. Each controller method
 * should only contain a call to the corresponding service method
 */
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

  // DI here

  @GetMapping("desired-order")
  public Order findOrder() {
    return null;
  }

  @GetMapping("desired-orders")
  public List<Order> findOrders() {
    return null;
  }
}
