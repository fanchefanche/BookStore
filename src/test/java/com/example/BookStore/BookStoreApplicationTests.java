package com.example.BookStore;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookStoreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		for(String item:list) {
			System.out.println(item);
		}
	}

}
