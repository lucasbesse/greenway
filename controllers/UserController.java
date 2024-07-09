package controllers;

import java.util.List;

import dao.UserDAO;
import models.User;

public class UserController {
	private UserDAO userDAO;
	
	public UserController() { 
		userDAO = new UserDAO();
	}
	
	public boolean registerUser(String name, String password) {
		return this.userDAO.createUser(name, password);
	}
	
	public User authenticate(String name, String password) {
		return this.userDAO.authenticate(name, password);
	}
	
	public List<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}
	
	public String getPassword(String name) {
		return this.userDAO.getPassword(name);
	}
}
