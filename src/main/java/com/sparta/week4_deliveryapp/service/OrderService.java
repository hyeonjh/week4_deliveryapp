package com.sparta.week4_deliveryapp.service;


import com.sparta.week4_deliveryapp.dto.*;
import com.sparta.week4_deliveryapp.model.Food;
import com.sparta.week4_deliveryapp.model.FoodOrder;
import com.sparta.week4_deliveryapp.model.Orders;
import com.sparta.week4_deliveryapp.model.Restaurant;
import com.sparta.week4_deliveryapp.repository.FoodOrderRepository;
import com.sparta.week4_deliveryapp.repository.FoodRepository;
import com.sparta.week4_deliveryapp.repository.OrderRepository;
import com.sparta.week4_deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;

//
//    {
//        restaurantName: "쉐이크쉑 청담점",
//                foods: [
//        {
//            name: "쉑버거 더블",
//                    quantity: 1,
//                price: 10900
//        }}


    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        //order리스트에 담아주려면
        //restaurantName이 필요하므로 restaurant을 불러온다.
        //dto에 Restaurant restaurant로 넣으면 Long타입으로 변환하라고나온다. 왜????
        //Id값으로 가져와야하는 이유가 뭘까 ... @pathvariad
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("음식점 id가 없다")
        );



        Long deliveryFee = restaurant.getDeliveryFee();
        int totalPrice = 0;
        Long total = totalPrice + deliveryFee;

//        주문생성 - createorder- - > orderRequestDto에 restaurantId로 OrderEntity를 구하고
//        푸드오더리퀘스트디티오로 아이디로 주문상세클래스 정보를 를 구할수잇다
        List<FoodOrderDto> foodOrderDtos =requestDto.getFoodOrderDtos(); //푸드정보를 불러온다.

        // food정보를 담는다 .

        List<FoodOrder> foodOrders = new ArrayList<>(); //푸드 오더 정보를 담는다.
        for(FoodOrderDto foodOrderDto : foodOrderDtos){
            Long Id = foodOrderDto.getId();
            int quantity = foodOrderDto.getQuantity();

            Food food = foodRepository.findById(Id).orElseThrow(()->new NullPointerException("음식이 존재하지 안습니다."));
            int foodPrice = food.getPrice() * quantity;



            FoodOrder foodOrder =new FoodOrder(foodPrice,foodOrderDto.getQuantity(),food) ;
            foodOrders.add(foodOrder);

        }
 // 여기까지 푸드정보를 담아왔나?


//오더에 restaurant id값과 total값을 넣고
        Orders orders = new Orders(restaurant,totalPrice);
        orderRepository.save(orders);

        List<FoodOrderResponseDto> foods = new ArrayList<>();

        //
        for (FoodOrder foodOrder : foodOrders){

            FoodOrder foodOrders1 =new FoodOrder(foodOrder.getQuantity(),foodOrder.getPrice(),foodOrder.getOrders(),foodOrder.getFood());

            FoodOrderResponseDto foodOrderResponseDto = new FoodOrderResponseDto(foodOrders1);
            foods.add(foodOrderResponseDto);
        }

            return foods;


//        크레이트 오더로 반환하는게 오더 리스폰스디티오
//

//            db에넣어야하는데 food정보들이 list로 담겨잇으니까 for문을써야한다.
//        foodOrder정보를 저장하기전에






//
//
//        //response에 담길거 는 ?
////        orderResponse dto 생성자로 name,fee
//        String restaurntName = restaurant.getName();
//        Long deliveryFee = restaurant.getDeliveryFee();
//        int totalPrice = 0;
//        Long total = totalPrice + deliveryFee;
//        List<FoodOrderResponseDto> foodOrderResponseDtos;
//        //for문으로 담기 - FoodOrder 정보를  name quantity price를 담아서 Response로 보내야해
//        //그러면 리쿼스트에서 값을 주워와서 넣어야한다 - 어디에?  리스폰스에
//
//        //FoodOrderDto에 id랑 퀀티티 값을 foodOrderDtoList 라 하고 리스트를 만들어준다음에 그걸
//        // reqeustDto에 foodOrderDtos 값으로 들어간다
//        List<Integer> foodOrderList = new ArrayList<>();
//        List<FoodOrderDto> foodOrderDtoList = requestDto.getFoodOrderDtos();
//        //그러면 foodOrderDto의 id랑 퀀티티 값이 foodOrderDtoList로 들어간다. 그게 결국 OrderRequest로전달된다?
//        for (FoodOrderDto foodOrderDto : foodOrderDtoList){
//            //foodOrderDtoList에 담기는 값이  id랑 퀀티티리스트
////        foodOrderDto에서 id값으로  food 엔티티 정보 가져오기 - price
//            Long id = foodOrderDto.getId();
//            Food food = foodRepository.findById(id).orElseThrow(
//                    ()-> new NullPointerException("아이디가 없습니다. ")
//            );
//            int quantity = foodOrderDto.getQuantity();
//            int price= food.getPrice();
//            int foodTotal = quantity * price;
//
//            foodOrderList.add(quantity,price);
//        }
//        return null;





        //OrderRequestDto에는  List<FoodOrderDto> foodOrderDtos 가 들어가 있고
        //FoodOrderDto 에는 요청받은 정보들을 넣어줘야하는데 id와 quantity값이 들어가있다 .
        // FoodOrderDto를 리스트 형태로 id와 quantity를 담아야하고,
        // 담은 리스트를 requestdto로 불러와야한다?


        // 1. FoodOrderDto에 id와 quantity 데이터를 요청한다.
        // 2. FoodOrderDto에 id와 quantity를 묶어서 리스트로 만든다.
        // 3. 요청이 들어오면 OrderRequesDto에
        // Long 형태의 restaurantId와 List<FoodOrderDto>에 있는 foodOrderDtos로 데이터를 요청해줘야한다.
        // 4. 그럼 2번에서 만든 리스트가 OrderRequestDto로 요청해준다.


        //그러면 FoodOrderDto로 id와 quantity값을 전송받아서 ->

        //OrderRequestDto에 있는 FoodOrderDtos를 불러와서 리스트에 담아야한다.



    }

}
