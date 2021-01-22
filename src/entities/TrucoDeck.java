package entities;

import enums.CardTag;
import enums.Suit;

public class TrucoDeck extends Deck{
	

	public void getPlayerCards(TrucoPlayer player) {
		for(int i = 0; i<3; i++) {
			Card c = takeCard();
			TrucoCard tc = new TrucoCard(c.getCardTag(), c.getSuit(), c.relativeValue);
			player.addCard(tc);
		}
	}
	
	@Override
	public void setDefaultDeck() {
		
		cards.clear();
		
		cards.add(new Card(CardTag.FOUR, Suit.DIAMONDS, 1));
		cards.add(new Card(CardTag.FIVE, Suit.DIAMONDS, 2));
		cards.add(new Card(CardTag.SIX, Suit.DIAMONDS, 3));
		cards.add(new Card(CardTag.SEVEN, Suit.DIAMONDS, 4));
		cards.add(new Card(CardTag.QUEEN, Suit.DIAMONDS, 5));
		cards.add(new Card(CardTag.JACK, Suit.DIAMONDS, 6));
		cards.add(new Card(CardTag.KING, Suit.DIAMONDS, 7));
		cards.add(new Card(CardTag.ACE, Suit.DIAMONDS, 8));
		cards.add(new Card(CardTag.TWO, Suit.DIAMONDS, 9));
		cards.add(new Card(CardTag.THREE, Suit.DIAMONDS, 10));
		
		cards.add(new Card(CardTag.FOUR, Suit.SPADES, 1));
		cards.add(new Card(CardTag.FIVE, Suit.SPADES, 2));
		cards.add(new Card(CardTag.SIX, Suit.SPADES, 3));
		cards.add(new Card(CardTag.SEVEN, Suit.SPADES, 4));
		cards.add(new Card(CardTag.QUEEN, Suit.SPADES, 5));
		cards.add(new Card(CardTag.JACK, Suit.SPADES, 6));
		cards.add(new Card(CardTag.KING, Suit.SPADES, 7));
		cards.add(new Card(CardTag.ACE, Suit.SPADES, 8));
		cards.add(new Card(CardTag.TWO, Suit.SPADES, 9));
		cards.add(new Card(CardTag.THREE, Suit.SPADES, 10));
		
		cards.add(new Card(CardTag.FOUR, Suit.HEARTS, 1));
		cards.add(new Card(CardTag.FIVE, Suit.HEARTS, 2));
		cards.add(new Card(CardTag.SIX, Suit.HEARTS, 3));
		cards.add(new Card(CardTag.SEVEN, Suit.HEARTS, 4));
		cards.add(new Card(CardTag.QUEEN, Suit.HEARTS, 5));
		cards.add(new Card(CardTag.JACK, Suit.HEARTS, 6));
		cards.add(new Card(CardTag.KING, Suit.HEARTS, 7));
		cards.add(new Card(CardTag.ACE, Suit.HEARTS, 8));
		cards.add(new Card(CardTag.TWO, Suit.HEARTS, 9));
		cards.add(new Card(CardTag.THREE, Suit.HEARTS, 10));
		
		cards.add(new Card(CardTag.FOUR, Suit.CLUBS, 1));
		cards.add(new Card(CardTag.FIVE, Suit.CLUBS, 2));
		cards.add(new Card(CardTag.SIX, Suit.CLUBS, 3));
		cards.add(new Card(CardTag.SEVEN, Suit.CLUBS, 4));
		cards.add(new Card(CardTag.QUEEN, Suit.CLUBS, 5));
		cards.add(new Card(CardTag.JACK, Suit.CLUBS, 6));
		cards.add(new Card(CardTag.KING, Suit.CLUBS, 7));
		cards.add(new Card(CardTag.ACE, Suit.CLUBS, 8));
		cards.add(new Card(CardTag.TWO, Suit.CLUBS, 9));
		cards.add(new Card(CardTag.THREE, Suit.CLUBS, 10));
		
	}
	
}
