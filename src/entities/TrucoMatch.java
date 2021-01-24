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
	//booleano para verificar se há o necessário para iniciar uma partida de truco
	private boolean trucoMatchRequirements;
	
	public TrucoMatch(List<TrucoTeam> teams) {
		this.trucoDeck = new TrucoDeck();
		this.teams = teams;
		for(TrucoTeam team : teams) {
			scoreboard.put(team, 0);
		}
		organizeSequence();
		setNewMao();
	}

	public TrucoDeck getTrucoDeck() {
		return trucoDeck;
	}
	
	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public List<Mao> getMaos() {
		return maos;
	}
	
	public Mao getCurrentMao() {
		return maos.get(maos.size()-1);
	}
	
	public Mao getLastMao() {
		return maos.get(maos.size()-2);
	}
	
	public void setNewMao() {
		trucoDeck.shuffle();
		TrucoCard vira = (TrucoCard) trucoDeck.takeCard();
		maos.add(new Mao(vira));
		getCurrentMao().setTrucoMatch(this);
	}

	public void setTrucoDeck(TrucoDeck trucoDeck) {
		this.trucoDeck = trucoDeck;
	}

	public HashMap<TrucoPlayer, Integer> getDefaultSequence() {
		return defaultSequence;
	}

	public void setDefaultSequence(HashMap<TrucoPlayer, Integer> defaultSequence) {
		this.defaultSequence = defaultSequence;
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
	
	public Round getCurrenteRound() {
		return getCurrentMao().getCurrentRound();
	}
	
	public Round getLastRound() {
		
		if(getCurrentMao().getRounds().size()==1 && maos.size()>1) {
			return getLastMao().getRounds().get(2);
		}
		return getCurrentMao().getLastRound();
	}
	
	//private method!
	private void organizeSequence() {
		int i = 0;
		int j = 0;
		while (i < teams.get(0).getPlayers().length) {
			for (TrucoTeam team : teams) {
				defaultSequence.put(team.getPlayers()[i], j);
				j++;
			}
			i++;
		}
	}
	
}
