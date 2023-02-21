package com.angular.spring.bookshop.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookshop")
public class Bookshop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "book_Name")
	private String bookName;
	
	@Column(name = "book_Author")
	private String bookAuthor;
	
	@Column(name = "book_Price")
	private int bookPrice;
	
	@Column(name = "book_Rating")
	private String bookRating;
	
	public Bookshop() {
		
	}
	
	public Bookshop(String bookName, String bookAuthor, int bookPrice, String bookRating) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookRating = bookRating;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookRating() {
		return bookRating;
	}
	public void setBookRating(String bookRating) {
		this.bookRating = bookRating;
	}
	
	

}
