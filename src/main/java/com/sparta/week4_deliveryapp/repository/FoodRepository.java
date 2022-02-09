package com.sparta.week4_deliveryapp.repository;

import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

//    List<Food> findAllByRestaurant(Restaurant restaurant);


    Food findByName(String name);

    List<Food> findAllByRestaurant(Long restaurantId);
}
