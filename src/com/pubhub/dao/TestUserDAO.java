package com.pubhub.dao;

import com.pubhub.model.Book;
import com.pubhub.model.User;

public class TestUserDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();Book book=new Book();
		user.setActive(1);
		user.setPassword("uhgkjhgyu");
		user.setName("uegrgdsyjj");
		user.setEmail_id("uogghgyuio@gmail.com");
		System.out.println(user);
		UserDAO dao = new UserDAO();
		try {
			dao.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dao.login(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dao.editName("java8");
		try {
			dao.editPrice(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(dao.findall());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
