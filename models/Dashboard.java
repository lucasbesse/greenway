package models;

import java.util.List;

public class Dashboard {
	
	private Usuario usuario;
	private List<ListaDeTarefas> listasDeTarefas;
	private List<Quiz> quizzesCompletos;
	private List<Quiz> quizzesParaFazer;
	
	public Dashboard() { }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ListaDeTarefas> getListasDeTarefas() {
		return listasDeTarefas;
	}

	public void setListasDeTarefas(List<ListaDeTarefas> listasDeTarefas) {
		this.listasDeTarefas = listasDeTarefas;
	}

	public List<Quiz> getQuizzesCompletos() {
		return quizzesCompletos;
	}

	public void setQuizzesCompletos(List<Quiz> quizzesCompletos) {
		this.quizzesCompletos = quizzesCompletos;
	}

	public List<Quiz> getQuizzesParaFazer() {
		return quizzesParaFazer;
	}

	public void setQuizzesParaFazer(List<Quiz> quizzesParaFazer) {
		this.quizzesParaFazer = quizzesParaFazer;
	}
}
