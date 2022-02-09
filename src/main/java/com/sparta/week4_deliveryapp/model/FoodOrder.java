//package com.sparta.week4_deliveryapp.model;
//
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.aspectj.weaver.ast.Or;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@Getter
//@Entity
//public class FoodOrder {
//
//    @GeneratedValue
//    @Id
//    @Column(name = "foodOrder_id")
//    private Long id;
//    @Column(nullable = false)
//    private String name;
//    @Column(nullable = false)
//    private Long price;
//    @Column(nullable = false)
//    private Long quantity;
//
//
//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "food_id", nullable = false)
//    private Food food;
//
//    private FoodOrder(String name, Long price, Long quantity, Order order, Food food) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.order = order;
//        this.food = food;
//    }
//
//
//}
