package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mao {

	private TrucoMatch trucoMatch;
	private List<Round> rounds = new ArrayList<>();
	private int maoValue;
	private TrucoPlayer lastToIncreaseValue;
	private HashMap<TrucoTeam, Integer> maoScoreboard = new HashMap<>();
	private TrucoTeam maoWinner;

	public Mao() {
		this.maoValue = 1;
	}

	public TrucoMatch getTrucoMatch() {
		return trucoMatch;
	}

	public void setTrucoMatch(TrucoMatch trucoMatch) {
		this.trucoMatch = trucoMatch;
	}

	public List<Round> getRounds() {
		return rounds;
	}
	
	public int getMaoValue() {
		return maoValue;
	}
	
	public TrucoPlayer getLastToIncreaseValue() {
		return lastToIncreaseValue;
	}

	public void setLastToIncreaseValue(TrucoPlayer lastToIncreaseValue) {
		this.lastToIncreaseValue = lastToIncreaseValue;
	}
	
	public HashMap<TrucoTeam, Integer> getMaoScoreboard() {
		return maoScoreboard;
	}

	public TrucoTeam getMaoWinner() {
		return maoWinner;
	}

	public void setMaoWinner(TrucoTeam maoWinner) {
		this.maoWinner = maoWinner;
		if(trucoMatch != null) {
			trucoMatch.increaseScore(maoWinner);
		}
	}

	public Round getCurrentRound() {
		return rounds.get(rounds.size() - 1);
	}

	public Round getLastRound() {
		if (rounds.size() > 1) {
			return rounds.get(rounds.size() - 2);
		}
		return getCurrentRound();
	}

	public void setNewRound() {
		TrucoCard vira;
		if (trucoMatch != null && rounds.size() < 3) {
			vira = (TrucoCard) trucoMatch.getTrucoDeck().takeCard();
			rounds.add(new Round(vira));
			getCurrentRound().setMao(this);
			getCurrentRound().organizeRoundSequence();
		}
		else if (rounds.size() < 3) {
			TrucoDeck td = new TrucoDeck();
			td.shuffle();
			vira = (TrucoCard) td.takeCard();
			rounds.add(new Round(vira));
			getCurrentRound().setMao(this);
		}
	}

	public void getPlayersCards() {
		for (TrucoPlayer player : trucoMatch.getDefaultSequence().keySet()) {
			trucoMatch.getTrucoDeck().getPlayerCards(player);
		}
	}
	
	public void increaseMaoValue(TrucoPlayer player) {

		if (this.lastToIncreaseValue == null || this.getLastToIncreaseValue().getTeam() != player.getTeam()) {

			setLastToIncreaseValue(player);

			switch (this.maoValue) {

			case 1:
				this.maoValue = 3;
				break;

			case 3:
				this.maoValue = 6;
				break;

			case 6:
				this.maoValue = 9;
				break;

			case 9:
				this.maoValue = 12;
				break;

			}
		} else {
			// exception?
		}
	}
	
	public void increaseScore(TrucoTeam team) {
		Integer currentScore = maoScoreboard.get(team);
		maoScoreboard.replace(team, currentScore + 1);
	}
	
	public void findMaoWinner() {
		int aux = 0;
		int numberOfRoundsWon;
		TrucoTeam winnerTeam = null;
		boolean hasWinner = false;
		if(rounds.size() > 1) {
			for(TrucoTeam team : maoScoreboard.keySet()) {
				numberOfRoundsWon = maoScoreboard.get(team);
				if(numberOfRoundsWon > aux) {
					aux = numberOfRoundsWon;
					winnerTeam = team;
					hasWinner = true;
				}
				else if (numberOfRoundsWon == aux) {
					hasWinner = false;
				}
			}
			if(hasWinner) {
				maoWinner = winnerTeam;
				setMaoWinner(winnerTeam);
			}
		}
	}

}
