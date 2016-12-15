package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.beans.Cadastro;
import model.beans.Ranks;
import model.daos.CadastroDAO;
import view.TelaRanking;

public class RankingHandler {
	
	private TelaRanking rankingView;
	private CadastroDAO cadastroDAO;
//	private RankingDAO rankingDAO;
	
	public RankingHandler(TelaRanking rankingView) {
		this.rankingView = rankingView;
		this.cadastroDAO = new CadastroDAO();
//		this.rankingDAO = new RankingDAO();
		
		exibeRanking();
		this.rankingView.addRankingListener(new RankingListener());
	}
	
	private void exibeRanking() {
		getUsers();
		rankingView.pack();
	}

	private void getUsers() {
//		List<Ranks> ranking = rankingDAO.getList();
//		if(ranking == null || ranking.isEmpty()) {
			List<Ranks>	ranking = getRankListFromCadastros();
//			rankingDAO.updateWholeList(ranking);
//		}
			
		int count = 0;
		for (Ranks rnkedUsr : ranking) {
			if(rnkedUsr == null)
				break;
			Cadastro user = cadastroDAO.getEntry(rnkedUsr.getUserId());
			setRanking(rnkedUsr, user, count++);
		}
	}

	private ArrayList<Ranks> getRankListFromCadastros() {
		ArrayList<Ranks> ranks = new ArrayList<Ranks>();
		for (Cadastro cadastro : cadastroDAO.getList())
			ranks.add(cadastro.getRanking());
		
		orderRanking(ranks);
		Ranks[] temp = ranks.toArray(new Ranks[ranks.size()]);
		Ranks[] temp2 = Arrays.copyOfRange(temp, 0, 9);
		
		return new ArrayList<Ranks>(Arrays.asList(temp2));
	}
	
	private void orderRanking(List<Ranks> ranking) {
		Collections.sort(ranking, new Comparator<Ranks>() {
			@Override
			public int compare(Ranks rank1, Ranks rank2) {
				return Integer.compare(rank1.getScore(), rank2.getScore());
			}
		});
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
