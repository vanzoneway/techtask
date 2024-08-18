package com.example.techtask.repository;

import com.example.techtask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findFirstByQuantityGreaterThanOrderByCreatedAtDesc(int quantity);

    @Query("SELECT o FROM Order o WHERE YEAR(o.createdAt) = 2003 AND o.orderStatus = 'DELIVERED'")
    Optional<List<Order>> findDeliveredOrdersFromTwoThousandThree();

}
