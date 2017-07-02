package com.pubhub.dao;

import com.pubhub.model.Book;
import com.pubhub.model.User;

public class TestUserDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();Book book=new Book();
		user.setActive(1);
		user.setPassword("uhgyu");
		user.setName("uegrgj");
		user.setEmail_id("uoggh@gmail.com");
		System.out.println(user);
		UserDAO dao = new UserDAO();
		dao.register(user);
		dao.login(user);
		//dao.editName("java8");
		dao.editPrice(book);
		System.out.println(dao.findall());
	}

}
