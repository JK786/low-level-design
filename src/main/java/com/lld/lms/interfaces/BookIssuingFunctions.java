package com.lld.lms.interfaces;

import com.lld.lms.models.Book;

public interface BookIssuingFunctions {

	public void issueBook(Book book);

	public void returnBook(Book book);
}
