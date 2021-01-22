package application;

import java.util.ArrayList;
import java.util.List;

import entities.Mao;
import entities.TrucoCard;
import entities.TrucoDeck;
import entities.TrucoPlayer;
import entities.TrucoTeam;

public class Program {

	public static void main(String[] args) {
		
		TrucoDeck td = new TrucoDeck();
		td.shuffle();
		
		TrucoTeam team1 = new TrucoTeam(2426);
		team1.addPlayer(new TrucoPlayer("Player 435"));
		team1.addPlayer(new TrucoPlayer("Player 975"));
		
		TrucoTeam team2 = new TrucoTeam(2426);
		team2.addPlayer(new TrucoPlayer("Player 141"));
		team2.addPlayer(new TrucoPlayer("Player 632"));
		
		List<TrucoTeam> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);
		
		for(TrucoTeam team : teams) {
			for(TrucoPlayer player : team.getPlayers()) {
				td.getPlayerCards(player);
			}
		}
		
		Mao mao = new Mao((TrucoCard)td.takeCard());
		
		mao.getCurrentRound().setTeams(teams);
		
		System.out.println("Initial mão value: " + mao.getMaoValue());
		(team1.getPlayers()[0]).increaseMaoValue(mao);
		System.out.println("Team 1 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team1.getPlayers()[1]).increaseMaoValue(mao);
		System.out.println("Team 1 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team2.getPlayers()[0]).increaseMaoValue(mao);
		System.out.println("Team 2 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team2.getPlayers()[1]).increaseMaoValue(mao);
		System.out.println("Team 2 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team1.getPlayers()[0]).increaseMaoValue(mao);
		System.out.println("Team 1 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team2.getPlayers()[0]).increaseMaoValue(mao);
		System.out.println("Team 2 player tried to increase mão value. New value: " + mao.getMaoValue());
		(team1.getPlayers()[1]).increaseMaoValue(mao);
		System.out.println("Team 1 player tried to increase mão value. New value: " + mao.getMaoValue());
		
		
	}

}
