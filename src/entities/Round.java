package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {

	private Mao mao;
	private TrucoCard vira;
	private HashMap<Integer, TrucoPlayer> roundSequence = new HashMap<>();
	private List<TrucoTeam> teams = new ArrayList<>();
	private TrucoPlayer roundWinner;

	//pensar em sobrecarga(s) para agilizar a adição de times e a organização da sequência
	public Round(TrucoCard vira) {
		this.vira = vira;
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}

	public TrucoCard getVira() {
		return vira;
	}

	public void setVira(TrucoCard vira) {
		this.vira = vira;
	}

	public HashMap<Integer, TrucoPlayer> getRoundSequence() {
		return roundSequence;
	}

	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<TrucoTeam> teams) {
		this.teams = teams;
	}

	public void findManilhas(TrucoPlayer player) {
		int i = vira.getDefaultTrucoValue();
		if (i == 10) {
			for (TrucoCard c : player.getCards()) {
				if (c.getDefaultTrucoValue() == 1) {
					c.makeManilha();
				}
			}
		} else {
			for (TrucoCard c : player.getCards()) {
				if (c.getDefaultTrucoValue() == i + 1) {
					c.makeManilha();
				}
			}
		}
	}

	public TrucoPlayer getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(TrucoPlayer roundWinner) {
		this.roundWinner = roundWinner;
	}
	
	public TrucoMatch getTrucoMatch() {
		return this.getMao().getTrucoMatch();
	}
	
	/*
	 * a sequência da classe TrucoMatch é HashMap<TrucoPlayer, Integer>
	 * a sequência da classe Round é HashMap<Integer, TrucoPlayer>
	 */
	public HashMap<Integer, TrucoPlayer> translateDefaultSequence(){
		HashMap<Integer, TrucoPlayer> translatedDefaultSequence = new HashMap<>();
		for(TrucoPlayer player : this.getTrucoMatch().getDefaultSequence().keySet()) {
			Integer playerIndex = this.getTrucoMatch().getDefaultSequence().get(player);
			translatedDefaultSequence.put(playerIndex, player);
		}
		
		return translatedDefaultSequence;
	}

	public void organizeRoundSequence() {
		roundSequence.clear();
		if (getTrucoMatch().getLastRound().getRoundWinner() == null) {
			roundSequence = translateDefaultSequence();
		}
		else {
			TrucoPlayer lastRoundWinner = getTrucoMatch().getLastRound().getRoundWinner();
			Integer basePlayerIndex = getTrucoMatch().getDefaultSequence().get(lastRoundWinner);
			for (TrucoPlayer player : getTrucoMatch().getDefaultSequence().keySet()) {
				Integer newPosition = getTrucoMatch().getDefaultSequence().get(player) - basePlayerIndex;
				if (newPosition >= 0) {
					roundSequence.put(newPosition, player);
				} else {
					newPosition += getTrucoMatch().getDefaultSequence().size();
					roundSequence.put(newPosition, player);
				}
			}
		}
	}

	public void printPlayersSequence() {
		System.out.println(roundSequence);
	}

	public void startRound() {

	}

}
