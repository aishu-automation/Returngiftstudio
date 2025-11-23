package com.gifts.ReturnGifts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gifts.ReturnGifts.model.CartItem;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO cart(giftId, name, price, imageUrl, quantity) " +
            "VALUES(#{giftId}, #{name}, #{price}, #{imageUrl}, #{quantity})")
    void addToCart(@Param("giftId") int giftId,
                   @Param("name") String name,
                   @Param("price") double price,
                   @Param("imageUrl") String imageUrl,
                   @Param("quantity") int quantity);

    @Select("SELECT * FROM cart")
    List<CartItem> getCartItems();

    @Delete("DELETE FROM cart")
    void clearCart();

    // Remove single item by cart id
    @Delete("DELETE FROM cart WHERE id = #{cartItemId}")
    void removeItem(@Param("cartItemId") int cartItemId);

    // Update quantity
    @Update("UPDATE cart SET quantity = #{quantity} WHERE id = #{cartItemId}")
    void updateQuantity(@Param("cartItemId") int cartItemId, @Param("quantity") int quantity);

    // Optional: find by giftId
    @Select("SELECT * FROM cart WHERE giftId = #{giftId}")
    CartItem findByGiftId(@Param("giftId") int giftId);
}
