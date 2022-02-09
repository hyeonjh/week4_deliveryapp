package com.sparta.week4_deliveryapp.service;

import com.sparta.week4_deliveryapp.dto.RestaurantRequestDto;
import com.sparta.week4_deliveryapp.model.Restaurant;
import com.sparta.week4_deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

//    //음식점 등록.
//    public void registerRestaurant(RestaurantRequestDto requestDto) {
//        String name = requestDto.getName();
//        Long minOrderPrice = requestDto.getMinOrderPrice();
//        Long deliverFee= requestDto.getDeliveryFee();
//        Restaurant restaurant = new Restaurant(name,minOrderPrice,deliverFee);
//        restaurantRepository.save(restaurant);
//    }
//    //음식점 전체 조회
//    public List<Restaurant> findRestaurants() {
//        return restaurantRepository.findAll();
//    }

    //음식점 등록
    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant(requestDto);
        if(requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000){
            throw new IllegalArgumentException("허용값: 1,000원 ~ 100,000원");
        }

        if(requestDto.getMinOrderPrice() % 100 != 0){
            throw new IllegalArgumentException("100 원 단위로만 입력 가능합니다.");
        }
        if(requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() >10000 ){
            throw new IllegalArgumentException("허용값은 0원~ 10000원입니다");
        }
        if(requestDto.getDeliveryFee() %500 != 0){
            throw new IllegalArgumentException("500원단위로 입력해야 합니다");
        }
        restaurantRepository.save(restaurant);
        return restaurant;
    }
    //음식점 리스트
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }


}
