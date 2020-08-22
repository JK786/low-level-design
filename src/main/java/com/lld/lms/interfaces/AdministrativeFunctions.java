package com.lld.lms.interfaces;

import java.util.List;

import com.lld.lms.models.Book;
import com.lld.lms.models.Member;

public interface AdministrativeFunctions {
	boolean addBook(String id, Book book);

	boolean removeBook(String id, Book books);

	boolean blockMember(String member);

	boolean unblockMember(String member);
}
