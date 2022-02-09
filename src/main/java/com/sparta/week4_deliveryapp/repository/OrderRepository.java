package com.sparta.week4_deliveryapp.repository;


import com.sparta.week4_deliveryapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
