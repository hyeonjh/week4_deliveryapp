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




    //음식점 전체 조회
    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
    }

    public void registerRestaurant(RestaurantRequestDto requestDto) {
        String name = requestDto.getName();
        Long minOrderPrice = requestDto.getMinOrderPrice();
        Long deliverFee= requestDto.getDeliveryFee();
        Restaurant restaurant = new Restaurant(name,minOrderPrice,deliverFee);
        restaurantRepository.save(restaurant);
    }


}
