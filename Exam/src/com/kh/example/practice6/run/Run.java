package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.inform();
		
		Book book2 = new Book("title", "publisher", "author");
		book2.inform();
		
		Book book3 = new Book("나는", "누구", "여긴 어디", 777, 0.5);
		book3.inform();
	}

}
