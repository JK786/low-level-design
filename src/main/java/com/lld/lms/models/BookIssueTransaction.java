package com.lld.lms.models;

import java.util.Date;

/**
 * TBD:Builder pattern can be used instead of constructor
 * 
 * @author jibrankhan
 *
 */
public class BookIssueTransaction {
	private Date transactionDate;
	private Date dateOfIssue;
	private Date dueDate;
	private Member member;
	private BookItem bookItem;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Member getMember() {
		return member;
	}

	public BookItem getBookItem() {
		return bookItem;
	}

	public BookIssueTransaction setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
		return this;
	}

	public BookIssueTransaction setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
		return this;
	}

	public BookIssueTransaction setDueDate(Date dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	public BookIssueTransaction setMember(Member member) {
		this.member = member;
		return this;
	}

	public BookIssueTransaction setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
		return this;
	}

}
