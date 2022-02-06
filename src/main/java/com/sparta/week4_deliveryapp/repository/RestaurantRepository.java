package com.sparta.week4_deliveryapp.repository;


import com.sparta.week4_deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
