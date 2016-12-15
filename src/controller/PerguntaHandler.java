package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.tiposAcesso;
import model.tiposDisciplina;
import model.beans.Cadastro;
import model.beans.Pergunta;
import model.daos.PerguntasDAO;
import view.TelaPergunta;

public class PerguntaHandler extends JFrame {

	private static final long serialVersionUID = 1918630303366179783L;
	
	private TelaPergunta pergView;
	private Pergunta pergunta;
	private Cadastro user;

	private PerguntasDAO pergDAO;

	public PerguntaHandler(TelaPergunta telaNewPergunta, Pergunta pergunta, Cadastro user) {
		this.pergView = telaNewPergunta;
		this.pergunta = pergunta;
		this.user = user;
		
		this.pergDAO = new PerguntasDAO();
		
		setDisciplinas();
		setPerguntaInfos();
		
		this.pergView.addPerguntaListener(new PerguntaListener());
	}

	private void setDisciplinas() {
		pergView.setOpcaoDisciplina(tiposDisciplina.ALGEBRA);
		pergView.setOpcaoDisciplina(tiposDisciplina.ARTES);
		pergView.setOpcaoDisciplina(tiposDisciplina.DIVERSIDADE_CULTURAL);
		pergView.setOpcaoDisciplina(tiposDisciplina.ECOLOGIA);
		pergView.setOpcaoDisciplina(tiposDisciplina.ESTAT_PROB);
		pergView.setOpcaoDisciplina(tiposDisciplina.ESTRUTURAS);
		pergView.setOpcaoDisciplina(tiposDisciplina.EVOLUCAO);
		pergView.setOpcaoDisciplina(tiposDisciplina.FEN_ELETRICOS_MAGNETISMO);
		pergView.setOpcaoDisciplina(tiposDisciplina.GEOMETRIA);
		pergView.setOpcaoDisciplina(tiposDisciplina.LEIS_FISICA);
		pergView.setOpcaoDisciplina(tiposDisciplina.LEIS_GRAVIDADE);
		pergView.setOpcaoDisciplina(tiposDisciplina.LEITURA);
		pergView.setOpcaoDisciplina(tiposDisciplina.MOLECULAS_CELULAS_TECIDOS);
		pergView.setOpcaoDisciplina(tiposDisciplina.NORMAL_CULTA);
		pergView.setOpcaoDisciplina(tiposDisciplina.ORGANIZACAO_SERES);
		pergView.setOpcaoDisciplina(tiposDisciplina.PRODUCAO_TEXTO);
		pergView.setOpcaoDisciplina(tiposDisciplina.QUIMICA);
		pergView.setOpcaoDisciplina(tiposDisciplina.SOCIOLOGIA);
		pergView.setOpcaoDisciplina(tiposDisciplina.TEC_INFO_COMUNICACAO);
		pergView.setOpcaoDisciplina(tiposDisciplina.TEXTO_LITERIARIO);
		pergView.setOpcaoDisciplina(tiposDisciplina.TRANSFORMACOES_QUIMICAS);
	}

	private void setPerguntaInfos() {
		pergView.setLblTitulo(pergunta.getTitulo());
		pergView.setLblDescricao(pergunta.getDescricao());
		pergView.setDisciplina(pergunta.getDisciplina());
		
		if (user.getTipoAcesso().equals(tiposAcesso.ALUNO)) {
			pergView.disableChangeDisciplina();
			pergView.hideChngDscpln();
		} else if (user.getTipoAcesso().equals(tiposAcesso.PROFESSOR)) {
			pergView.enableChangeDisciplina();
			pergView.showChngDscpln();
		}
	}
	
	class PerguntaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Component component = (Component) evt.getSource();
			switch (component.getName()) {
				case "btnEnviar":
				
			 		break;
			 	case "btnCancelar":
					pergView.dispose();
					break;
				case "btnChngDscpln":
					tiposDisciplina newDisciplina = pergView.getDisciplina();
					pergunta.setDisciplina(newDisciplina);
					pergDAO.updateEntry(pergunta);
					break;
			}
		}
	}
}
