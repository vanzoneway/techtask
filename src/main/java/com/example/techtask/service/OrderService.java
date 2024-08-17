package com.example.techtask.service;

import com.example.techtask.model.Order;
import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.UserStatus;

import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!

public interface OrderService {

  /**
   * Finds the newest {@link Order} that contains more than one item
   *
   * @return desirable {@link Order}
   */
  Order findOrder();

  /**
   * Finds only {@link Order}s from {@link UserStatus#ACTIVE} {@link User}s sorted by {@link Order}
   * creation
   *
   * @return desirable {@link Order}s
   */
  List<Order> findOrders();
}
