package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.interfaces.IUserDAO;
import database.DatabaseConnection;

public class UserDAO implements IUserDAO {
	
	private Connection connection;

    public UserDAO() {
    	DatabaseConnection dbConnection = new DatabaseConnection();
    	connection = dbConnection.getConnection();
    }

	@Override
	public void createUser(String name, String password) {
		try {
			Statement statement = connection.createStatement();
			String query = String.format("INSERT INTO usuarios (nome, senha) VALUES ('%s', '%s');", name, password);
		
			boolean result = statement.execute(query);
			if (!result) {				
				System.out.println("Usuário cadastrado com sucesso!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
