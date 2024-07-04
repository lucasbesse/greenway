package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.interfaces.IQuizDAO;
import models.Quiz;

public class QuizDAO extends ConnectionDAO implements IQuizDAO {

	@Override
	public boolean saveQuizResult(Quiz quiz, String username) {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			String query = String.format("INSERT INTO testes_respondidos (idTeste, usuario, resultado) VALUES ('%d', '%s', '%s');", quiz.getId(), username, quiz.getResult());
		
			boolean result = statement.execute(query);
			if (!result) {				
				System.out.println("Quiz salvo com sucesso!");
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
	public ArrayList<Quiz> getAnsweredQuizzes(String username) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ArrayList<Quiz> answeredQuizzes = new ArrayList<Quiz>();
		
		try {
            String query = "SELECT id, idTeste, resultado, usuario FROM testes_respondidos WHERE usuario = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	Quiz quiz = new Quiz();
            	quiz.setId(resultSet.getInt("idTeste"));
            	quiz.setResult(resultSet.getString("resultado"));
            	quiz.setDone(true);

                answeredQuizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closePreparedStatement(preparedStatement);
            this.closeResultSet(resultSet);
        }
		
		return answeredQuizzes;
	}
	
	@Override
	public boolean deleteResultForRemake(int quizId, String username) {
		PreparedStatement preparedStatement = null;
		
		try {
            String query = "DELETE FROM testes_respondidos WHERE idTeste = ? AND usuario = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quizId);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Registro removido com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado.");
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.closePreparedStatement(preparedStatement);
        }
		
		return true;
    }
}
