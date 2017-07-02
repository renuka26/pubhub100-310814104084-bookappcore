package com.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pubhub.model.Book;
import com.pubhub.model.User;
import com.pubhub.util.ConnectionUtil;

public class UserDAO {
	public void register(User user) throws Exception {
		Connection con = ConnectionUtil.getconnection();
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO `users123` (`name`,`email_id`,`password`) VALUES (?,?,?)");
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmail_id());
		pst.setString(3, user.getPassword());

		pst.executeUpdate();
	}

	public boolean login(User user) throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT NAME FROM `users123` WHERE `email_id`=? AND `password`=?");

		pst.setString(1, user.getEmail_id());
		pst.setString(2, user.getPassword());
		ResultSet rs = pst.executeQuery();
		boolean flag = false;
		if (rs.next()) {
			flag = true;
		}
		return flag;
	}

	public void editPrice(Book book) throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection.prepareStatement("UPDATE `books` SET `price`=? WHERE `name`=?");
		pst.setInt(1, book.getNewprice());
		pst.setString(2, book.getName());
		pst.executeUpdate();

	}

	public void removeBook(String bookname) throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection.prepareStatement("DELETE FROM `books` WHERE `NAME`=?");
		pst.setString(1, bookname);
		pst.executeUpdate();

	}

	public void saveBook(String bookname, int price) throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection.prepareStatement("INSERT INTO`books`(`NAME`,`price`) VALUES(?,?);");
		pst.setString(1, bookname);
		pst.setInt(2, price);
		pst.executeUpdate();

	}

	public List<Book> findByName(String bookname) throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection.prepareStatement("SELECT `NAME`,`price` FROM `books` WHERE `NAME`=?");
		pst.setString(1, bookname);
		ResultSet rs = pst.executeQuery();
		List<Book> booklist = new ArrayList();
		while (rs.next()) {
			Book book = new Book();
			book.setName(rs.getString(1));
			book.setPrice(rs.getInt(2));
			booklist.add(book);
		}
		return booklist;
	}
	
	public List<Book> findall() throws Exception {
		Connection connection = ConnectionUtil.getconnection();
		PreparedStatement pst = connection.prepareStatement("SELECT `NAME`,`price` FROM `books`");
		
		ResultSet rs = pst.executeQuery();
		List<Book> booklistall = new ArrayList();
		while (rs.next()) {
			Book book = new Book();
			book.setName(rs.getString(1));
			book.setPrice(rs.getInt(2));
			booklistall.add(book);
		}
		return booklistall;
	}

}
