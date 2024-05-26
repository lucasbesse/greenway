package controllers;

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
}
