package com.lld.lms.models;

import java.util.HashMap;

public class LibraryStorageSystem {
	private HashMap<String, BookItem> idAndBookMap;
	private HashMap<String, Member> idAndMemberMap;

	// To get all transactions of a member
	private HashMap<String, BookIssueTransaction> memberIdBookTransactionMap;

	public HashMap<String, BookItem> getIdAndBookMap() {
		return idAndBookMap;
	}

	public void setIdAndBookMap(HashMap<String, BookItem> idAndBookMap) {
		this.idAndBookMap = idAndBookMap;
	}

	public HashMap<String, Member> getIdAndMemberMap() {
		return idAndMemberMap;
	}

	public void setIdAndMemberMap(HashMap<String, Member> idAndMemberMap) {
		this.idAndMemberMap = idAndMemberMap;
	}

	public HashMap<String, BookIssueTransaction> getMemberIdBookTransactionMap() {
		return memberIdBookTransactionMap;
	}

	public void setMemberIdBookTransactionMap(HashMap<String, BookIssueTransaction> memberIdBookTransactionMap) {
		this.memberIdBookTransactionMap = memberIdBookTransactionMap;
	}
	
	
}
