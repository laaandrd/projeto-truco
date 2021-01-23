package application;

import java.util.ArrayList;
import java.util.List;

import entities.Mao;
import entities.TrucoCard;
import entities.TrucoDeck;
import entities.TrucoPlayer;
import entities.TrucoTeam;
import enums.CardTag;
import enums.Suit;
import enums.TrucoDeckIncreasingSequence;

public class Program {

	public static void main(String[] args) {
		
		TrucoCard c1 = new TrucoCard(CardTag.ACE, Suit.CLUBS);
		TrucoCard c2 = new TrucoCard(CardTag.ACE, Suit.DIAMONDS);
		System.out.println(c1 + " " + c2 + " is manilha: false");
		System.out.println("HashCode: "+ (c1.hashCode() == c2.hashCode()));
		
		c1.makeManilha();
		c2.makeManilha();
		
		System.out.println(c1+ " " + c2 + " is manilha: true");
		
		System.out.println("HashCode: "+ (c1.hashCode() == c2.hashCode()));
		
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
		
		for(TrucoTeam team : teams) {
			for(TrucoPlayer player : team.getPlayers()) {
				td.getPlayerCards(player);
			}
		}
		
		Mao mao = new Mao((TrucoCard)td.takeCard());
		
		mao.getCurrentRound().setTeams(teams);
		
		for(TrucoTeam team : mao.getCurrentRound().getTeams()) {
			for(TrucoPlayer player : team.getPlayers()) {
				mao.getCurrentRound().findManilhas(player);
			}
		}
		System.out.println("Round vira: " + mao.getCurrentRound().getVira());
		for(TrucoTeam team : mao.getCurrentRound().getTeams()) {
			for(TrucoPlayer player : team.getPlayers()) {
				System.out.println( player + ", Team #" + team.getId()+ ", cards: ");
				for(TrucoCard c : player.getCards()) {
					System.out.println(c + " " + c.getRelativeValue());
				}
			}
		}
		
		
	}

}
