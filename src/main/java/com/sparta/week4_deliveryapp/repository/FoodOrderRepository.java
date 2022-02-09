package com.sparta.week4_deliveryapp.repository;


import com.sparta.week4_deliveryapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<Orders,Long> {
}
