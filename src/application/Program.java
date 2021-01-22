package application;

import entities.Card;
import entities.TrucoCard;
import entities.TrucoDeck;
import entities.TrucoPlayer;
import entities.TrucoTeam;
import enums.CardTag;
import enums.Suit;

public class Program {

	public static void main(String[] args) {
		
		TrucoDeck td = new TrucoDeck();
		td.shuffle();
		TrucoPlayer tp1 = new TrucoPlayer("Player 01");
		TrucoPlayer tp2 = new TrucoPlayer("Player 02");
		TrucoTeam tt1 = new TrucoTeam(1425);
		
		tp1.joinTeam(tt1);
		tp2.joinTeam(tt1);
		
		td.getPlayerCards(tp1);
		td.getPlayerCards(tp2);
		
		for(TrucoCard c: tp1.getCards()) {
			System.out.println(c+ " is a "+ tp1.getName()+"'s card, relative value: "+c.getRelativeValue());
		}
		
		System.out.println();
		
		for(TrucoCard c: tp2.getCards()) {
			System.out.println(c+ " is a "+ tp2.getName()+"'s card, relative value: "+c.getRelativeValue());
		}
		
		System.out.println();
		
		for(TrucoPlayer tp : tt1.getPlayers()) {
			System.out.println(tp);
		}
		
		System.out.println();
		
		System.out.println(td.deckSize()+" cards remain on the deck.");
		
		System.out.println();
		
		System.out.println("CardTag: " + CardTag.FOUR);
		System.out.println("Tag:" + CardTag.FOUR.getTag());
		
	}

}
