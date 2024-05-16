package models;

import java.util.List;

public class TaskList {
	
	private int id;
	private List<Task> tasks;
	
	public TaskList() { }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
