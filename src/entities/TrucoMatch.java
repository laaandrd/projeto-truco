package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrucoMatch {

	private TrucoDeck trucoDeck;
	private List<TrucoTeam> teams = new ArrayList<>();
	private List<Mao> maos = new ArrayList<>();
	private HashMap<TrucoPlayer, Integer> defaultSequence = new HashMap<>();
	private HashMap<TrucoTeam, Integer> scoreboard = new HashMap<>();
	// booleano para verificar se há o necessário para iniciar uma partida de truco
	private boolean trucoMatchRequirements;

	public TrucoMatch(List<TrucoTeam> teams) {
		this.trucoDeck = new TrucoDeck();
		this.teams = teams;
		for (TrucoTeam team : teams) {
			scoreboard.put(team, 0);
		}
		organizeSequence();
		setNewMao();
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

	public boolean isTrucoMatchRequirements() {
		return trucoMatchRequirements;
	}

	public void setTrucoMatchRequirements(boolean trucoMatchRequirements) {
		this.trucoMatchRequirements = trucoMatchRequirements;
	}

	public Mao getCurrentMao() {
		return maos.get(maos.size() - 1);
	}

	public Mao getLastMao() {
		return maos.get(maos.size() - 2);
	}

	public void setNewMao() {
		trucoDeck.setDefaultDeck();
		trucoDeck.shuffle();
		maos.add(new Mao());
		getCurrentMao().setTrucoMatch(this);
		for(TrucoTeam team : teams) {
			getCurrentMao().getMaoScoreboard().put(team, 0);
		}
		getCurrentMao().getPlayersCards();
		getCurrentMao().setNewRound();
	}

	public Round getCurrenteRound() {
		return getCurrentMao().getCurrentRound();
	}

	public Round getLastRound() {

		if (getCurrentMao().getRounds().size() == 1 && maos.size() > 1) {
			return getLastMao().getRounds().get(2);
		}
		return getCurrentMao().getLastRound();
	}
	
	public void increaseScore(TrucoTeam team) {
		Integer currentScore = scoreboard.get(team);
		scoreboard.replace(team, currentScore + getCurrentMao().getMaoValue());
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

}
