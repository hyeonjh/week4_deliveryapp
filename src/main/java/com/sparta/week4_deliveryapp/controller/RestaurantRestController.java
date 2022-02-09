package com.sparta.week4_deliveryapp.controller;


import com.sparta.week4_deliveryapp.dto.RestaurantRequestDto;
import com.sparta.week4_deliveryapp.model.Restaurant;
import com.sparta.week4_deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    //생성
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody @Valid RestaurantRequestDto requestDto) {
        Restaurant restaurant = restaurantService.registerRestaurant(requestDto);
        System.out.println(restaurant);
        return restaurant;
    }
    //조회
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){return restaurantService.getAllRestaurant();}
}
