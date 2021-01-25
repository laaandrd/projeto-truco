package entities;

import java.util.ArrayList;
import java.util.List;

public class TrucoTeam {
	
	private int id;
	private Integer numberOfPlayers;
	private List<TrucoPlayer> players = new ArrayList<>();
	//private TrucoPlayer [] players = new TrucoPlayer[2];
	private int points;
	
	public TrucoTeam(int id) {
		this.id = id;
		this.numberOfPlayers = 2;
	}
	
	public TrucoTeam(int id, int numberOfPlayers) {
		this.id = id;
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TrucoPlayer> getPlayers() {
		return players;
	}

	public void addPlayer(TrucoPlayer player) {
		if(players.size() < numberOfPlayers) {
			player.setTeam(this);
			players.add(player);
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
	
	@Override
	public String toString() {
		return "Team #" + id;
	}
	
	

}
