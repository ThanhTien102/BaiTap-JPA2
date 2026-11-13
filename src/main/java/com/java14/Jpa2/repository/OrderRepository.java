package com.java14.Jpa2.repository;

import com.java14.Jpa2.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    // Tìm order trong khoảng ngày: GET /orders?start=2026-11-01T00:00:00&end=2026-11-30T23:59:59
    List<OrderEntity> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    // Top 5 order có totalAmount lớn nhất
    List<OrderEntity> findTop5ByOrderByTotalAmountDesc();
}
