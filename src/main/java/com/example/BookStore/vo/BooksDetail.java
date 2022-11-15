package com.example.BookStore.vo;

import com.example.BookStore.entity.Books;

public class BooksDetail extends Books {

	private Integer number;

	public BooksDetail(Books books, Integer number) {
		super(books.getIsbn(), books.getAuthor(), books.getName(), books.getPrice(), books.getCategory());
		this.number = number;

	}

	public BooksDetail(Books books) {
		super(books.getIsbn(), books.getAuthor(), books.getName(), books.getPrice(), books.getCategory());
		// TODO Auto-generated constructor stub
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
