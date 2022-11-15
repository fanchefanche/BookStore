package com.example.BookStore.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksReq {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("isbn")
	private String isbn;
	
	@JsonProperty("author")
	private String author;
	
	@JsonProperty("price")
	private int price;
	
	@JsonProperty("inventory")
	private int inventory;
	
	@JsonProperty("stock")
	private int stock;
	
	@JsonProperty("category")
	private String category;

	private String dealer;
	
	private  Map<String,Integer>map;
	
	public BooksReq() {

	}

	public BooksReq(String name, String isbn, String author, int price, int inventory, int stock, String category) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.inventory = inventory;
		this.stock = stock;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

}
