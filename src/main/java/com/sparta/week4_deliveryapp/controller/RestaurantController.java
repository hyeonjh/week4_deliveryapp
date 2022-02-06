package com.sparta.week4_deliveryapp.controller;


import com.sparta.week4_deliveryapp.dto.RestaurantRequestDto;
import com.sparta.week4_deliveryapp.model.Restaurant;
import com.sparta.week4_deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;





    // 음식점 등록 페이지
    @GetMapping("/restaurant/new")
    public String restaurant() {
        return "registerRestaurant";
    }


    // 음식점 등록 요청 처리
    @PostMapping("/restaurant/new")
    public String registerUser(RestaurantRequestDto requestDto) {
        restaurantService.registerRestaurant(requestDto);
        return "home";
    }

    //등록된 음식점 리스트
    @GetMapping("/restaurants")
    public String restaurantlist(Model model) {
        List<Restaurant> restaurants = restaurantService.findRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurantList";
    }




//    //음식점 등록
//    @GetMapping("/restaurants/new")
//    public String createForm(Model model) {
//
//        model.addAttribute("restaurantForm", new RestaurantForm());
//        return "restaurants/createRestaurantForm";
//    }
//
//    @PostMapping("/restaurants/new")
//    public String create(@Valid RestaurantForm form, BindingResult result) {
//
//        if(result.hasErrors()){
//            return "restaurants/createRestaurantForm";
//        }
//        Restaurant restaurant = new Restaurant();
//        restaurant.setName(form.getName());
//        restaurant.setMinOrderPrice(form.getMinOrderPrice());
//        restaurant.setDeliveryFee(form.getDeliveryFee());
//        restaurantService.join(restaurant);
//        return "redirect:/";
//    }
//



}
