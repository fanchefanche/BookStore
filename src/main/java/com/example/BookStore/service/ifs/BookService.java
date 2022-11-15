package com.example.BookStore.service.ifs;

import java.util.Map;

import com.example.BookStore.vo.BooksReq;
import com.example.BookStore.vo.BooksRes;

public interface BookService {
//寫在res為因為要回傳給postman
	public BooksRes addNewShit(BooksReq req);

	public BooksRes findByCat(String category);
	
	public BooksRes boughtShit(BooksReq req);

	public BooksRes top5Rank();
	
	public BooksRes priceUpdate(String isbn,int price);
	
	public BooksRes stockUpdate(String isbn,int stock);
	
	public BooksRes bookSerch(String dealer,String name,String isbn,String author);
	
	public BooksRes sellBooks(Map<String,Integer>buyMap);
}
