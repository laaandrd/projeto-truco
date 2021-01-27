package ui;

import entities.Round;
import entities.TrucoCard;

public class TrucoInterface {

	public void printRoundInfo(Round round) {
		System.out.println("--------------------------------------------------------");
		System.out.println("Round #" + round.getMao().getRounds().size() + ":\n");

		System.out.println("Vira: " + round.getVira() + "\n");

		System.out.println("Cards on the table: ");

		for (int i = 0; i < round.getPlayersCardsOnTable().size(); i++) {
			System.out.println(round.getPlayersCardsOnTable().get(i) + " <- " + round.getRoundSequence().get(i));
		}

		if (round.getPlayersCardsOnTable().size() != round.getOrdenedPlayers().size()) {
			System.out.println(
					"\nCurrent player: " + round.getRoundSequence().get(round.getPlayersCardsOnTable().size()));
			System.out.println("Your cards: ");
			for (TrucoCard card : round.getRoundSequence().get(round.getPlayersCardsOnTable().size()).getCards()) {
				if (card != null) {
					System.out.println(card);
				}
			}
		}
		else {
			if (round.getRoundWinner() == null) {
				round.findRoundWinner();
			}
			if (!round.isTiedRound()) {
				System.out.println("\nRound winner: " + round.getRoundWinner());
			} else {
				System.out.println("\nTied round!");
			}
			
			System.out.println("--------------------------------------------------------");
			pressEnterKeyToContinue();
			clearScreen();
		}

	}
	
	//https://stackoverflow.com/questions/19870467/how-do-i-get-press-any-key-to-continue-to-work-in-my-java-code
	private void pressEnterKeyToContinue()
	 { 
	        System.out.println("Press ENTER to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	
	//https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}
