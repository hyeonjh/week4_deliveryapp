package com.sparta.week4_deliveryapp.service;

import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private  final FoodRepository foodRepository;


    //음식 등록
    public void registerFood(FoodRequestDto requestDto) {
        String foodName = requestDto.getFoodName();
        Long foodPrice = requestDto.getFoodPrice();
        Food food = new Food(foodName,foodPrice);
        foodRepository.save(food);
    }
    //음식 전체 조회
    public List<Food> findFoods() {
        return foodRepository.findAll();
    }
}
