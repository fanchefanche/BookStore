package com.example.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.service.ifs.BookService;
import com.example.BookStore.vo.BooksReq;
import com.example.BookStore.vo.BooksRes;

@RestController
//@RestController
public class BooksController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/api/getNewShit")

	public BooksRes AddNewShit(@RequestBody BooksReq req) {
		
		return bookService.addNewShit(req);
		
	}

	@PostMapping(value = "/api/BoughtShit")
	public BooksRes BoughtShit(@RequestBody BooksReq req) {
		
		BooksRes res = new BooksRes();
	
		return res;
	}
	
	@PostMapping(value = "/api/findByCat")
	public BooksRes findByCat(@RequestBody BooksReq req) {
		
		return bookService.findByCat(req.getCategory());
	}
	@PostMapping(value = "/api/top5Rank")
	public BooksRes top5Rank() {
		
		return bookService.top5Rank();
	}
	@PostMapping(value = "/api/priceUpdate")
	public BooksRes priceUpdate(@RequestBody BooksReq req) {
		
		return bookService.priceUpdate(req.getIsbn(), req.getPrice());
		
	}
	@PostMapping(value = "/api/stockUpdate")
	public BooksRes stockUpdate(@RequestBody BooksReq req) {
		
		return bookService.stockUpdate(req.getIsbn(),req.getStock());
		
	}
	@PostMapping(value = "/api/bookSerch")
	public BooksRes BookSerch(@RequestBody BooksReq req) {
		
		return bookService.bookSerch(req.getDealer(),req.getName(), req.getIsbn(), req.getAuthor());
		
	}
	@PostMapping(value = "/api/sellBooks")
	public BooksRes sellBooks(@RequestBody BooksReq req) {
		///這裡的getMap是req的map（外部輸入）
		return bookService.sellBooks(req.getMap());
		
	
		
	}
}
