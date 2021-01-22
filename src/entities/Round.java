package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class Round {
	
	private TrucoCard vira;
	private HashMap<Integer, TrucoPlayer> sequence = new HashMap<>();
	private List<TrucoTeam> teams = new ArrayList<>();
	private TrucoPlayer roundWinner;
	
	public Round (TrucoCard vira) {
		this.vira = vira;
	}
	
	public TrucoCard getVira() {
		return vira;
	}

	public void setVira(TrucoCard vira) {
		this.vira = vira;
	}

	public HashMap<Integer, TrucoPlayer> getSequence() {
		return sequence;
	}

	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<TrucoTeam> teams) {
		this.teams = teams;
	}

	public TrucoPlayer getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(TrucoPlayer roundWinner) {
		this.roundWinner = roundWinner;
	}


	
	public void organizeSequence(TrucoPlayer lastRoundWinner) {
		if(lastRoundWinner == null) {
			int i = 0;
			int j = 0;
			while(i < teams.get(0).getPlayers().length) {
				for (TrucoTeam team : teams) {
					sequence.put(j, team.getPlayers() [i]);
					j++;
				}
				i++;
			}
		}
	}
	
	public void printPlayersSequence() {
		System.out.println(sequence);
	}
	
	public void startRound() {

	}
	

}
