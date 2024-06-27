package dao.interfaces;

import java.util.ArrayList;

import models.Quiz;

public interface IQuizDAO {
	public boolean saveQuizResult(Quiz quiz, String username);
	public ArrayList<Quiz> getAnsweredQuizzes(String username);
}
