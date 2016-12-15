package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tiposDisciplina;
import model.beans.Pergunta;
import view.TelaNovaPergunta;

public class PerguntaHandler {
	
	private TelaNovaPergunta pergView;
	
	public PerguntaHandler(TelaNovaPergunta pergView) {
		this.pergView = pergView;
		
		this.pergView.addPerguntaListener(new PerguntaListener());
		
		setOpcoesDisciplina();
		pergView.pack();
	}

	private void setOpcoesDisciplina() {
		pergView.setOpcaoDisciplina(tiposDisciplina.AGUA);
		pergView.setOpcaoDisciplina(tiposDisciplina.ALGEBRA);
		pergView.setOpcaoDisciplina(tiposDisciplina.ARGUMENTACAO);
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
		pergView.setOpcaoDisciplina(tiposDisciplina.QUIMICA_COTIDIANO);
		pergView.setOpcaoDisciplina(tiposDisciplina.SOCIOLOGIA);
		pergView.setOpcaoDisciplina(tiposDisciplina.TEC_INFO_COMUNICACAO);
		pergView.setOpcaoDisciplina(tiposDisciplina.TEXTO_LITERIARIO);
		pergView.setOpcaoDisciplina(tiposDisciplina.TRANSFORMACOES_QUIMICAS);
	}

	class PerguntaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			Component component = (Component) evt.getSource();
			if (component.getName() == "btnEnviar") {
				tiposDisciplina dscplnPerg = pergView.getDisciplinaPergunta();
				String dscrcPerg = pergView.getDescricaoPergunta();
				String ttlPerg = pergView.getTituloPergunta();
				
				new Pergunta(dscplnPerg, ttlPerg, dscrcPerg);
			}
		}
	}
}
