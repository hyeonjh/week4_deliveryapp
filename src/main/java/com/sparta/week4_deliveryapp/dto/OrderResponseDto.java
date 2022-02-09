package com.sparta.week4_deliveryapp.dto;


import com.sparta.week4_deliveryapp.model.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {

    private String restaurntName;
    private List<FoodOrderResponseDto> foodOrderResponseDtos;
    //response에 name과 quantity, price 정보를 리스트로 갖고있어야한다.
    //그래야 아래처럼나옴


    private Long deliveryFee;
    private int totalPrice;

//
    public OrderResponseDto (Orders order, List<FoodOrderResponseDto> foodOrderResponseDtos){
        this.restaurntName = order.getRestaurant().getName();
        this.foodOrderResponseDtos =foodOrderResponseDtos;
        this.deliveryFee = order.getRestaurant().getDeliveryFee();
        this.totalPrice = order.getTotalPrice();
    }

//    {
//        restaurantName: "쉐이크쉑 청담점",
//                foods: [
//        {
//            name: "쉑버거 더블",
//                    quantity: 1,
//                price: 10900
//        },
//        {
//            name: "치즈 감자튀김",
//                    quantity: 2,
//                price: 9800
//        },
//        {
//            name: "쉐이크",
//                    quantity: 3,
//                price: 17700
//        }
//  ],
//        deliveryFee: 2000,
//                totalPrice: 40400
//    }



}
