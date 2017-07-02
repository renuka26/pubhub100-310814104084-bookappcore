package com.pubhub.model;

public class Book {
	private String name;
	private int id;
	private int price;
	private int newprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNewprice() {
		return newprice;
	}
	public void setNewprice(int newprice) {
		this.newprice = newprice;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", price=" + price + ", newprice=" + newprice + "]";
	}
}