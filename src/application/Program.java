package application;

import java.util.ArrayList;
import java.util.List;

import entities.Round;
import entities.TrucoDeck;
import entities.TrucoPlayer;
import entities.TrucoTeam;

public class Program {

	public static void main(String[] args) {
		
		TrucoDeck td = new TrucoDeck();
		td.shuffle();
		
		TrucoTeam team1 = new TrucoTeam(1);
		TrucoTeam team2 = new TrucoTeam(2);
		
		team1.addPlayer(new TrucoPlayer("Luana"));
		team1.addPlayer(new TrucoPlayer("Carolina"));
		
		team2.addPlayer(new TrucoPlayer("Fabi"));
		team2.addPlayer(new TrucoPlayer("Cris"));
		
		for(TrucoPlayer p : team1.getPlayers()) {
			td.getPlayerCards(p);
		}
		
		for(TrucoPlayer p : team2.getPlayers()) {
			td.getPlayerCards(p);
		}
		
		List<TrucoTeam> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);
		
		for(TrucoPlayer player : team1.getPlayers()) {
			System.out.println(player);
		}
		for(TrucoPlayer player : team2.getPlayers()) {
			System.out.println(player);
		}
		
		Round round = new Round(null);
		
		round.setTeams(teams);
		
		round.organizeSequence(null);
		
		System.out.println("\nPlayers sequence: ");
		
		round.printPlayersSequence();
		
		
	}

}
