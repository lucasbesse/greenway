package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.interfaces.IUserDAO;
import database.DatabaseConnection;
import models.User;

public class UserDAO extends ConnectionDAO implements IUserDAO {
	
    public UserDAO() {
//    	DatabaseConnection dbConnection = new DatabaseConnection();
//    	this.connection = dbConnection.getConnection();
    }

	@Override
	public boolean createUser(String name, String password) {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			String query = String.format("INSERT INTO usuarios (nome, senha) VALUES ('%s', '%s');", name, password);
		
			boolean result = statement.execute(query);
			if (!result) {				
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			this.closeStatement(statement);
		}
		
		return true;
	}
	
	@Override
	public User authenticate(String name, String password) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String userPassword = null;
		User user = new User();
		
        try {
        	String query = "SELECT id, senha FROM usuarios WHERE nome = ?";
        	preparedStatement = this.connection.prepareStatement(query);
        	
        	preparedStatement.setString(1, name);
        	resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	user.setId(resultSet.getInt("id"));
            	user.setName(name);
            	
            	userPassword = resultSet.getString("senha");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
        	this.closePreparedStatement(preparedStatement);
        	this.closeResultSet(resultSet);
        }
        
        if (password.equals(userPassword)) {
        	return user;
        }
        return null;
	}
}
