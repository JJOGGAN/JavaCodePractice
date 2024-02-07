package com.kh.example.practice6.model.vo;

public class Book {
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;

//	constructor
	public Book() {	
		this(" "," "," ",999,5.0);
	}

	public Book(String title, String publisher, String author) {
		this(title,publisher,author,888,3.3);
	}
	
	public Book(String title, String publisher, String author, int price, double discountRate) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}
	
//	method
	public void inform() {
		System.out.println("====Book Information====");
		System.out.println("title : "+title);
		System.out.println("publisher : "+publisher);
		System.out.println("author : "+author);
		System.out.println("price($) : "+price);
		System.out.println("discountRate(%) : "+discountRate);
	}
	
//	Getter Setter

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	

	
	
}
