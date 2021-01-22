package application;

import entities.TrucoCard;
import enums.CardTag;
import enums.Suit;

public class Program {

	public static void main(String[] args) {
		
		TrucoCard tc1 = new TrucoCard(CardTag.KING, Suit.SPADES, 7);
		
		System.out.println(tc1 + "\nDefault truco value: " + ((TrucoCard) tc1).getDefaultTrucoValue());
		System.out.println("CardTag: " + tc1.getCardTag());
		System.out.println("Tag: " +tc1.getCardTag().getTag());
		System.out.println("Suit: "+ tc1.getSuit());
		System.out.println("SuitTag: " + tc1.getSuit().getTag());
	
		
	}

}
