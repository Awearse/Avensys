package com.example.SpringBoot2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBoot2.repo.BookRepo;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	private long isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="authors")
	private String authors;
	
	@Column(name="year")
	private long year;
	
	@Column(name="price")
	private double price;
	
	public Book() {
		super();
	}
	
	public Book(long isbn, String title, String authors, long year, long price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.price = price;
	}
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

