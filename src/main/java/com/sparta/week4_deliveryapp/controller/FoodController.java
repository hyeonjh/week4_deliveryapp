//package com.sparta.week4_deliveryapp.controller;
//
//
//import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
//import com.sparta.week4_deliveryapp.model.Food;
//import com.sparta.week4_deliveryapp.model.Restaurant;
//import com.sparta.week4_deliveryapp.service.FoodService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class FoodController {
//
//    private final FoodService foodService;
//
//
//    // 음식 등록 페이지
////    /restaurant/{restaurantId}/food/register
//    @GetMapping("/food/new")
//    public String food(){
//        return "registerFood";
//    }
//
//
//    //음식 등록 요청 처리
//    @PostMapping("/food/new")
//    public String registerFood(@RequestBody FoodRequestDto requestDto){
//        foodService.registerFood(requestDto);
//        System.out.println(requestDto);
//        System.out.println("==================");
//        return "home";
//    }
//
//    //등록된 음식 리스트
////    /restaurant/{restaurantId}/foods
//    @GetMapping("/foods")
//    public String foodlist(Model model, Restaurant restaurant){
//        List<Food> foods = foodService.findFoods(restaurant);
//
//        System.out.println(foods);
//        model.addAttribute("foods",foods);
//        return "foodList";
//    }
//
//
//
//}
