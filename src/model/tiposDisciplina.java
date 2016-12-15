package model;

public enum tiposDisciplina {
	LEITURA("Linguagens, Códigos e suas Tecnologias", "Leitura e interpretação de texto"),
	ARTES("Linguagens, Códigos e suas Tecnologias", "Artes corporais"),
	TEXTO_LITERIARIO("Linguagens, Códigos e suas Tecnologias", "Texto literário"),
	PRODUCAO_TEXTO("Linguagens, Códigos e suas Tecnologias", "Produção de texto"),
	NORMAL_CULTA("Linguagens, Códigos e suas Tecnologias", "Norma culta da língua"),
	TEC_INFO_COMUNICACAO("Linguagens, Códigos e suas Tecnologias", "Tecnologias da Informação e Comunicação"),

	GEOMETRIA("Matemática e suas Tecnologias", "Geometria"),
	ESTAT_PROB("Matemática e suas Tecnologias", "Estatística e Probabilidade"),
	ALGEBRA("Matemática e suas Tecnologias", "Álgebra"),

	LEIS_FISICA("Ciências da Natureza e suas Tecnologias", "Movimento, Equilíbrio e Leis da Física"),
	LEIS_GRAVIDADE("Ciências da Natureza e suas Tecnologias", "Leis da Gravidade"),
	FEN_ELETRICOS_MAGNETISMO("Ciências da Natureza e suas Tecnologias", "Fenômenos elétricos e magnéticos"),
	TRANSFORMACOES_QUIMICAS("Ciências da Natureza e suas Tecnologias", "Transformações químicas"),
	QUIMICA("Ciências da Natureza e suas Tecnologias", "Química"),
	MOLECULAS_CELULAS_TECIDOS("Ciências da Natureza e suas Tecnologias", "Moléculas, Células e Tecidos"),
	ORGANIZACAO_SERES("Ciências da Natureza e suas Tecnologias", "Organização dos seres vivos"),
	ECOLOGIA("Ciências da Natureza e suas Tecnologias", "Ecologia"),
	EVOLUCAO("Ciências da Natureza e suas Tecnologias", "Evolução"),

	DIVERSIDADE_CULTURAL("Ciências Humanas e suas Tecnologias", "Diversidade cultural, conflitos e vida em sociedade"),
	SOCIOLOGIA("Ciências Humanas e suas Tecnologias", "Sociologia"),
	ESTRUTURAS("Ciências Humanas e suas Tecnologias", "Estruturas produtivas");
	
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
