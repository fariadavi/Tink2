package model.daos;

import java.util.ArrayList;

import model.tiposArquivo;
import model.beans.Cadastro;

public class CadastroDAO extends XmlDAO<Cadastro> {

	private static final tiposArquivo tipoArquivo = tiposArquivo.CADASTRO; 
	
	private ArrayList<Cadastro> cadastros;
	
	public CadastroDAO() {
		super(tipoArquivo);
		cadastros = getList();
	}

	@Override
	public void addEntry(Cadastro novoCadastro) {
		novoCadastro.setIdsOnSave(cadastros.size()+1);
		cadastros.add(novoCadastro);
		writeXML(cadastros);
	}
	
	public void updateEntry(Cadastro cadastro) {
		getList().set(cadastro.getIdUsr()-1, cadastro);
	}
	
	public Cadastro getCadastro(String userLoginInfo) {
		refreshList();
		
		for (Cadastro cadastro : getList())
			if(cadastro.getUser().equalsIgnoreCase(userLoginInfo) || cadastro.getMail().equalsIgnoreCase(userLoginInfo))
				return cadastro;
		return null;
	}
}
