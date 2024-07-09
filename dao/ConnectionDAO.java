package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.interfaces.IConnectionDAO;
import database.DatabaseConnection;

public class ConnectionDAO implements IConnectionDAO {
	
	protected Connection connection;
	
	public ConnectionDAO() {
		DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		this.connection = dbConnection.getConnection();
	}

	@Override
	public void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
