package com.lld.lms.models;

import com.lld.lms.enums.MemberAccountType;

public class Member {

	public static Integer memberId = 0;
	private MemberAccount account;
	public Integer totalNumberOfBooksIssued;

	public Member(Person person, String id, String password, MemberAccountType accType) {
		account = new MemberAccount(person, memberId++, "", accType);
		totalNumberOfBooksIssued = 0;
	}

	public Integer getTotalNumberOfBooksIssued() {
		return totalNumberOfBooksIssued;
	}

	public void setTotalNumberOfBooksIssued(Integer totalNumberOfBooksIssued) {
		this.totalNumberOfBooksIssued = totalNumberOfBooksIssued;
	}

	public MemberAccount getAccount() {
		return account;
	}

}
