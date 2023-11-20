package com.example.demo.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private String host;
	private String user;
	private String password;
	private String database;
	private int port;
	
	public BookDao() {
		this.host = "localhost";
		this.user = "hmuser";
		this.password = "1234";
		this.database = "xe";
		this.port = 1521;
	}
	
	Connection myConnection() {
		Connection conn = null;
		try {
			String connStr ="jdbc:oracle:thin:@" +host + ":" +port+ ":" +database;
			conn= DriverManager.getConnection(connStr, user, password);				
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return conn;
	}

public Book getBook(int bookId) {
	Connection conn = myConnection();
	String sql = "select * from book where bookId=?";
	Book book = null;
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			bookId = rs.getInt(1);
			String bookname = rs.getString(2);
			String publisher = rs.getString(3);
			int price = rs.getInt(4);
			book = new Book(bookId,bookname,publisher, price);
		}
		rs.close(); pstmt.close();conn.close();
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	return book;
}

public List<Book> getBookList() {
	Connection conn = myConnection();
	String sql = "select * from Book";
	List<Book> list = new ArrayList<>();
	
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int bookId = rs.getInt(1);
			String bookname = rs.getString(2);
			String publisher = rs.getString(3);
			int price = rs.getInt(4);
			Book b = new Book(bookId, bookname, publisher, price);
			list.add(b);
		}
		stmt.close(); rs.close(); conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}

public List<Book> getBookListByPublisher(String publisher) {
	Connection conn = myConnection();
	String sql = "select * from book where publisher like ?";
	List<Book> list = new ArrayList<>();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + publisher + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book b = new Book(rs.getInt(1), rs.getString(2), 
									  rs.getString(3), rs.getInt(4));
			list.add(b);
		}
		rs.close(); pstmt.close(); conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public List<Book> getBookListByFieldAndQuery(String field, String query) {
	Connection conn = myConnection();
	String sql = "select * from book where " + field + " like ?";
	List<Book> list = new ArrayList<>();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + query + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book b = new Book(rs.getInt(1), rs.getString(2), 
									  rs.getString(3), rs.getInt(4));
			list.add(b);
		}
		rs.close(); pstmt.close(); conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public void insertCustomer(Book b) {
	Connection conn = myConnection();
	String sql = "insert into book values (?, ?, ?, ?)";
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, b.getBookid());
		pstmt.setString(2, b.getBookname());
		pstmt.setString(3, b.getPublisher());
		pstmt.setInt(4, b.getPrice());
		pstmt.executeUpdate();
		
		pstmt.close(); conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void updateCustomer(Book b) {
	Connection conn = myConnection();
	String sql = "update book set bookname=?, publisher=?, price=? where bookid=?";
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, b.getBookname());
		pstmt.setString(2, b.getPublisher());
		pstmt.setInt(3, b.getPrice());
		pstmt.setInt(4, b.getBookid());
		pstmt.executeUpdate();
		
		pstmt.close(); conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void deleteBook(int bookId) {
	Connection conn = myConnection();
	String sql = "delete from book where bookid=?";
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		pstmt.executeUpdate();
		
		pstmt.close(); conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
}