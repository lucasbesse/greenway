package controllers;

import java.sql.Statement;

import database.DatabaseConnection;
import dao.UserDAO;

import java.lang.*;
import java.sql.SQLException;
import java.sql.ResultSet;

public class RegisterController {
	
	private UserDAO userDAO;
	
	public RegisterController() { 
		userDAO = new UserDAO();
	}
	
	public void registerUser(String name, String password) {
		this.userDAO.createUser(name, password);
	}
}
