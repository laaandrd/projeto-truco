package entities;

import enums.Suit;

public class TrucoDeck extends Deck{
	
	@Override
	public void setDefaultDeck() {
		
		cards.clear();
		
		cards.add(new Card("4", Suit.DIAMONDS, 1));
		cards.add(new Card("5", Suit.DIAMONDS, 2));
		cards.add(new Card("6", Suit.DIAMONDS, 3));
		cards.add(new Card("7", Suit.DIAMONDS, 4));
		cards.add(new Card("Q", Suit.DIAMONDS, 5));
		cards.add(new Card("J", Suit.DIAMONDS, 6));
		cards.add(new Card("K", Suit.DIAMONDS, 7));
		cards.add(new Card("A", Suit.DIAMONDS, 8));
		cards.add(new Card("2", Suit.DIAMONDS, 9));
		cards.add(new Card("3", Suit.DIAMONDS, 10));
		
		cards.add(new Card("4", Suit.SPADES, 1));
		cards.add(new Card("5", Suit.SPADES, 2));
		cards.add(new Card("6", Suit.SPADES, 3));
		cards.add(new Card("7", Suit.SPADES, 4));
		cards.add(new Card("Q", Suit.SPADES, 5));
		cards.add(new Card("J", Suit.SPADES, 6));
		cards.add(new Card("K", Suit.SPADES, 7));
		cards.add(new Card("A", Suit.SPADES, 8));
		cards.add(new Card("2", Suit.SPADES, 9));
		cards.add(new Card("3", Suit.SPADES, 10));
		
		cards.add(new Card("4", Suit.HEARTS, 1));
		cards.add(new Card("5", Suit.HEARTS, 2));
		cards.add(new Card("6", Suit.HEARTS, 3));
		cards.add(new Card("7", Suit.HEARTS, 4));
		cards.add(new Card("Q", Suit.HEARTS, 5));
		cards.add(new Card("J", Suit.HEARTS, 6));
		cards.add(new Card("K", Suit.HEARTS, 7));
		cards.add(new Card("A", Suit.HEARTS, 8));
		cards.add(new Card("2", Suit.HEARTS, 9));
		cards.add(new Card("3", Suit.HEARTS, 10));
		
		cards.add(new Card("4", Suit.CLUBS, 1));
		cards.add(new Card("5", Suit.CLUBS, 2));
		cards.add(new Card("6", Suit.CLUBS, 3));
		cards.add(new Card("7", Suit.CLUBS, 4));
		cards.add(new Card("Q", Suit.CLUBS, 5));
		cards.add(new Card("J", Suit.CLUBS, 6));
		cards.add(new Card("K", Suit.CLUBS, 7));
		cards.add(new Card("A", Suit.CLUBS, 8));
		cards.add(new Card("2", Suit.CLUBS, 9));
		cards.add(new Card("3", Suit.CLUBS, 10));
		
	}
	
}
