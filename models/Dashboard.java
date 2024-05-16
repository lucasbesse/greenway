package models;

import java.util.List;

public class Dashboard {
	
	private User user;
	private List<TaskList> tasksLists;
	private List<Quiz> quizzesDone;
	private List<Quiz> quizzesToDo;
	
	public Dashboard() { }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TaskList> getTasksLists() {
		return tasksLists;
	}

	public void setTasksLists(List<TaskList> tasksLists) {
		this.tasksLists = tasksLists;
	}

	public List<Quiz> getQuizzesDone() {
		return quizzesDone;
	}

	public void setQuizzesDone(List<Quiz> quizzesDone) {
		this.quizzesDone = quizzesDone;
	}

	public List<Quiz> getQuizzesToDo() {
		return quizzesToDo;
	}

	public void setQuizzesToDo(List<Quiz> quizzesToDo) {
		this.quizzesToDo = quizzesToDo;
	}
}
