package model.beans;

public class Resposta {

	private String username;
	private String descricao;
	
	public Resposta() {}
	
	public Resposta(String username, String descricao) {
		this.username = username;
		this.descricao = descricao;
	}
	
	public String getUserName() {
		return username;
	}

	public void setDono(String username) {
		this.username = username;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
