package model.beans;

public class Resposta {

	private Cadastro dono;
	private String descricao;
	
	public Resposta() {}
	
	public Resposta(Cadastro cadastro, String descricao) {
		this.dono = cadastro;
		this.descricao = descricao;
	}
	
	
	public Cadastro getDono() {
		return dono;
	}

	public void setDono(Cadastro dono) {
		this.dono = dono;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
