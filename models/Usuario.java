package models;

public class Usuario {
	
	private int id;
	private int nome;
	private int email;
	private int telefone;
	
	public Usuario() { }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNome() {
		return nome;
	}
	
	public void setNome(int nome) {
		this.nome = nome;
	}
	
	public int getEmail() {
		return email;
	}
	
	public void setEmail(int email) {
		this.email = email;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
