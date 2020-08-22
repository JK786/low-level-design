package com.lld.lms.models;

import com.lld.lms.enums.BookItemStatus;
import com.lld.lms.pureEntities.Author;

public class BookItem extends Book {
	private String bookId;
	BookItemStatus status;

	public BookItem(String ISBN, String name, Author author, String publishedDate, String bookId, String status) {
		super(ISBN, name, author, publishedDate);
		this.bookId = bookId;
		this.status = BookItemStatus.AVAILABLE;
		// TODO Auto-generated constructor stub
	}

	public String getBookId() {
		return bookId;
	}

	public BookItemStatus getStatus() {
		return status;
	}

	public void setStatus(BookItemStatus status) {
		this.status = status;
	}
}
