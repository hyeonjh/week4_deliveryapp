package com.sparta.week4_deliveryapp.dto;

import com.sparta.week4_deliveryapp.model.FoodOrder;
import com.sparta.week4_deliveryapp.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {

    private Long restaurantId; // 오더엔티티안에 있는 레스토랑이랑 토탈프라이스를 구할수잇다.
    private List<FoodOrderDto> foodOrderDtos; // 각푸드정보를 구할수
    //foodOrderDto에 id값과 quantitiy값이 들어있어야한다.
    //그래야 아래처럼 나올수있찌?

//1.주문엔티티가 저장되고 , 주문엔티티 의 아이디가 상세에 들어가야한다.
//
//    목표 이정보로 엔티티에 담아야한다.  요청한그릇 - > db에 담아야한다...






//
//    {
//        restaurantId: 1
//        foods: [
//        { id: 1, quantity: 1 },
//        { id: 2, quantity: 2 },
//        { id: 3, quantity: 3 }
//  ]
//    }

}
