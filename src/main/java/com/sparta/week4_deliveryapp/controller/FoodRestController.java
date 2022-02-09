package com.sparta.week4_deliveryapp.controller;


import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodRestController {

    private final FoodService foodService;

    @Autowired
    public FoodRestController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Food registerFood(@PathVariable Long restaurantId,@RequestBody FoodRequestDto requestDto){

        foodService.registerFood(restaurantId,requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoodByRestaurantList(@PathVariable Long restaurantId){
        return foodService.getFoodByRestaurantList(restaurantId);
    }



}

