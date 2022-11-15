package com.example.BookStore.vo;

import java.util.List;
import java.util.Map;

import com.example.BookStore.entity.Books;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksRes {
	@JsonProperty("books")
	private Books books;
	@JsonProperty("message")
	private String message;

	private List<Books> bookList;
	
	private Map<String,Integer>map;
	
	private int total;
	
	private List<BooksDetail> booksDetails;
	public BooksRes() {
		
	}
	
	public BooksRes(String name, String ISBN,
			String author, int inventory, int stock, String category) {
			///////	
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	public List<Books> getBookList() {
		return bookList;
	}

	public void setBookList(List<Books> bookList) {
		this.bookList = bookList;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<BooksDetail> getBooksDetails() {
		return booksDetails;
	}

	public void setBooksDetails(List<BooksDetail> booksDetails) {
		this.booksDetails = booksDetails;
	}
	
}
