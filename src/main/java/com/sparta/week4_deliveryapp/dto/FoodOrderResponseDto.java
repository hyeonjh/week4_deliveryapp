package com.sparta.week4_deliveryapp.dto;


import com.sparta.week4_deliveryapp.model.FoodOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderResponseDto {

    private String name;
    private int quantity;
    private int price;

    public FoodOrderResponseDto (FoodOrder foodOrder){
        this.name = foodOrder.getFood().getName();
        this.quantity = foodOrder.getQuantity();
        this.price = foodOrder.getPrice();

    }

}
