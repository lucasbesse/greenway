package src;

import src.DatabaseConnection;
import java.sql.Statement;
import java.lang.*;
import java.sql.SQLException;
import java.sql.ResultSet;

public class RegisterController {
	
	private DatabaseConnection dbConnection;
	
	public RegisterController(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public void registerNewUser(String nome, String senha) {
		Statement statement = this.dbConnection.getStatement();
		String query = String.format("INSERT INTO usuarios (nome, senha) VALUES ('%s', '%s');", nome, senha);
		
		try {
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
