package com.lld.lms.models;

import com.lld.lms.enums.MemberAccountStatus;
import com.lld.lms.enums.MemberAccountType;

public class MemberAccount {

	private Person person;
	private String id;
	private String password;

	/**
	 * creating field to check account type but this will be a part of rbac
	 * where some other authorization layer decides wether user can take this
	 * action or no
	 */
	private MemberAccountType accountType;
	private MemberAccountStatus status;

	public MemberAccount(Person person, String id, String password, MemberAccountType accountType) {
		this.person = person;
		this.id = id;
		this.password = password;
		this.accountType = accountType;
		this.status = MemberAccountStatus.ACTIVE;
	}

	public Person getPerson() {
		return person;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public MemberAccountType getAccountType() {
		return accountType;
	}

	public MemberAccountStatus getStatus() {
		return status;
	}

}
