package application;

import java.util.Arrays;
import java.util.List;

import entities.Card;
import entities.Deck;
import entities.TrucoCard;
import enums.Suit;

public class Program {

	public static void main(String[] args) {
		
		TrucoCard c1 = new TrucoCard("3", Suit.HEARTS, 10);
		c1.makeManilha();
		
		TrucoCard c2 = new TrucoCard("3", Suit.CLUBS, 10);
		c2.makeManilha();
		
		TrucoCard c3 = new TrucoCard("2", Suit.HEARTS, 9);
		
		TrucoCard c4 = new TrucoCard("2", Suit.DIAMONDS, 9);
		
		TrucoCard c5 = new TrucoCard("3", Suit.DIAMONDS, 10);
		c5.makeManilha();
		
		List<TrucoCard> cartas = Arrays.asList(c1, c2, c3, c4, c5);
		
		for(TrucoCard c: cartas) {
			if(c.isManilha()) {
				System.out.println(c + " (Manilha) | Relative value: " + c.getRelativeValue());
			}
			else {
				System.out.println(c + " (Not a manilha) | Relative value: " + c.getRelativeValue());
			}
		}
		
		
	}

}
