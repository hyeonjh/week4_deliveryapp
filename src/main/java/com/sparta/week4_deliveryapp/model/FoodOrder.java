package com.sparta.week4_deliveryapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class FoodOrder {

    @GeneratedValue
    @Id
    @Column(name = "food_order_id")
    private Long id;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;


    public FoodOrder(int price, int quantity, Food food) {
        this.price = price;
        this.quantity = quantity;
        this.food = food;
    }

    public FoodOrder1(int price, int quantity,Orders orders, Food food) {
        this.quantity = quantity;
        this.price=price;
        this.food = food;
        this.orders=orders;
    }

    public FoodOrder(int quantity, int price, Orders orders, Food food) {
        this.quantity = quantity;
        this.price=price;
        this.food = food;
        this.orders=orders;
    }


//  생성메서드
//    public static FoodOrder createFoodOrder(String name,int quantity,int price){
//        FoodOrder foodOrder = new FoodOrder();
//        foodOrder.setName(name);
//        foodOrder.setPrice(price);
//        foodOrder.setQuantity(quantity);
//        return foodOrder;
//    }



    public int getTotalPrice() {
        return getPrice() * getQuantity();
    }
}
