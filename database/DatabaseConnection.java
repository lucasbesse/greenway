package database;

import java.sql.*;

public class DatabaseConnection {
	
	private static final String URL = "jdbc:postgresql://isilo.db.elephantsql.com:5432/xwyacbbr";
    private static final String USUARIO = "xwyacbbr";
    private static final String SENHA = "ugwJTkwdMDkMi7RX1099JDLi0FfDmccw";
    
    private Connection connection;
    
    private static DatabaseConnection uniqueInstance;
    
    private DatabaseConnection() {
    	try {
    		this.createConnection();  		
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static synchronized DatabaseConnection getInstance() {
		if (uniqueInstance == null) {			
			uniqueInstance = new DatabaseConnection();
		}

		return uniqueInstance;
	}
    
    private void createConnection() throws SQLException {
    	try {
    		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
    		this.connection = connection;
    	} 
    	catch (SQLException e) {
            throw new SQLException("Falha ao conectar com o banco de dados.");
    	}
    }

    public Connection getConnection() {
    	return connection;
    }
}
