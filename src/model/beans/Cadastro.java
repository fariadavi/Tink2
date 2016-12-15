package model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.tiposAcesso;

public class Cadastro implements Serializable {

	private static final long serialVersionUID = -3935035025131731085L;

	private Integer id;
	private String user;
	private String password;
	private String mail;
	private tiposAcesso tipoAcesso;
	private Ranks rank;
	private List<Integer> idPerguntas;

	public Cadastro() {}

	public Cadastro(String user, String password, String mail, boolean isAluno, boolean isProfessor) {
		this.user = user;
		this.password = password;
		this.mail = mail;
		this.tipoAcesso = isAluno ? tiposAcesso.ALUNO : isProfessor ? tiposAcesso.PROFESSOR : null;
		this.rank = new Ranks();
		this.idPerguntas = new ArrayList<Integer>();
	}

	public Integer getIdCadastro() {
		return id;
	}

	public void setIdCadastro(Integer id) {
		this.id = id;
	}
	
	public void setIdsOnSave(Integer id) {
		this.id = id;
		this.rank.setUserId(id);
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public tiposAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(tiposAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public Ranks getRanking() {
		return rank;
	}

	public void setRanking(Ranks ranking) {
		this.rank = ranking;
	}

	public List<Integer> getIdPerguntas() {
		return idPerguntas;
	}

	public void setIdPerguntas(List<Integer> idPerguntas) {
		this.idPerguntas = idPerguntas;
	}
}
