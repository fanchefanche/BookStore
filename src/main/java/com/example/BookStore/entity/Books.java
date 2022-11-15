package com.example.BookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.BookStore.vo.BooksReq;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "books")
public class Books {
	
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "isbn")
	private String isbn;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private Integer price;

	@Column(name = "inventory")
	private Integer inventory;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "category")
	private String category;
	
	
	
	public Books() {

	}

	public Books(BooksReq req) {

		this.name = req.getName();
		this.isbn = req.getIsbn();
		this.author = req.getAuthor();
		this.price = req.getPrice();
		this.inventory = req.getInventory();
		this.stock = req.getStock();
		this.category = req.getCategory();
		
	}

	public Books(String name, String isbn, String author, Integer price, Integer inventory, Integer stock,
			String category) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.inventory = inventory;
		this.stock = stock;
		this.category = category;
	}

	public Books(String name, String isbn, String author, Integer price, String category) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
}