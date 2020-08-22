package com.lld.lms.models;

import com.lld.lms.pureEntities.Author;

public class Book {
	String ISBN;
	String name;
	Author author;
	String publishedDate;

	public Book(String iSBN, String name, Author author, String publishedDate) {
		ISBN = iSBN;
		this.name = name;
		this.author = author;
		this.publishedDate = publishedDate;
	}

}
