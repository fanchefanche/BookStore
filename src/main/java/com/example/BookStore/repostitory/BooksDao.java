package com.example.BookStore.repostitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.Books;

///當我們所想之操作資料庫的方法為非原廠設定時 例如：findById findAll   就來DAO客製化方法 
@Repository
public interface BooksDao extends JpaRepository<Books, String> {
	// ↓回傳型態 //↓目的是尋找在資料庫中 包含指定名稱種類的項目
	public List<Books> findAllByCategoryContaining(String category);

	// ↑list因需回傳多筆”完整個體“項目 //↑只有這個東西會進database ↑外部請求（post man之類的）
	public List<Books> findTop5ByOrderByInventoryDesc();

	public List<Books> findAllByName(String name);

	public List<Books> findAllByAuthor(String author);
	
	public List<Books> findAllByIsbnIn(List<String> isbnList);
}
