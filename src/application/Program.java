package application;

import java.util.ArrayList;
import java.util.List;

import entities.TrucoCard;
import entities.TrucoDeck;
import entities.TrucoMatch;
import entities.TrucoPlayer;
import entities.TrucoTeam;

public class Program {

	public static void main(String[] args) {

		TrucoDeck td = new TrucoDeck();
		td.shuffle();

		TrucoTeam team1 = new TrucoTeam(1, 3);
		team1.addPlayer(new TrucoPlayer("Player 11"));
		team1.addPlayer(new TrucoPlayer("Player 12"));
		// team1.addPlayer(new TrucoPlayer("Player 13"));

		TrucoTeam team2 = new TrucoTeam(2, 3);
		team2.addPlayer(new TrucoPlayer("Player 21"));
		team2.addPlayer(new TrucoPlayer("Player 22"));
		// team2.addPlayer(new TrucoPlayer("Player 23"));

		TrucoTeam team3 = new TrucoTeam(3, 3);
		team3.addPlayer(new TrucoPlayer("Player 31"));
		team3.addPlayer(new TrucoPlayer("Player 32"));
		// team3.addPlayer(new TrucoPlayer("Player 33"));

		List<TrucoTeam> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);
		// teams.add(team3);

		for (TrucoTeam team : teams) {
			for (TrucoPlayer player : team.getPlayers()) {
				td.getPlayerCards(player);
			}
		}
		TrucoMatch tm = new TrucoMatch(teams);
		boolean hasWinner = false;
		TrucoTeam winnerTeam = null;
		int i = 1;
		while (!hasWinner) {
			if (i == 1) {
				System.out.println("Mão: #" + tm.getMaos().size());
				System.out.println("Round " + tm.getCurrentMao().getRounds().size());
				tm.getCurrenteRound().printPlayersSequence();
				for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
					System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
					for (TrucoCard card : player.getCards()) {
						if (card != null) {
							System.out.print(card + " ");
						}
					}
					tm.getCurrenteRound().addPlayerCardOnTable(player, 0);
					System.out.println();
				}
				tm.getCurrenteRound().findRoundWinner();
				System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
				System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
				if (!tm.getCurrenteRound().isTiedRound()) {
					System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
				} else {
					System.out.println("Tied round!");
				}
				System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
				tm.getCurrentMao().setNewRound();
				System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());
				tm.getCurrenteRound().printPlayersSequence();
				for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
					System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
					for (TrucoCard card : player.getCards()) {
						if (card != null) {
							System.out.print(card + " ");
						}
					}
					tm.getCurrenteRound().addPlayerCardOnTable(player, 1);
					System.out.println();
				}
				tm.getCurrenteRound().findRoundWinner();
				System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
				System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
				if (!tm.getCurrenteRound().isTiedRound()) {
					System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
				} else {
					System.out.println("Tied round!");
				}
				System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
				tm.getCurrentMao().findMaoWinner();

				if (tm.getCurrentMao().getMaoWinner() != null) {
					System.out.println();
					System.out.println("Mão Scoreboard: " + tm.getCurrentMao().getMaoScoreboard());
					System.out.println("Truco Match Scoreboard: " + tm.getScoreboard());
				} else {
					tm.getCurrentMao().setNewRound();
					System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());
					tm.getCurrenteRound().printPlayersSequence();
					for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
						System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
						for (TrucoCard card : player.getCards()) {
							if (card != null) {
								System.out.print(card + " ");
							}
						}
						tm.getCurrenteRound().addPlayerCardOnTable(player, 2);
						System.out.println();
					}
					tm.getCurrenteRound().findRoundWinner();
					System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
					System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
					if (!tm.getCurrenteRound().isTiedRound()) {
						System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
					} else {
						System.out.println("Tied round!");
					}
					System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
					System.out.println();
					System.out.println("Mão Scoreboard: " + tm.getCurrentMao().getMaoScoreboard());
					tm.getCurrentMao().findMaoWinner();
					System.out.println("Truco Match Scoreboard: " + tm.getScoreboard());
				}
				System.out.println("***************************************************************\n");
				i = 2;
			}
			else {
				tm.setNewMao();
				System.out.println("Mão: #" + tm.getMaos().size());
				System.out.println("Round " + tm.getCurrentMao().getRounds().size());
				tm.getCurrenteRound().printPlayersSequence();
				for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
					System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
					for (TrucoCard card : player.getCards()) {
						if (card != null) {
							System.out.print(card + " ");
						}
					}
					tm.getCurrenteRound().addPlayerCardOnTable(player, 0);
					System.out.println();
				}
				tm.getCurrenteRound().findRoundWinner();
				System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
				System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
				if (!tm.getCurrenteRound().isTiedRound()) {
					System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
				} else {
					System.out.println("Tied round!");
				}
				System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
				tm.getCurrentMao().setNewRound();
				System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());
				tm.getCurrenteRound().printPlayersSequence();
				for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
					System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
					for (TrucoCard card : player.getCards()) {
						if (card != null) {
							System.out.print(card + " ");
						}
					}
					tm.getCurrenteRound().addPlayerCardOnTable(player, 1);
					System.out.println();
				}
				tm.getCurrenteRound().findRoundWinner();
				System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
				System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
				if (!tm.getCurrenteRound().isTiedRound()) {
					System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
				} else {
					System.out.println("Tied round!");
				}
				System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
				tm.getCurrentMao().findMaoWinner();
				if (tm.getCurrentMao().getMaoWinner() != null) {
					System.out.println();
					System.out.println("Mão Scoreboard: " + tm.getCurrentMao().getMaoScoreboard());
					System.out.println("Truco Match Scoreboard: " + tm.getScoreboard());
				} else {
					tm.getCurrentMao().setNewRound();
					System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());
					tm.getCurrenteRound().printPlayersSequence();
					for (TrucoPlayer player : tm.getCurrenteRound().getOrdenedPlayers()) {
						System.out.print(player + ", " + player.getTeam() + "," + " cards: ");
						for (TrucoCard card : player.getCards()) {
							if (card != null) {
								System.out.print(card + " ");
							}
						}
						tm.getCurrenteRound().addPlayerCardOnTable(player, 2);
						System.out.println();
					}
					tm.getCurrenteRound().findRoundWinner();
					System.out.println("\nVira: " + tm.getCurrenteRound().getVira());
					System.out.println("Cards on table: " + tm.getCurrenteRound().getPlayersCardsOnTable());
					if (!tm.getCurrenteRound().isTiedRound()) {
						System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());
					} else {
						System.out.println("Tied round!");
					}
					System.out.println("Number of cards remaining on Deck: " + tm.getTrucoDeck().deckSize());
					System.out.println();
					System.out.println("Mão Scoreboard: " + tm.getCurrentMao().getMaoScoreboard());
					tm.getCurrentMao().findMaoWinner();
					System.out.println("Truco Match Scoreboard: " + tm.getScoreboard());
				}
				System.out.println("***************************************************************\n");
			}
			for (TrucoTeam team : tm.getTeams()) {
				if (tm.getScoreboard().get(team) == 12) {
					hasWinner = true;
					winnerTeam = team;
				}
			}
			if (hasWinner) {
				System.out.println("Match Winner: " + winnerTeam);
			}
		}

	}

}
