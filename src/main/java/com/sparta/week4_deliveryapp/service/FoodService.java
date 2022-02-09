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
import java.util.Objects;

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
//@Transactional
//    public List<Food> addFoods(FoodRequestDto requestDto, Long restaurantId) {
////        List<Food> foodList = new ArrayList<>();
////        for (String foodNames : foodName){
////            Food food = new Food(foodNames,foodPrice,restaurant);
////            foodList.add(food);
////        }
////        List<Food> savedFoodList = foodRepository.saveAll(foodList);
////        return savedFoodList;
//
//        String foodName = requestDto.getFoodName();
//        Long foodPrice = requestDto.getFoodPrice();
//        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
//                ()-> new IllegalArgumentException("음식점 아이디가 존재하지 않습니다.")
//        );
//        // find repository로 찾아와서 넣어라
//
//        Food food = new Food(foodName,foodPrice,restaurantId);
//
//        return (List<Food>) foodRepository.save(food);
//    }

    public Food registerFood(Long restaurantId, List<FoodRequestDto> requestDto) {
//
//        for (Food food   : requestDto)
        List<Food> foodList = new ArrayList<>();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new NullPointerException("음식점 아이디가 존재하지 않습니다.")
        );
        for (FoodRequestDto foodRequestDto : requestDto) {

            Food food = new Food(foodRequestDto.getName(),foodRequestDto.getPrice(),restaurant);

            if(foodRequestDto.getPrice() < 100 || foodRequestDto.getPrice() >1000000){
                throw new IllegalArgumentException("허용값: 100원 ~ 1,000,000원");
            }

            if(foodRequestDto.getPrice()% 100 !=0){
                throw new IllegalArgumentException("100원단위로만 입력하세요");
            }

            Food food1 = foodRepository.findByName(foodRequestDto.getName());
            if (Objects.equals(food1.getName(), food.getName())){
                throw new IllegalArgumentException("같은 음식점 내에서는 음식 이름이 중복될 수 없음 ");
            }
//            foodRepository.save(food);
            foodList.add(food);
        }
//        List<Food> savedFoodList =
        List<Food> savedFoodList = foodRepository.saveAll(foodList);
        return (Food) savedFoodList;

//        return foodRepository.save(food);
    }



    public List<Food> getFoodByRestaurantList(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(

                ()->new NullPointerException("해당 음식점의 id가 없습니다.")
        );

        return foodRepository.findAllByRestaurant(restaurantId);


    }

//    public List<Food> addFoods(FoodRequestDto requestDto, Long restaurantId) {
//    }
}
