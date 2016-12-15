package model.beans;

public class Ranks {

	private int idUser;
	private int score;
	
	public Ranks() {
		this.score = 0;
	}
	
	public int getUserId() {
		return idUser;
	}
	
	public void setUserId(int idUser) {
		this.idUser = idUser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
