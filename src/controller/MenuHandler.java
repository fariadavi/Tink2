package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.beans.Cadastro;
import view.ItemMenu;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaNovaPergunta;
import view.TelaRanking;

public class MenuHandler {
	
	private TelaMenu menuView;
	private Cadastro usrLogado;
	
	public MenuHandler(TelaMenu menuView, Cadastro usrLogado) {
		this.menuView = menuView;
		this.usrLogado = usrLogado;
		
		this.menuView.addMenuListener(new MenuListener());
		
		setTipoMenu();
		menuView.pack();
	}

	private void setTipoMenu() {
		ItemMenu[] opcoes = menuView.getOpcoes();
		
		switch (usrLogado.getTipoAcesso()) {
			case ALUNO:
		        opcoes[1].setBotaoOpcaoText("Minhas Perguntas");
		        opcoes[1].setBotaoOpcaoName("MINHAS_PERG");
		        menuView.unhideItem();
		        break;
			case PROFESSOR:
		        opcoes[1].setBotaoOpcaoText("Responder Perguntas");
		        opcoes[1].setBotaoOpcaoName("RESP_PERG");
		        menuView.hideItem();
		        break;
		}
		
		menuView.setOpcoes(opcoes);
	}
	
	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			Component component = (Component) evt.getSource();
			switch (component.getName()) {

			case "CRIAR_PERG":
				TelaNovaPergunta telaNovaPergunta = new TelaNovaPergunta();
				new NovaPerguntaHandler(telaNovaPergunta, usrLogado); 
				telaNovaPergunta.setVisible(true);
				telaNovaPergunta.setLocationRelativeTo(null);	
				break;

			case "MINHAS_PERG":
				break;

			case "RESP_PERG":
				TelaNovaPergunta telaNovaPergunta2 = new TelaNovaPergunta();
				new NovaPerguntaHandler(telaNovaPergunta2, usrLogado); 
				telaNovaPergunta2.setVisible(true);
				telaNovaPergunta2.setLocationRelativeTo(null);	
				break;

			case "PESQ_PERG":
				break;
				
			case "RANKING":
				TelaRanking telaRanking = new TelaRanking();
				new RankingHandler(telaRanking); 
				telaRanking.setVisible(true);
				telaRanking.setLocationRelativeTo(null);
				break;

			case "LOGOUT":
				TelaLogin telaLogin = new TelaLogin();
				new LoginHandler(telaLogin); 
				telaLogin.setVisible(true);
				telaLogin.setLocationRelativeTo(null);
				menuView.dispose();
				break;
				
			case "SAIR":
				System.exit(0);
			}
		}
	}
}
