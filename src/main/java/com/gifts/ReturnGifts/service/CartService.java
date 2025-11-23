package com.gifts.ReturnGifts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gifts.ReturnGifts.mapper.CartMapper;
import com.gifts.ReturnGifts.mapper.GiftMapper;
import com.gifts.ReturnGifts.model.CartItem;
import com.gifts.ReturnGifts.model.Gift;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GiftMapper giftMapper;

    public void addToCart(int giftId, int quantity) {
        CartItem existing = cartMapper.findByGiftId(giftId);
        Gift gift = giftMapper.getGiftById(giftId);

        if (existing != null) {
            int newQty = existing.getQuantity() + quantity;
            cartMapper.updateQuantity(existing.getId(), newQty);
            return;
        }

        cartMapper.addToCart(giftId, gift.getName(), gift.getPrice(),
                             "http://localhost:8083" + gift.getImageUrl(), quantity);
    }

    public List<CartItem> getCartItems() {
        return cartMapper.getCartItems();
    }

    public void updateQuantity(int cartItemId, int quantity) {
        cartMapper.updateQuantity(cartItemId, quantity);
    }

    public void removeItem(int cartItemId) {
        cartMapper.removeItem(cartItemId);
    }

    public void clearCart() {
        cartMapper.clearCart();
    }
}
