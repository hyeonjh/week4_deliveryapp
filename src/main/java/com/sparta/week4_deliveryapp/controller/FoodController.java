package com.sparta.week4_deliveryapp.controller;


import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    // 음식 등록 페이지
    @GetMapping("/food/new")
    public String food(){
        return "registerFood";
    }
    //음식 등록 요청 처리
    @PostMapping("/food/new")
    public String registerFood(FoodRequestDto requestDto){
        foodService.registerFood(requestDto);
        return "home";
    }

    //등록된 음식 리스트
    @GetMapping("/foods")
    public String foodlist(Model model){
        List<Food> foods = foodService.findFoods();
        model.addAttribute("foods",foods);
        return "foodList";
    }



}
