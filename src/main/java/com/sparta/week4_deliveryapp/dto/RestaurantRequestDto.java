package com.sparta.week4_deliveryapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDto {
    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;

}
