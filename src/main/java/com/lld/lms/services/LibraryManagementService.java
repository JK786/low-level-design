package com.lld.lms.services;

import java.util.Date;
import java.util.HashMap;

import com.lld.lms.constants.Constants;
import com.lld.lms.enums.BookItemStatus;
import com.lld.lms.enums.MemberAccountStatus;
import com.lld.lms.enums.MemberAccountType;
import com.lld.lms.interfaces.AdministrativeFunctions;
import com.lld.lms.interfaces.BookIssuingFunctions;
import com.lld.lms.models.BookIssueTransaction;
import com.lld.lms.models.BookItem;
import com.lld.lms.models.LibraryStorageSystem;
import com.lld.lms.models.Member;

public class LibraryManagementService implements AdministrativeFunctions, BookIssuingFunctions {

	LibraryStorageSystem libraryStore;

	public void initializeLibrary(HashMap<String, BookItem> books, HashMap<String, Member> members) {
		libraryStore = new LibraryStorageSystem();
		libraryStore.setIdAndBookMap(books);
		libraryStore.setIdAndMemberMap(members);
	}

	/** Admin **/

	public boolean addBook(String id, BookItem bookItem) {
		Member member = this.getMemberById(id);

		// Then you can add books
		if (member.getAccount().getAccountType() == MemberAccountType.ADMIN) {
			libraryStore.getIdAndBookMap().put(bookItem.getBookId(), bookItem);
			return true;
		} else {
			System.out.println("The member is not a librarian, cannot add book");
			return false;
		}

	}

	public boolean removeBooks(String id, BookItem bookItem) {
		Member member = this.getMemberById(id);

		// Then you can remove books
		if (member.getAccount().getAccountType() == MemberAccountType.ADMIN) {

			if (libraryStore.getIdAndBookMap().containsKey(bookItem.getBookId())) {
				libraryStore.getIdAndBookMap().remove(bookItem.getBookId());
				return true;
			} else {
				return false;
			}

		} else {
			System.out.println("The member is not a librarian, cannot add book");
			return false;
		}

	}

	public boolean blockMember(String memberId) {
		// Then you can remove books
		if (this.getMemberById(memberId).getAccount().getAccountType() == MemberAccountType.ADMIN) {

		} else {
			System.out.println("The member is not a librarian, cannot add book");
			return false;
		}

		return false;
	}

	public boolean unblockMember(String memberId) {
		return false;
	}

	public boolean issueBook(String memberId, BookItem bookItem) {
		Member member = this.getMemberById(memberId);

		if (member.getAccount().getStatus() == MemberAccountStatus.BLOCKED) {
			System.out.println("Member has been blocked. Can't issue books.");
		}

		if (member.getTotalNumberOfBooksIssued() == Constants.maxNumberOfBooksAllowerPerMember) {
			System.out.println("Can't issue more books, member already has  "
					+ Constants.maxNumberOfBooksAllowerPerMember + " books");
			return false;
		}

		BookItem bookItemFromStore = getBookItemById(bookItem.getBookId());
		if (bookItemFromStore.getStatus() == BookItemStatus.AVAILABLE) {

			// update book status as issued
			bookItemFromStore.setStatus(BookItemStatus.ISSUED);
			libraryStore.getIdAndBookMap().put(bookItemFromStore.getBookId(), bookItemFromStore);

			// update member book issue count
			member.totalNumberOfBooksIssued++;
			libraryStore.getIdAndMemberMap().put(member.getAccount().getId(), member);

			// create a transaction and update transaction
			BookIssueTransaction issueTransaction = new BookIssueTransaction();

			// TBD:set appropriate dates
			issueTransaction.setMember(member).setBookItem(bookItemFromStore).setTransactionDate(new Date())
					.setDueDate(new Date()).setDateOfIssue(new Date());
			libraryStore.getMemberIdBookTransactionMap().put(member.getAccount().getId(), issueTransaction);

			return true;
		}

		return false;
	}

	public boolean returnBook(String memberId, BookItem bookItem) {
		Member member = this.getMemberById(memberId);

		if (member.getAccount().getStatus() == MemberAccountStatus.BLOCKED) {
			System.out.println("Member has been blocked. Can't issue books.");
		}

		// check for fine , TBD

		BookItem bookItemFromStore = getBookItemById(bookItem.getBookId());
		if (bookItemFromStore.getStatus() == BookItemStatus.ISSUED) {

			// update book status as issued
			bookItemFromStore.setStatus(BookItemStatus.AVAILABLE);
			libraryStore.getIdAndBookMap().put(bookItemFromStore.getBookId(), bookItemFromStore);

			// update member book issue count
			member.totalNumberOfBooksIssued--;
			libraryStore.getIdAndMemberMap().put(member.getAccount().getId(), member);

			return true;
		}

		return false;

	}

	public BookItem getBookItemById(String bookId) {
		HashMap<String, BookItem> idAndBookItemMap = libraryStore.getIdAndBookMap();

		if (idAndBookItemMap.containsKey(bookId)) {
			return idAndBookItemMap.get(bookId);
		} else {
			return null;
		}
	}

	// ------ Utils
	public Member getMemberById(String memberId) {
		HashMap<String, Member> idAndMemberMap = libraryStore.getIdAndMemberMap();

		if (idAndMemberMap.containsKey(memberId))
			return idAndMemberMap.get(memberId);
		else
			return null;
	}

}
