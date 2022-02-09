package com.sparta.week4_deliveryapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    @GeneratedValue
    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private Long totalPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Order(Restaurant restaurant, Long totalPrice) {
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
    }
}
