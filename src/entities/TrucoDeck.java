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
		
		cards.add(new TrucoCard(CardTag.FOUR, Suit.DIAMONDS, 1));
		cards.add(new TrucoCard(CardTag.FIVE, Suit.DIAMONDS, 2));
		cards.add(new TrucoCard(CardTag.SIX, Suit.DIAMONDS, 3));
		cards.add(new TrucoCard(CardTag.SEVEN, Suit.DIAMONDS, 4));
		cards.add(new TrucoCard(CardTag.QUEEN, Suit.DIAMONDS, 5));
		cards.add(new TrucoCard(CardTag.JACK, Suit.DIAMONDS, 6));
		cards.add(new TrucoCard(CardTag.KING, Suit.DIAMONDS, 7));
		cards.add(new TrucoCard(CardTag.ACE, Suit.DIAMONDS, 8));
		cards.add(new TrucoCard(CardTag.TWO, Suit.DIAMONDS, 9));
		cards.add(new TrucoCard(CardTag.THREE, Suit.DIAMONDS, 10));
		
		cards.add(new TrucoCard(CardTag.FOUR, Suit.SPADES, 1));
		cards.add(new TrucoCard(CardTag.FIVE, Suit.SPADES, 2));
		cards.add(new TrucoCard(CardTag.SIX, Suit.SPADES, 3));
		cards.add(new TrucoCard(CardTag.SEVEN, Suit.SPADES, 4));
		cards.add(new TrucoCard(CardTag.QUEEN, Suit.SPADES, 5));
		cards.add(new TrucoCard(CardTag.JACK, Suit.SPADES, 6));
		cards.add(new TrucoCard(CardTag.KING, Suit.SPADES, 7));
		cards.add(new TrucoCard(CardTag.ACE, Suit.SPADES, 8));
		cards.add(new TrucoCard(CardTag.TWO, Suit.SPADES, 9));
		cards.add(new TrucoCard(CardTag.THREE, Suit.SPADES, 10));
		
		cards.add(new TrucoCard(CardTag.FOUR, Suit.HEARTS, 1));
		cards.add(new TrucoCard(CardTag.FIVE, Suit.HEARTS, 2));
		cards.add(new TrucoCard(CardTag.SIX, Suit.HEARTS, 3));
		cards.add(new TrucoCard(CardTag.SEVEN, Suit.HEARTS, 4));
		cards.add(new TrucoCard(CardTag.QUEEN, Suit.HEARTS, 5));
		cards.add(new TrucoCard(CardTag.JACK, Suit.HEARTS, 6));
		cards.add(new TrucoCard(CardTag.KING, Suit.HEARTS, 7));
		cards.add(new TrucoCard(CardTag.ACE, Suit.HEARTS, 8));
		cards.add(new TrucoCard(CardTag.TWO, Suit.HEARTS, 9));
		cards.add(new TrucoCard(CardTag.THREE, Suit.HEARTS, 10));
		
		cards.add(new TrucoCard(CardTag.FOUR, Suit.CLUBS, 1));
		cards.add(new TrucoCard(CardTag.FIVE, Suit.CLUBS, 2));
		cards.add(new TrucoCard(CardTag.SIX, Suit.CLUBS, 3));
		cards.add(new TrucoCard(CardTag.SEVEN, Suit.CLUBS, 4));
		cards.add(new TrucoCard(CardTag.QUEEN, Suit.CLUBS, 5));
		cards.add(new TrucoCard(CardTag.JACK, Suit.CLUBS, 6));
		cards.add(new TrucoCard(CardTag.KING, Suit.CLUBS, 7));
		cards.add(new TrucoCard(CardTag.ACE, Suit.CLUBS, 8));
		cards.add(new TrucoCard(CardTag.TWO, Suit.CLUBS, 9));
		cards.add(new TrucoCard(CardTag.THREE, Suit.CLUBS, 10));
		
	}
	
}
