package com.example.techtask.service;

import com.example.techtask.model.Order;
import com.example.techtask.model.User;

import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!

public interface UserService {

  /**
   * Finds the {@link User} with max common sum of the products delivered in 2003 year
   *
   * @return desirable {@link User}
   */
  User findUser();

  /**
   * Finds {@link User}s that have paid {@link Order}s in 2010
   *
   * @return desirable {@link User}s
   */
  List<User> findUsers();
}
