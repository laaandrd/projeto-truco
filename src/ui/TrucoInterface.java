package ui;

import java.util.HashMap;

import entities.Round;
import entities.TrucoMatch;
import entities.TrucoTeam;

public class TrucoInterface {
	
	private TrucoMatch trucoMatch;
	
	public TrucoInterface(TrucoMatch trucoMatch) {
		this.trucoMatch = trucoMatch;
	}

	public void printScoreboard() {
		System.out.println("SCOREBOARD:\n");
		for (TrucoTeam team : trucoMatch.getScoreboard().keySet()) {
			System.out.println(team + ": " + trucoMatch.getScoreboard().get(team) + " points");
		}
		System.out.println();
	}

	//bug(?)
	public void printPlayerOptions(TrucoMatch trucoMatch) {
		
		System.out.println("Your cards:\n");
		HashMap<Integer, Character> optionsBoard = new HashMap<>();
		int numberOfCards = trucoMatch.getCurrenteRound().getCurrentPlayer().numberOfCards();
		char option = 'a';

		for (int i = 0; i < numberOfCards; i++) {
			optionsBoard.put(i, option);
			option++;
		}
		if (trucoMatch.getCurrentMao().getLastToIncreaseValue() == null ||
			trucoMatch.getCurrentMao().getLastToIncreaseValue().getTeam() != trucoMatch.getCurrentPlayer().getTeam()) {
			optionsBoard.put(numberOfCards, option);
		}

		for (int i = 0; i <= numberOfCards; i++) {
			if (i != numberOfCards) {
				System.out.println(trucoMatch.getCurrentPlayer().getCards()[i] + " <- " + optionsBoard.get(i));
			}
			else {
				if(optionsBoard.get(i) != null) {
					System.out.println("\n[ASK FOR INCREASING MÃO VALUE] <- " + optionsBoard.get(i));
				}
			}
		}
		System.out.println();

	}
	
	public void printMaoRoundHeader() {
		int i = 1;
		System.out.println("**********************************");
		System.out.println("Mão #" + trucoMatch.getMaos().size() +
				" (+" + trucoMatch.getCurrentMao().getMaoValue()+ " to the winner team)\n");
		for(Round round : trucoMatch.getCurrentMao().getRounds()) {
			if(round.getRoundWinner() != null) {
				System.out.println("Round #" + i + " winner: " + round.getRoundWinner());
				i++;
			}
		}
		System.out.println("**********************************");
		System.out.println("Round #" + trucoMatch.getCurrentMao().getRounds().size()+"\n\n");
	}
	
	public void printTable() {
		System.out.println("----------------------------------");
		System.out.println("Vira: " + trucoMatch.getCurrenteRound().getVira() + "\n");

		System.out.println("Cards on the table: ");

		for (int i = 0; i < trucoMatch.getCurrenteRound().getPlayersCardsOnTable().size(); i++) {
			System.out.println(trucoMatch.getCurrenteRound().getPlayersCardsOnTable().get(i)
					+ " <- " + trucoMatch.getCurrenteRound().getRoundSequence().get(i));
		}
		System.out.println("----------------------------------");
		System.out.println();
	}

	// https://stackoverflow.com/questions/19870467/how-do-i-get-press-any-key-to-continue-to-work-in-my-java-code
	public void pressEnterKeyToContinue() {
		System.out.println("Press ENTER to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
