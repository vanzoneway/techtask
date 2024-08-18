package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "SELECT * FROM users WHERE user_status = 'ACTIVE' ", nativeQuery = true)
    Optional<List<User>> findByActiveUserStatus();

    @Query(value = """
            SELECT u FROM User u
            JOIN u.orders o
            WHERE o.createdAt BETWEEN :startDate AND :endDate
            AND o.orderStatus = 'PAID'
            """)
    Optional<List<User>> findUsersByCreatedAtTwoThousandsTenWithPaidStatus(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );


}
