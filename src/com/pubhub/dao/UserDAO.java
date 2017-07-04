package com.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pubhub.model.Book;
import com.pubhub.model.User;
import com.pubhub.util.ConnectionUtil;

public class UserDAO {
	public void register(User user) {
		Connection con = null;
		try {
			con = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = con
					.prepareStatement("INSERT INTO `users123` (`name`,`email_id`,`password`) VALUES (?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail_id());
			pst.setString(3, user.getPassword());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public boolean login(User user)  {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection
					.prepareStatement("SELECT NAME FROM `users123` WHERE `email_id`=? AND `password`=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pst.setString(1, user.getEmail_id());
			pst.setString(2, user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = false;
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public void editPrice(Book book)  {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("UPDATE `books` SET `price`=? WHERE `name`=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			pst.setInt(1, book.getNewprice());
			pst.setString(2, book.getName());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void removeBook(String bookname)  {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("DELETE FROM `books` WHERE `NAME`=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, bookname);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void saveBook(String bookname, int price)  {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("INSERT INTO`books`(`NAME`,`price`) VALUES(?,?);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, bookname);
			pst.setInt(2, price);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Book> findByName(String bookname) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("SELECT `NAME`,`price` FROM `books` WHERE `NAME`=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, bookname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Book> booklist = new ArrayList();
		try {
			while (rs.next()) {
				Book book = new Book();
			
					book.setName(rs.getString(1));
					book.setPrice(rs.getInt(2));
				
				
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public List<Book> findall()  {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("SELECT `NAME`,`price` FROM `books`");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Book> booklistall = new ArrayList();
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setName(rs.getString(1));
				book.setPrice(rs.getInt(2));
				booklistall.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklistall;
	}

}
