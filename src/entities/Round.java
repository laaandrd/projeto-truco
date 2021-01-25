package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {

	private Mao mao;
	private TrucoCard vira;
	private List<TrucoTeam> teams = new ArrayList<>();
	private HashMap<Integer, TrucoPlayer> roundSequence = new HashMap<>();
	private List<TrucoCard> playersCardsOnTable = new ArrayList<>();
	private TrucoPlayer roundWinner;	
	private boolean tiedRound;

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

	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<TrucoTeam> teams) {
		this.teams = teams;
	}

	public HashMap<Integer, TrucoPlayer> getRoundSequence() {
		return roundSequence;
	}
	
	public List<TrucoCard> getPlayersCardsOnTable() {
		return playersCardsOnTable;
	}

	public TrucoPlayer getRoundWinner() {
		return roundWinner;
	}

	public void setRoundWinner(TrucoPlayer roundWinner) {
		this.roundWinner = roundWinner;
	}
	
	public boolean isTiedRound() {
		return tiedRound;
	}

	public void setTiedRound(boolean tiedRound) {
		this.tiedRound = tiedRound;
	}
	
	public TrucoMatch getTrucoMatch() {
		return this.getMao().getTrucoMatch();
	}
	
	public void findManilhas(List <TrucoCard> cards) {
		int i = vira.getDefaultTrucoValue();
		if (i == 10) {
			for (TrucoCard c : cards) {
				if (c.getDefaultTrucoValue() == 1) {
					c.makeManilha();
				}
			}
		} else {
			for (TrucoCard c : cards) {
				if (c.getDefaultTrucoValue() == i + 1) {
					c.makeManilha();
				}
			}
		}
	}
	
	public void clearManilhas(List <TrucoCard> cards) {
		for(TrucoCard card : cards) {
			card.unmakeManilha();
		}
	}
	
	public void addPlayerCardOnTable(TrucoPlayer player, int cardIndex) {
		if(player.getCards()[cardIndex] != null){
			playersCardsOnTable.add(player.playCard(cardIndex));
		}
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
	
	public List<TrucoPlayer> getOrdenedPlayers(){
		List<TrucoPlayer> ordenedPlayers = new ArrayList<>();
		
		for(Integer playerIndex : roundSequence.keySet()) {
			ordenedPlayers.add(playerIndex, roundSequence.get(playerIndex));
		}
		
		return ordenedPlayers;
	}

	public void printPlayersSequence() {
		System.out.println(roundSequence);
	}
	
	public void findRoundWinner() {
		int aux = 0;
		int index = -1;
		findManilhas(playersCardsOnTable);
		for(int i = 0; i<playersCardsOnTable.size();i++) {
			int cardValue = playersCardsOnTable.get(i).getRelativeValue();
			if(cardValue > aux) {
				aux = cardValue;
				index = i;
				tiedRound = false;
			}
			else if(cardValue == aux) {
				tiedRound = true;
			}
		}
		clearManilhas(playersCardsOnTable);
		roundWinner = getOrdenedPlayers().get(index);
		setRoundWinner(roundWinner);
	}

}
