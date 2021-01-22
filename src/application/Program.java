package application;

import entities.TrucoCard;
import entities.TrucoDeck;

public class Program {

	public static void main(String[] args) {
		
		TrucoDeck td = new TrucoDeck();
		td.shuffle();
		
		TrucoCard tc1 = (TrucoCard) td.takeCard();
		
		System.out.println(tc1 + "\nDefault truco value: " + ((TrucoCard) tc1).getDefaultTrucoValue());
		System.out.println("CardTag: " + tc1.getCardTag());
		System.out.println("Tag: " +tc1.getCardTag().getTag());
		System.out.println("Suit: "+ tc1.getSuit());
		System.out.println("SuitTag: " + tc1.getSuit().getTag());
	
		
	}

}
