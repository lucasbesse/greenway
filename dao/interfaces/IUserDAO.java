package dao.interfaces;

import models.User;

public interface IUserDAO {
	public boolean createUser(String name, String password);
	public User authenticate(String name, String password);
}
