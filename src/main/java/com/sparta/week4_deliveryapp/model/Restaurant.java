package com.sparta.week4_deliveryapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;

    public Restaurant(String name, Long minOrderPrice, Long deliveryFee){
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}