package com.gifts.ReturnGifts.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gifts.ReturnGifts.model.Order;
import com.gifts.ReturnGifts.model.OrderItem;
import com.gifts.ReturnGifts.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = {"http://localhost:3000", "http://10.10.10.126:3000"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody Map<String, Object> payload) {

        Map<String, Object> userMap = (Map<String, Object>) payload.get("user");
        List<Map<String, Object>> cartItemsMap =
                (List<Map<String, Object>>) payload.get("cartItems");

        Order order = new Order();
        order.setName((String) userMap.get("name"));
        order.setEmail((String) userMap.get("email"));
        order.setPhone((String) userMap.get("phone"));
        order.setAddress((String) userMap.get("address"));
        order.setPincode((String) userMap.get("pincode"));
        order.setState((String) userMap.get("state"));

        List<OrderItem> items = cartItemsMap.stream().map(itemMap -> {
            OrderItem item = new OrderItem();

            // IMPORTANT FIX
            item.setGiftId((Integer) itemMap.get("id"));

            item.setName((String) itemMap.get("name"));
            item.setPrice(Double.valueOf(itemMap.get("price").toString()));
            item.setQuantity((Integer) itemMap.get("quantity"));
            item.setImageUrl((String) itemMap.get("imageUrl"));
            return item;
        }).collect(Collectors.toList());

        order.setItems(items);

        return orderService.createOrder(order);
    }

}
