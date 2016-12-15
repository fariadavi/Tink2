package model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.tiposDisciplina;

public class Pergunta implements Serializable {

	private static final long serialVersionUID = 8695643412221891448L;
	
	private int idPergunta;
	private tiposDisciplina disciplina;
	private String titulo;
	private String descricao;
	private List<Resposta> respostas;
	
	public Pergunta() {}
	
	public Pergunta(tiposDisciplina disciplina, String titulo, String descricao) {
		this.disciplina = disciplina;
		this.titulo = titulo;
		this.descricao = descricao;
		this.respostas = new ArrayList<Resposta>();
	}

	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public tiposDisciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(tiposDisciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
}
