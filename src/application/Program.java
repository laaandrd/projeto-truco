package application;

import java.util.ArrayList;
import java.util.List;

import entities.TrucoMatch;
import entities.TrucoPlayer;
import entities.TrucoTeam;

public class Program {

	public static void main(String[] args) {

		TrucoTeam team1 = new TrucoTeam(1, 3);
		team1.addPlayer(new TrucoPlayer("Player 11"));
		team1.addPlayer(new TrucoPlayer("Player 12"));
		
		team1.getPlayers().get(0).setPassword("aaa1");
		team1.getPlayers().get(1).setPassword("aaa2");

		TrucoTeam team2 = new TrucoTeam(2, 3);
		team2.addPlayer(new TrucoPlayer("Player 21"));
		team2.addPlayer(new TrucoPlayer("Player 22"));

		team2.getPlayers().get(0).setPassword("bbb1");
		team2.getPlayers().get(1).setPassword("bbb2");

		List<TrucoTeam> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);

		TrucoMatch tm = new TrucoMatch(teams);
		tm.startTrucoMatch();
		System.out.println("\nDONE!");
	}

}
