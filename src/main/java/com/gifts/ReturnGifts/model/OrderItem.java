package com.gifts.ReturnGifts.model;

public class OrderItem {
    private int id;
    private int orderId;
    private int giftId;
    private String name;
    private double price;
    private int quantity;
    private String imageUrl;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getGiftId() { return giftId; }
    public void setGiftId(int giftId) { this.giftId = giftId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
