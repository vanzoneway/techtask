package com.example.techtask.model;

import com.example.techtask.model.enumiration.UserStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!

@Entity
@Table(name = "users")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class User {
  @Id private int id;
  private String email;

  @Column(name = "user_status")
  @Enumerated(value = EnumType.STRING)
  private UserStatus userStatus;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private List<Order> orders;
}
