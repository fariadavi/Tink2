package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.beans.Cadastro;
import model.beans.Ranks;
import model.daos.CadastroDAO;
import model.daos.RankingDAO;
import view.TelaRanking;

public class RankingHandler {
	
	private TelaRanking rankingView;
	private CadastroDAO cadastroDAO;
	private RankingDAO rankingDAO;
	
	public RankingHandler(TelaRanking rankingView) {
		this.rankingView = rankingView;
		this.cadastroDAO = new CadastroDAO();
		this.rankingDAO = new RankingDAO();
		
		exibeRanking();
		this.rankingView.addRankingListener(new RankingListener());
	}
	
	private void exibeRanking() {
		getUsers();
		rankingView.pack();
	}

	private void getUsers() {
		List<Ranks> ranking = rankingDAO.getList();
		int count = 0;
		for (Ranks rnkedUsr : ranking) {
			Cadastro user = cadastroDAO.getEntry(rnkedUsr.getUserId());
			setRanking(rnkedUsr, user, count++);
		}
	}

	private void setRanking(Ranks rank, Cadastro user, int pos) {
			rankingView.setPosicoesRanking(pos, user.getUser(), rank.getScore());
	}

	class RankingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			rankingView.dispose();
		}
	}
}
