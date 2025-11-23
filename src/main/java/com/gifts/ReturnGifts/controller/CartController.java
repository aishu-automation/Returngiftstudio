package com.gifts.ReturnGifts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gifts.ReturnGifts.model.CartItem;
import com.gifts.ReturnGifts.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = {"http://localhost:3000", "http://10.10.10.126:3000"})
public class CartController {
	
	@Autowired
    private CartService cartService;

    @PostMapping("/add/{giftId}")
    public String addToCart(@PathVariable int giftId,
                            @RequestParam(defaultValue = "1") int quantity) {
        cartService.addToCart(giftId, quantity);
        return "Added to cart";
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCartItems();
    }

    @PutMapping("/update/{cartItemId}")
    public String updateQuantity(@PathVariable int cartItemId,
                                 @RequestParam int quantity) {
        cartService.updateQuantity(cartItemId, quantity);
        return "Quantity updated";
    }

    @DeleteMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable int cartItemId) {
        cartService.removeItem(cartItemId);
        return "Item removed";
    }

    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared";
    }
}
