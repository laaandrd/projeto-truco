package application;

import entities.Round;
import entities.TrucoCard;
import entities.TrucoDeck;
import entities.TrucoPlayer;
import enums.CardTag;
import enums.Suit;

public class Program {

	public static void main(String[] args) {
		
		TrucoDeck td = new TrucoDeck();
		td.shuffle();
		
		TrucoCard vira = new TrucoCard(CardTag.THREE, Suit.CLUBS);
		
		TrucoPlayer tp = new TrucoPlayer("Matheus");
		tp.addCard(new TrucoCard(CardTag.THREE, Suit.HEARTS));
		tp.addCard(new TrucoCard(CardTag.FOUR, Suit.CLUBS));
		tp.addCard(new TrucoCard(CardTag.FOUR, Suit.DIAMONDS));
		
		Round round = new Round(vira);
		
		round.findManilhas(tp);
		
		System.out.println("Vira: " + vira);
		
		for(TrucoCard c : tp.getCards()) {
			System.out.println(c + ", is manilha: " + c.isManilha() +", relative value: " + c.getRelativeValue());
		}
		
		System.out.println();
		
		TrucoCard vira2 = new TrucoCard(CardTag.SIX, Suit.CLUBS);
		Round round2 = new Round(vira2);
		
		TrucoPlayer tp2 = new TrucoPlayer("Mateus");
		tp2.addCard(new TrucoCard(CardTag.FIVE, Suit.HEARTS));
		tp2.addCard(new TrucoCard(CardTag.SEVEN, Suit.CLUBS));
		tp2.addCard(new TrucoCard(CardTag.SIX, Suit.DIAMONDS));
		
		round2.findManilhas(tp2);

		System.out.println("Vira: " + vira2);

		for (TrucoCard c : tp2.getCards()) {
			System.out.println(c + ", is manilha: " + c.isManilha() + ", relative value: " + c.getRelativeValue());
		}
		
	}

}
