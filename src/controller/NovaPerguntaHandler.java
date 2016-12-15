package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.tiposDisciplina;
import model.beans.Cadastro;
import model.beans.Pergunta;
import model.daos.CadastroDAO;
import model.daos.PerguntasDAO;
import view.TelaNovaPergunta;
import view.TelaPergunta;

public class NovaPerguntaHandler {
	
	private PerguntasDAO perguntaDAO;
	private CadastroDAO cadastroDAO;
	
	private TelaNovaPergunta newPergView;
	private Cadastro user;
	
	public NovaPerguntaHandler(TelaNovaPergunta pergView, Cadastro user) {
		this.newPergView = pergView;
		this.user = user;
		this.perguntaDAO = new PerguntasDAO();
		this.cadastroDAO = new CadastroDAO();
		
		this.newPergView.addPerguntaListener(new NewPerguntaListener());
		
		setOpcoesDisciplina();
		newPergView.pack();
	}

	private void setOpcoesDisciplina() {
		newPergView.setOpcaoDisciplina(tiposDisciplina.ALGEBRA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.ARTES);
		newPergView.setOpcaoDisciplina(tiposDisciplina.DIVERSIDADE_CULTURAL);
		newPergView.setOpcaoDisciplina(tiposDisciplina.ECOLOGIA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.ESTAT_PROB);
		newPergView.setOpcaoDisciplina(tiposDisciplina.ESTRUTURAS);
		newPergView.setOpcaoDisciplina(tiposDisciplina.EVOLUCAO);
		newPergView.setOpcaoDisciplina(tiposDisciplina.FEN_ELETRICOS_MAGNETISMO);
		newPergView.setOpcaoDisciplina(tiposDisciplina.GEOMETRIA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.LEIS_FISICA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.LEIS_GRAVIDADE);
		newPergView.setOpcaoDisciplina(tiposDisciplina.LEITURA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.MOLECULAS_CELULAS_TECIDOS);
		newPergView.setOpcaoDisciplina(tiposDisciplina.NORMAL_CULTA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.ORGANIZACAO_SERES);
		newPergView.setOpcaoDisciplina(tiposDisciplina.PRODUCAO_TEXTO);
		newPergView.setOpcaoDisciplina(tiposDisciplina.QUIMICA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.SOCIOLOGIA);
		newPergView.setOpcaoDisciplina(tiposDisciplina.TEC_INFO_COMUNICACAO);
		newPergView.setOpcaoDisciplina(tiposDisciplina.TEXTO_LITERIARIO);
		newPergView.setOpcaoDisciplina(tiposDisciplina.TRANSFORMACOES_QUIMICAS);
	}

	class NewPerguntaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			Component component = (Component) evt.getSource();
			switch (component.getName()) {
				
				case "btnEnviar":
					tiposDisciplina dscplnPerg = newPergView.getDisciplinaPergunta();
					String dscrcPerg = newPergView.getDescricaoPergunta();
					String ttlPerg = newPergView.getTituloPergunta();
					
					Pergunta pergunta = new Pergunta(dscplnPerg, ttlPerg, dscrcPerg);
					
					perguntaDAO.addEntry(pergunta);
					
					addIdPergunta();
					
					cadastroDAO.updateEntry(user);
					
					TelaPergunta telaPergunta = new TelaPergunta();
					new PerguntaHandler(telaPergunta, pergunta, user); 
					telaPergunta.setVisible(true);
					telaPergunta.setLocationRelativeTo(null);
					newPergView.dispose();
					break;
				
				case "btnCancelar":
					newPergView.dispose();
					break;
			}
		}

		private void addIdPergunta() {
			List<Integer> idPerguntas = user.getIdPerguntas();
			idPerguntas.add(perguntaDAO.getList().size());
			user.setIdPerguntas(idPerguntas);
		}
	}
}
