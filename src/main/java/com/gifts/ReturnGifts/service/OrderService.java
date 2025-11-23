package com.gifts.ReturnGifts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gifts.ReturnGifts.mapper.OrderMapper;
import com.gifts.ReturnGifts.model.Order;
import com.gifts.ReturnGifts.model.OrderItem;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private JavaMailSender mailSender;

    // Create order, save items, calculate total, and send confirmation email
    public Order createOrder(Order order) {
        // Calculate total amount from order items
        double total = order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        order.setTotalAmount(total);

        // Save order
        orderMapper.createOrder(order);

        // Save order items
        for (OrderItem item : order.getItems()) {
            item.setOrderId(order.getId());
            orderMapper.addOrderItem(item);
        }

        // Send confirmation email safely
        try {
            sendOrderConfirmation(order);
        } catch (Exception e) {
            System.err.println("Failed to send order confirmation email: " + e.getMessage());
            // Optionally log the error
        }

        return order;
    }

    // Fetch order with items
    public Order getOrder(int orderId) {
        Order order = orderMapper.getOrderById(orderId);
        List<OrderItem> items = orderMapper.getOrderItems(orderId);
        order.setItems(items);
        return order;
    }

    // Send confirmation email to user
    public void sendOrderConfirmation(Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(order.getEmail()); // send to user email
        message.setFrom("aptoursandtravelsblr@gmail.com");
        message.setSubject("Order Confirmation - ReturnGifts");

        StringBuilder sb = new StringBuilder();
        sb.append("Hi ").append(order.getName()).append(",\n\n");
        sb.append("Thank you for your order! Here are your order details:\n\n");

        for (OrderItem item : order.getItems()) {
            sb.append(item.getName())
              .append(" - Quantity: ").append(item.getQuantity())
              .append(" - Price: ₹").append(item.getPrice())
              .append(" - Total: ₹").append(item.getPrice() * item.getQuantity())
              .append("\n");
        }

        sb.append("\nTotal Amount: ₹").append(order.getTotalAmount()).append("\n");
        sb.append("\nShipping Address: ").append(order.getAddress())
          .append(", ").append(order.getState())
          .append(", ").append(order.getPincode()).append("\n\n");

        sb.append("We will notify you once your order is shipped.\n\n");
        sb.append("ReturnGifts Team");

        message.setText(sb.toString());

        mailSender.send(message);
    }
}
