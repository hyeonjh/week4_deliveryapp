package com.sparta.week4_deliveryapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Orders {

    @GeneratedValue
    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders = new ArrayList<>();




    //생성자 만들기
    public Orders(Restaurant restaurant, int totalPrice) {
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
    }


//    public void setRestaurant(Restaurant restaurant){
//        this.restaurant = restaurant;
//        restaurant.getOrders().add(this);
//    }

//    public void addFoodOrder(FoodOrder foodOrder){
//        foodOrders.add(foodOrder);
//        foodOrder.setOrder(this);
//    }

//
//    public Order(Long totalPrice,FoodOrder foodOrder ){
//        this.foodOrders = foodOrder;
//        this.totalPrice = totalPrice;
//    }



//
////생성메서드
//    public static Order createOrder(Restaurant restaurant, Long totalPrice, FoodOrder... foodOrders) {
//        Order order = new Order();
////        order.setRestaurant(restaurant);
//        order.setTotalPrice(totalPrice);
//        for(FoodOrder foodOrder: foodOrders){
//            order.addFoodOrder(foodOrder);
//        }
//        return order;
//    }
    public int getTotalPrice(){
        int totalPrice = 0;
        for (FoodOrder foodOrder : foodOrders){
            totalPrice += foodOrder.getTotalPrice();
        }
        return totalPrice;
    }


}
