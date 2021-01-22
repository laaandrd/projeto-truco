package entities;

public class TrucoTeam {
	
	private int id;
	private TrucoPlayer [] players = new TrucoPlayer[2];
	private int points;
	
	public TrucoTeam(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TrucoPlayer[] getPlayers() {
		return players;
	}

	public void addPlayer(TrucoPlayer player) {
		for(int i = 0; i < players.length; i++) {
			if(players[i]==null) {
				players[i]=player;
				player.setTeam(this);
				i = players.length;
			}
		}
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}
	
	public void removePoints(int points) {
		this.points -= points;
	}
	
	
	
	

}
