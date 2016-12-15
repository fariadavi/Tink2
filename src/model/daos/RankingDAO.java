package model.daos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.tiposArquivo;
import model.beans.Ranks;

public class RankingDAO extends XmlDAO<Ranks> {

	private static final tiposArquivo tipoArquivo = tiposArquivo.RANKING;
	
	private List<Ranks> ranking;
	
	public RankingDAO() {
		super(tipoArquivo);
		ranking = getList();
	}
	
	@Override
	public void addEntry(Ranks newEntry) {
		ranking.add(newEntry);
		orderRanking();
		ranking.remove(ranking.size()-1);
		
		writeXML(ranking);
	}

	private void orderRanking() {
		Collections.sort(ranking, new Comparator<Ranks>() {
			@Override
			public int compare(Ranks rank1, Ranks rank2) {
				return Integer.compare(rank1.getScore(), rank2.getScore());
			}
	    });
	}
}
