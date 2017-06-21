package com.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.dao.UserDAO;
import com.infotech.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	public void createUser(User user) {
		userDAO.addUser(user);
	}
}
