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

		System.out.println("\n***************************************\n");

		TrucoDeck td = new TrucoDeck();
		td.shuffle();

		TrucoTeam team1 = new TrucoTeam(2426);
		team1.addPlayer(new TrucoPlayer("Player 435"));
		team1.addPlayer(new TrucoPlayer("Player 975"));

		TrucoTeam team2 = new TrucoTeam(9821);
		team2.addPlayer(new TrucoPlayer("Player 141"));
		team2.addPlayer(new TrucoPlayer("Player 632"));

		List<TrucoTeam> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);

		for (TrucoTeam team : teams) {
			for (TrucoPlayer player : team.getPlayers()) {
				td.getPlayerCards(player);
			}
		}

		TrucoMatch tm = new TrucoMatch(teams);
		
		System.out.println("Round " + tm.getCurrentMao().getRounds().size());

		tm.getCurrenteRound().organizeRoundSequence();
		tm.getCurrenteRound().printPlayersSequence();
		
		tm.getCurrenteRound().setRoundWinner(tm.getTeams().get(1).getPlayers()[0]);
		System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());

		tm.getCurrentMao().setNewRound((TrucoCard) tm.getTrucoDeck().takeCard());
		
		System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());

		tm.getCurrenteRound().organizeRoundSequence();
		tm.getCurrenteRound().printPlayersSequence();
		
		tm.getCurrenteRound().setRoundWinner(tm.getTeams().get(1).getPlayers()[1]);
		System.out.println("Winner: " + tm.getCurrenteRound().getRoundWinner());

		tm.getCurrentMao().setNewRound((TrucoCard) tm.getTrucoDeck().takeCard());
		
		System.out.println("\nRound " + tm.getCurrentMao().getRounds().size());

		tm.getCurrenteRound().organizeRoundSequence();
		tm.getCurrenteRound().printPlayersSequence();

	}

}
