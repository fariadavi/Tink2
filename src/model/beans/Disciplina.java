package model.beans;

public class Disciplina {

	private String nomeDisciplina;
	private String categoria;

	public Disciplina(String nomeDisciplina, String categoria) {
		this.nomeDisciplina = nomeDisciplina;
		this.categoria = categoria; 
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
