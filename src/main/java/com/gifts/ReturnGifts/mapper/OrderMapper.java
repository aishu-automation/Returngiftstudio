package com.gifts.ReturnGifts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.gifts.ReturnGifts.model.Order;
import com.gifts.ReturnGifts.model.OrderItem;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO orders(name, email, phone, address, pincode, state, total_amount) " +
            "VALUES(#{name}, #{email}, #{phone}, #{address}, #{pincode}, #{state}, #{totalAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createOrder(Order order);

    @Insert("INSERT INTO order_items(order_id, gift_id, name, price, quantity, image_url) " +
            "VALUES(#{orderId}, #{giftId}, #{name}, #{price}, #{quantity}, #{imageUrl})")
    void addOrderItem(OrderItem item);

    @Select("SELECT * FROM orders WHERE id = #{id}")
    Order getOrderById(int id);

    @Select("SELECT * FROM order_items WHERE order_id = #{orderId}")
    List<OrderItem> getOrderItems(int orderId);
}
