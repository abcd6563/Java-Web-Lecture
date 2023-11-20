package com.example.demo.oracle;

import java.util.List;

public class BookMain {

	public static void main(String[] args) {
		
		BookDao bDao = new BookDao();
//		
//		Book b1 = bDao.getBook(6);
//		System.out.println(b1);
		
//		List<Book> list = bDao.getBookList();
//		for (Book b2 : list)
//		
//		System.out.println(b2);
		
//		bDao.insertCustomer(Book b)
//		Book b3 = new Book(3, "백설공주", "대한출판사", 16000);
//		bDao.insertCustomer(b3);
		
//		bDao.updateCustomer(Book b);
//		Book b4 = bDao.getBook(14);
//		b4.setBookname("백설공주"); b4.setPublisher("대한항공");
//		b4.setPrice(20000); 
//		bDao.updateCustomer(b4);
		
		
//		bDao.deleteBook(int bookId)
		bDao.deleteBook(14);
		
//		List<Book> list = bDao.getBookListByPublisher("대한출판사");
//		for(Book b2 : list)
//		System.out.println(b2);
		
		List<Book> list = bDao.getBookListByFieldAndQuery("publisher", "대한출판사");
		for(Book b2 : list)
		System.out.println(b2);
	}
	
	
		
		
	
	
}
