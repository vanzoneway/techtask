package com.example.techtask.model;

import com.example.techtask.model.enumiration.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Attention! It is FORBIDDEN to make any changes in this file!

@Entity
@Table(name = "orders")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Order {
  @Id private int id;

  @Column(name = "product_name")
  private String productName;

  private double price;
  private int quantity;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "order_status")
  @Enumerated(value = EnumType.STRING)
  private OrderStatus orderStatus;
}
