package com.sparta.week4_deliveryapp.model;

import com.sparta.week4_deliveryapp.dto.FoodRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity로 바꾸면 각각올라감
    @Column(name = "food_id")
    private Long id;

    @Column(nullable = false)
    private String foodName;
    @Column(nullable = false)
    private Long foodPrice;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurant_id",nullable = false)
    private Restaurant restaurant;




    public Food (String foodName,Long foodPrice,Restaurant restaurant){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.restaurant = restaurant;

    }


//    public Food(String foodName, Long foodPrice, Long restaurantId) {
//        this.foodName =getFoodName();
//        this.foodPrice=getFoodPrice();
//        this.restaurant = getRestaurant();
//    }
//
//    public Food(FoodRequestDto requestDto) {
//        this.id = requestDto.getRestaurantId();
//        this.foodName = requestDto.getFoodName();
//        this.foodPrice = requestDto.getFoodPrice();
//
//    }


}
