package com.sparta.week4_deliveryapp.repository;

import com.sparta.week4_deliveryapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
