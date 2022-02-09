package com.sparta.week4_deliveryapp.controller;


import com.sparta.week4_deliveryapp.dto.OrderRequestDto;
import com.sparta.week4_deliveryapp.dto.OrderResponseDto;
import com.sparta.week4_deliveryapp.repository.OrderRepository;
import com.sparta.week4_deliveryapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;



    @GetMapping("/order/request")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {

        return orderService.createOrder(requestDto);
    }
//    @GetMapping("/orders")
//    public List<OrderResponseDto> OrderList(){
//
//    }


//        List<Order> all = orderRepository.findAll();
//        for (Order order : all) {
//            order.getRestaurant().getName(); //Lazy 강제 초기화
////            order.getDelivery().getAddress(); //Lazy 강제 초기환
//            List<FoodOrder> foodOrders = order.getFoodOrders();
//            foodOrders.stream().forEach(o -> o.getFood().getName()); //Lazy 강제 초기화
//        }
//        return all;




//    @PostMapping("/order/request")
//    public createOrder(@RequestBody OrderRequestDto requestDto){
//        return OrderService.createOrder(requestDto);
//    }
//
//
//    @GetMapping("/orders")
//    public List<OrderRequestDto> getOrderList(){
//        return orderService.getOrderList();
//    }

//    @GetMapping("/order/request")
//    public List<SimpleOrderDto> createOrder(@RequestBody OrderRequestDto requestDto) {
//
//        return orderService.createOrder(requestDto);
//
//
////
////        List<Order> orders = orderRepository.findAllWithMemberDelivery();
////        List<SimpleOrderDto> result = orders.stream()
////                .map(o -> new SimpleOrderDto(o))
//////                map은 a를 b로 바꿈 order-> orderdto로 바꿈
////                .collect(toList());
////        return result;
//    }













//    @GetMapping("/api/v5/orders")
//    public List<OrderQueryDto> ordersV5() {
//        return orderQueryRepository.findAllByDto_optimization();
//    }
//
//
//    public List<OrderRequestDto> ordersV4() {
//        return orderSimpleQueryRepository.findOrderDtos();
//    }


//    @Data
//    static class SimpleOrderDto {
//
//        private Long orderId;
//        private String name;
//        private
//
//        public SimpleOrderDto(Order order) {
//            orderId = order.getId();
//            name = order.getRestaurant().getName();
//        }
//    }



}
