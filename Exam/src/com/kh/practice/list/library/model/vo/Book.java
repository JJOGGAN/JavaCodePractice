package com.kh.practice.list.library.model.vo;

public class Book {
	private String title;
	private String author;
	private String category;
	private int price;

	public Book() {
		super();
	}

	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}
	public int hashCode() {
		//TODO result?
		int result = 0;
		return result;
	}
	public boolean equals() {
		//TODO result? 같은거 확인하라면서 왜 파라미터 없음???
		boolean result = false;
		return result;
	}
	public int compareTo() {
		//TODO result?
		int result = 0;
		return result;
	}
}
