package dao.interfaces;

import java.util.List;
import models.User;

public interface IUserDAO {
	public boolean createUser(String name, String password);
	public User authenticate(String name, String password);
	public List<User> getAllUsers();
	public String getPassword(String name);
}
