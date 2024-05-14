package src;

import java.sql.*;

public class DatabaseConnection {
	
	private static final String URL = "jdbc:postgresql://isilo.db.elephantsql.com:5432/xwyacbbr";
    private static final String USUARIO = "xwyacbbr";
    private static final String SENHA = "ugwJTkwdMDkMi7RX1099JDLi0FfDmccw";
    
    private Connection connection;
    private Statement statement;
    
    public DatabaseConnection() {
    	try {
    		this.createConnection();  		
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    	
    
    private void createConnection() throws SQLException {
    	try {
    		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
    		this.connection = connection;
    		
    		this.createStatement();
    	} 
    	catch (SQLException e) {
            throw new SQLException("Falha ao conectar com o banco de dados.");
    	}
    }
    
    private void createStatement() throws SQLException {
    	try {
    		Statement statement = connection.createStatement();
    		this.statement = statement;
    	} 
    	catch (SQLException e) {
            throw new SQLException("Falha ao criar statement da conexão com o banco de dados.");
    	}
    }

    public Connection getConnection() {
    	return connection;
    }
    
    public Statement getStatement() {
    	return statement;
    }
}
