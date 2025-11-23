package com.gifts.ReturnGifts.model;

public class CartItem {
    private int id;
    private int giftId;
    private String name;
    private double price;
    private String imageUrl;
    private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", giftId=" + giftId + ", name=" + name + ", price=" + price + ", imageUrl="
				+ imageUrl + ", quantity=" + quantity + "]";
	}

    
}
