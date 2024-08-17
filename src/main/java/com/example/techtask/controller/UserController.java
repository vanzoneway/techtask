package com.example.techtask.controller;

import com.example.techtask.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Attention! Only DI and service interaction applicable in this class. Each controller method
 * should only contain a call to the corresponding service method
 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

  // DI here

  @GetMapping("desired-user")
  public User findUser() {
    return null;
  }

  @GetMapping("desired-users")
  public List<User> findUsers() {
    return null;
  }
}
