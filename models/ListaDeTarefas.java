package models;

import java.util.List;

public class ListaDeTarefas {
	
	private int id;
	private List<Tarefa> tarefas;
	
	public ListaDeTarefas() { }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}
