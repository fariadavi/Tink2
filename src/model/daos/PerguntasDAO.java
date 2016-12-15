package model.daos;

import java.util.ArrayList;

import model.tiposArquivo;
import model.beans.Pergunta;
import model.beans.Resposta;

public class PerguntasDAO extends XmlDAO<Pergunta>{

	private static final tiposArquivo tipo = tiposArquivo.PERGUNTAS;
	
	private ArrayList<Pergunta> perguntas;
	
	public PerguntasDAO() {
		super(tipo);
		perguntas = getList();
	}

	@Override
	public void addEntry(Pergunta newEntry) {
		newEntry.setIdPergunta(perguntas.size()+1);
		perguntas.add(newEntry);
		writeXML(perguntas);
		perguntas = refreshList();
	}	
	
	public void updateEntry(Pergunta pergunta) {
		getList().set(pergunta.getIdPergunta()-1, pergunta);
		writeXML(perguntas);
	}
	
	public void addResposta(Resposta resp) {
		
	}
}
