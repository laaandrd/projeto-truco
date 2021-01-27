package application;

import java.util.ArrayList;
import java.util.List;

import entities.TrucoDeck;
import entities.TrucoMatch;
import entities.TrucoPlayer;
import entities.TrucoTeam;
import ui.TrucoInterface;

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
		TrucoInterface ti = new TrucoInterface();
		TrucoMatch tm = new TrucoMatch(teams);
		tm.getCurrenteRound().addPlayerCardOnTable(tm.getCurrenteRound().getCurrentPlayer(), 0);
		tm.getCurrenteRound().addPlayerCardOnTable(tm.getCurrenteRound().getCurrentPlayer(), 0);
		tm.getCurrenteRound().addPlayerCardOnTable(tm.getCurrenteRound().getCurrentPlayer(), 0);
		tm.getCurrenteRound().addPlayerCardOnTable(tm.getCurrenteRound().getCurrentPlayer(), 0);
		ti.printRoundInfo(tm.getCurrenteRound());
		
		System.out.println("DONE!");
	}

}
