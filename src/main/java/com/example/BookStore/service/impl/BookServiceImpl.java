package com.example.BookStore.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.BookStore.entity.Books;
import com.example.BookStore.repostitory.BooksDao;
import com.example.BookStore.service.ifs.BookService;
import com.example.BookStore.vo.BooksDetail;
import com.example.BookStore.vo.BooksReq;
import com.example.BookStore.vo.BooksRes;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BooksDao booksDao;

	@Override /// 第一題 新增
	public BooksRes addNewShit(BooksReq req) {
		BooksRes res = new BooksRes();
		Books books = new Books(req);
		if (req.getPrice() <= 0) {
			res.setMessage("youAreSoPoor");
			return res;
		} else if (req.getInventory() <= 0) {
			res.setMessage("Don'tDoThat");
			return res;
		} else if (req.getStock() <= 0) {
			res.setMessage("Hey!WatchOut");
			return res;
		} else if (!StringUtils.hasText(req.getName())) {
			res.setMessage("WhatDoYouSay?");
			return res;
		} else if (!StringUtils.hasText(req.getIsbn())) {
			res.setMessage("SayAgain?");
			return res;
		} else if (!StringUtils.hasText(req.getAuthor())) {
			res.setMessage("你不知道我爸誰嗎！！");
			return res;
		} else if (!StringUtils.hasText(req.getCategory())) {
			res.setMessage("我才想問你分類是什麼呢！");
			return res;
		}
		if (booksDao.existsById(req.getIsbn())) {
			res.setMessage("一模一樣幹什麼拉....");
			return res;

		}
		res.setBooks(books);
		books = booksDao.save(books);
		return res;

	}

	@Override /// 第一題 修改
	public BooksRes boughtShit(BooksReq req) {
		Books books = new Books(req);
		books.setStock(req.getStock());
		books.setInventory(req.getInventory());
		return null;
	}

	@Override
	public BooksRes findByCat(String category) {
		// ↑回傳型態或樣子 ↑方法名稱 ↑String cat為外部請求
		BooksRes res = new BooksRes();
		Set<String> catSet = new HashSet<>();

		String[] catArray = category.split(",");
		// for(要掃描的collection的型態 變數名稱：要掃描的collection)
		// collection 陣列(index) set map list
		for (String item : catArray) {
			// 新增str容器 裝入str並用trim去頭尾空白
			String str = item.trim();
			// 加入str後加入catSet後去掉重複元素（set)
			catSet.add(str);
		}
//		List<Books> booksList = new ArrayList<>(); 
		for (String item : catSet) {
			List<Books> bookOp = booksDao.findAllByCategoryContaining(item);
			if (bookOp.isEmpty()) {
				return res;
			} // 同型態可互加ex;list尬list
			res.setBookList(bookOp);
		}
		return res;
	}

	@Override
	public BooksRes top5Rank() {
		BooksRes res = new BooksRes();
		List<Books> bookOp = booksDao.findTop5ByOrderByInventoryDesc();
		res.setBookList(bookOp);
		return res;
	}

	@Override
	public BooksRes priceUpdate(String isbn, int price) {
		BooksRes res = new BooksRes();
		if (!StringUtils.hasText(isbn)) {
			return res;
		} else if (price <= 0) {
			return res;
		}
		Optional<Books> bookOp = booksDao.findById(isbn);

		if (bookOp.isPresent()) {
			res.setMessage("更新價格為：" + price);
			Books books = bookOp.get();
			books.setPrice(price);
			res.setBooks(books);
			booksDao.save(books);
		} else {
			res.setMessage("此輸入不存在");

		}
		return res;
	}

	@Override
	public BooksRes stockUpdate(String isbn, int stock) {
		BooksRes res = new BooksRes();
		if (!StringUtils.hasText(isbn)) {
			return res;
		} else if (stock <= 0) {
			return res;
		}
		Optional<Books> bookOp = booksDao.findById(isbn);
		if (bookOp.isPresent()) {
			res.setMessage("更新庫存為：" + stock);
			Books books = bookOp.get();
			books.setStock(stock);
			res.setBooks(books);
			booksDao.save(books);
		} else {
			res.setMessage("此輸入有點打咩");
		}
		return res;
	}

	@Override
	public BooksRes bookSerch(String dealer, String name, String isbn, String author) {
		BooksRes res = new BooksRes();

		if (StringUtils.hasText(name)) {
			List<Books> booksOp = booksDao.findAllByName(name);
			res.setBookList(booksOp);
			return res;
		} else if (StringUtils.hasText(isbn)) {
			Optional<Books> booksOp = booksDao.findById(isbn);
			Books books = booksOp.get();
			res.setBooks(books);
			return res;
		} else if (StringUtils.hasText(author)) {
			List<Books> booksOp = booksDao.findAllByAuthor(author);
			res.setBookList(booksOp);
			return res;
		}
		return res;
	}

//==============================================================================
	public BooksRes bookSerch1(String dealer, String name, String isbn, String author) {
		BooksRes res = new BooksRes();
		List<Books> booksList = new ArrayList<>();
		if (StringUtils.hasText(name)) {
			List<Books> booksOp = booksDao.findAllByName(name);
			for (Books item : booksOp) {
				Books books = new Books();
				books.setName(item.getName());
				books.setAuthor(item.getAuthor());
				books.setPrice(item.getPrice());
				books.setInventory(null);// 設定為空 是因為不希望其顯示給消費者
				books.setStock(null);// 但前提是在entity裡有加上JsonInclude
				// null項目可不寫 此為加深印象之意義;
				books.setCategory(null);
				booksList.add(books);

			}
			res.setBookList(booksOp);
			return res;
		} else if (StringUtils.hasText(isbn)) {
			Optional<Books> booksOp = booksDao.findById(isbn);
			Books books = booksOp.get();
			books.setInventory(null);
			books.setStock(null);
			books.setCategory(null);
			res.setBooks(books);
			return res;
		} else if (StringUtils.hasText(author)) {

			List<Books> booksOp = booksDao.findAllByAuthor(author);
			for (Books item : booksOp) {
				Books books = new Books();// 建立空的書本
				books.setName(item.getName());// 將掃描到的指定項目寫入空書
				books.setIsbn(item.getIsbn());// 將掃描到的指定項目寫入空書
				books.setAuthor(item.getAuthor());// 將掃描到的指定項目寫入空書
				books.setPrice(item.getPrice());
				booksList.add(books);// 將掃描加入完成的書籍 放回書櫃*List<Books>
			}

			res.setBookList(booksOp);
			return res;
		}
		return res;
	}

	@Override
	public BooksRes sellBooks(Map<String, Integer> buyMap) {
		List<String> isbnList = new ArrayList<>();
		BooksRes res = new BooksRes();
		List<BooksDetail> booksDetails = new ArrayList<>();
		int total = 0;
		for (Entry<String, Integer> checkMap : buyMap.entrySet()) {
			isbnList.add(checkMap.getKey());
		}
		List<Books> booksOp = booksDao.findAllByIsbnIn(isbnList);
		for (Books item : booksOp) {
			String key = "";
			int value = 0;
			for (Entry<String, Integer> checkMap : buyMap.entrySet()) {
				key = checkMap.getKey();
				value = checkMap.getValue();
				if (key.equalsIgnoreCase(item.getIsbn())) {
					if (value < 0 || value > item.getStock()) {
						value = 0;
					}
					break;
				}
			}
			BooksDetail booksDetail = new BooksDetail(item, value);
			/// 在booksdetail裡（Books books,Integer number）然後在serimpl裡（item,直接賦予value）
			/// 此刻就指定item value
			booksDetails.add(booksDetail);
			total += value * item.getPrice();
			item.setInventory(item.getInventory() + value);
			item.setStock(item.getStock() - value);
			booksDao.save(item);
		}
		res.setTotal(total);
		res.setBooksDetails(booksDetails);
		return res;  
	}

}
