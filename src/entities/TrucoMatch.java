package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.TrucoException;

public class TrucoMatch {

	private TrucoDeck trucoDeck;
	private List<TrucoTeam> teams = new ArrayList<>();
	private List<Mao> maos = new ArrayList<>();
	private HashMap<TrucoPlayer, Integer> defaultSequence = new HashMap<>();
	private HashMap<TrucoTeam, Integer> scoreboard = new HashMap<>();
	private TrucoTeam winner;

	public TrucoMatch(List<TrucoTeam> teams) {
		this.trucoDeck = new TrucoDeck();
		this.teams = teams;
		for (TrucoTeam team : teams) {
			scoreboard.put(team, 0);
		}
		verifyTrucoMatchRequirements();
		organizeSequence();
	}

	public TrucoDeck getTrucoDeck() {
		return trucoDeck;
	}
	
	public void setTrucoDeck(TrucoDeck trucoDeck) {
		this.trucoDeck = trucoDeck;
	}

	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<TrucoTeam> teams) {
		this.teams = teams;
	}

	public List<Mao> getMaos() {
		return maos;
	}

	public HashMap<TrucoPlayer, Integer> getDefaultSequence() {
		return defaultSequence;
	}

	public HashMap<TrucoTeam, Integer> getScoreboard() {
		return scoreboard;
	}

	public TrucoTeam getWinner() {
		return winner;
	}

	public void setWinner(TrucoTeam winner) {
		this.winner = winner;
	}

	public Mao getCurrentMao() {
		if(maos.size() > 0) {
			return maos.get(maos.size() - 1);
		}
		throw new TrucoException("There isn't any mão on this match!");
	}

	public Mao getLastMao() {
		if(maos.size() > 1) {
			return maos.get(maos.size() - 2);
		}
		if(maos.size() == 1) {
			throw new TrucoException("There is just 01 mão on this match!");
		}
		throw new TrucoException("There isn't any mão on this match!");
	}

	public void setNewMao() {
		for(TrucoTeam team : teams) {
			for(TrucoPlayer player : team.getPlayers()) {
				player.cleanCards();
			}
		}
		trucoDeck.setDefaultDeck();
		trucoDeck.shuffle();
		maos.add(new Mao());
		getCurrentMao().setTrucoMatch(this);
		for(TrucoTeam team : teams) {
			getCurrentMao().getMaoScoreboard().put(team, 0);
		}
		getCurrentMao().getPlayersCards();
	}

	public Round getCurrenteRound() {
		return getCurrentMao().getCurrentRound();
	}

	public Round getLastRound() {

		if (getCurrentMao().getRounds().size() == 1 && maos.size() > 1) {
			return getLastMao().getCurrentRound();
		}
		return getCurrentMao().getLastRound();
	}
	
	public void increaseScore(TrucoTeam team) {
		Integer currentScore = scoreboard.get(team);
		scoreboard.replace(team, currentScore + getCurrentMao().getMaoValue());
	}
	
	public void findWinner() {
		for(TrucoTeam team : scoreboard.keySet()) {
			if(scoreboard.get(team) >= 12) {
				winner = team;
			}
		}
	}

	// private method!
	private void organizeSequence() {
		int i = 0;
		int j = 0;
		while (i < teams.get(0).getPlayers().size()) {
			for (TrucoTeam team : teams) {
				defaultSequence.put(team.getPlayers().get(i), j);
				j++;
			}
			i++;
		}
	}
	
	private void verifyTrucoMatchRequirements() {
		int aux = 0;
		if(teams.size() < 2) {
			throw new TrucoException("Can't start Truco Match: insufficient number of teams.");
		}
		int numberOfPlayersPerTeam = teams.get(0).getPlayers().size();
		for(TrucoTeam team : teams) {
			if(team.getPlayers().size() == numberOfPlayersPerTeam) {
				aux++;
			}
		}
		if(aux != teams.size()) {
			throw new TrucoException("Can't start Truco Match: all teams must have the same number of players.");
		}
	}

}
