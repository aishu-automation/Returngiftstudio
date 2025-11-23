package com.gifts.ReturnGifts.model;

public class Gift {
	
	private int id;
    private String name;
    private double price;
    private int discount;
    private String imageUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Gift [id=" + id + ", name=" + name + ", price=" + price + ", discount=" + discount + ", imageUrl="
				+ imageUrl + "]";
	}
    
    

}
