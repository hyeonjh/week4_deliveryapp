package com.sparta.week4_deliveryapp.service;

import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.model.Restaurant;
import com.sparta.week4_deliveryapp.repository.FoodRepository;
import com.sparta.week4_deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private  final FoodRepository foodRepository;
    private  final RestaurantRepository restaurantRepository;


//    //음식 등록
//    public void registerFood(FoodRequestDto requestDto) {
//        String foodName = requestDto.getFoodName();
//        Long foodPrice = requestDto.getFoodPrice();
//
//        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
//                ()-> new IllegalArgumentException("음식점 아이디가 존재하지 않습니다.")
//        );
//
//
//        // find repository로 찾아와서 넣어라
//
//        Food food = new Food(foodName,foodPrice,restaurant);
//
//        foodRepository.save(food);
//    }
    //음식 전체 조회
//    public List<Food> findFoods(Restaurant restaurant) {
//        return foodRepository.findAllByRestaurant(restaurant);
//    }
@Transactional
    public List<Food> addFoods(FoodRequestDto requestDto, Long restaurantId) {
//        List<Food> foodList = new ArrayList<>();
//        for (String foodNames : foodName){
//            Food food = new Food(foodNames,foodPrice,restaurant);
//            foodList.add(food);
//        }
//        List<Food> savedFoodList = foodRepository.saveAll(foodList);
//        return savedFoodList;

        String foodName = requestDto.getFoodName();
        Long foodPrice = requestDto.getFoodPrice();
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                ()-> new IllegalArgumentException("음식점 아이디가 존재하지 않습니다.")
        );
        // find repository로 찾아와서 넣어라

        Food food = new Food(foodName,foodPrice,restaurantId);

        return (List<Food>) foodRepository.save(food);
    }

    public Food registerFood(Long restaurantId, FoodRequestDto requestDto) {

        Food food = new Food(requestDto);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new NullPointerException("음식점 아이디가 존재하지 않습니다.")
        );
    }
    public List<Food> getFoodByRestaurantList(Long restaurantId) {
    }

//    public List<Food> addFoods(FoodRequestDto requestDto, Long restaurantId) {
//    }
}
