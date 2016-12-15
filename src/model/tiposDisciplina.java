package model;

public enum tiposDisciplina {
	LEITURA("Linguagens, C�digos e suas Tecnologias", "Leitura e interpreta��o de texto"),
	ARTES("Linguagens, C�digos e suas Tecnologias", "Artes corporais"),
	TEXTO_LITERIARIO("Linguagens, C�digos e suas Tecnologias", "Texto liter�rio"),
	PRODUCAO_TEXTO("Linguagens, C�digos e suas Tecnologias", "Produ��o de texto"),
	NORMAL_CULTA("Linguagens, C�digos e suas Tecnologias", "Norma culta da l�ngua"),
	TEC_INFO_COMUNICACAO("Linguagens, C�digos e suas Tecnologias", "Tecnologias da Informa��o e Comunica��o"),

	GEOMETRIA("Matem�tica e suas Tecnologias", "Geometria"),
	ESTAT_PROB("Matem�tica e suas Tecnologias", "Estat�stica e Probabilidade"),
	ALGEBRA("Matem�tica e suas Tecnologias", "�lgebra"),

	LEIS_FISICA("Ci�ncias da Natureza e suas Tecnologias", "Movimento, Equil�brio e Leis da F�sica"),
	LEIS_GRAVIDADE("Ci�ncias da Natureza e suas Tecnologias", "Leis da Gravidade"),
	FEN_ELETRICOS_MAGNETISMO("Ci�ncias da Natureza e suas Tecnologias", "Fen�menos el�tricos e magn�ticos"),
	TRANSFORMACOES_QUIMICAS("Ci�ncias da Natureza e suas Tecnologias", "Transforma��es qu�micas"),
	QUIMICA("Ci�ncias da Natureza e suas Tecnologias", "Qu�mica"),
	MOLECULAS_CELULAS_TECIDOS("Ci�ncias da Natureza e suas Tecnologias", "Mol�culas, C�lulas e Tecidos"),
	ORGANIZACAO_SERES("Ci�ncias da Natureza e suas Tecnologias", "Organiza��o dos seres vivos"),
	ECOLOGIA("Ci�ncias da Natureza e suas Tecnologias", "Ecologia"),
	EVOLUCAO("Ci�ncias da Natureza e suas Tecnologias", "Evolu��o"),

	DIVERSIDADE_CULTURAL("Ci�ncias Humanas e suas Tecnologias", "Diversidade cultural, conflitos e vida em sociedade"),
	SOCIOLOGIA("Ci�ncias Humanas e suas Tecnologias", "Sociologia"),
	ESTRUTURAS("Ci�ncias Humanas e suas Tecnologias", "Estruturas produtivas");
	
	private String categoria;
	private String nomeDisciplina;
	
	private tiposDisciplina(String categoria, String nomeDisc) {
		this.categoria = categoria;
		this.nomeDisciplina = nomeDisc;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	@Override
	public String toString() {
		return getNomeDisciplina();
	}
}
