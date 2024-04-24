package models;

import java.util.List;

public class Quiz {

	private int id;
	private String conteudo;
	private List<Pergunta> perguntas;
	private String resultado;
	private ListaDeTarefas listaDeTarefas;
	private boolean concluido;
	
	public Quiz() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ListaDeTarefas getListaDeTarefas() {
		return listaDeTarefas;
	}

	public void setListaDeTarefas(ListaDeTarefas listaDeTarefas) {
		this.listaDeTarefas = listaDeTarefas;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
}
