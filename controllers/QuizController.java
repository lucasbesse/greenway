package controllers;

import dao.QuizDAO;
import models.Quiz;
import java.util.ArrayList;

public class QuizController {
	private QuizDAO quizDAO;
	
	public QuizController() { 
		quizDAO = new QuizDAO();
	}
	
	public boolean saveQuizResult(Quiz quiz, String username) {
		return this.quizDAO.saveQuizResult(quiz, username);
	}
	
	public ArrayList<Quiz> getAnsweredQuizzes(String username) {
		return this.quizDAO.getAnsweredQuizzes(username);
	}
	
	public boolean deleteResultForRemake(int quizId, String username) {
		return this.quizDAO.deleteResultForRemake(quizId, username);
	}
}
