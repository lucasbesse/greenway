package models;

import java.util.List;

public class Quiz {

	private int id;
	private String content;
	private List<Question> questions;
	private String result;
	private String resume;
	private String result_text_a;
	private String result_text_b;
	private String result_text_c;
	private TaskList taskList;
	private boolean done;
	
	public Quiz() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String getResultText(String type) {
		String result_formatted = "";
		if(type == "A") {
			result_formatted = this.result_text_a;
		}
		if(type == "B") {
			result_formatted = this.result_text_b;
		}
		if(type == "C") {
			result_formatted = this.result_text_c;
		}
		
		return result_formatted;
	}

	public void setResultTextA(String text) {
		this.result_text_a = text;
	}
	
	public void setResultTextB(String text) {
		this.result_text_b = text;
	}
	
	public void setResultTextC(String text) {
		this.result_text_c = text;
	}
}
