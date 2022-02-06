package com.sparta.week4_deliveryapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    @Column(name = "food_id")
    private Long id;

    @Column(nullable = false)
    private String foodName;
    @Column(nullable = false)
    private Long foodPrice;

    public Food (String foodName,Long foodPrice){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }




}
