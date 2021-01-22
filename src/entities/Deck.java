package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.CardTag;
import enums.Suit;

public class Deck {
	
	protected List<Card> cards = new ArrayList<>();
	
	public Deck() {
		this.setDefaultDeck();
	}

	public List<Card> getCards() {
		return cards;
	}

	public Card takeCard() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}
	
	public int deckSize() {
		return cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void setDefaultDeck() {
	
		cards.clear();
		
		cards.add(new Card(CardTag.ACE, Suit.DIAMONDS, 1));
		cards.add(new Card(CardTag.TWO, Suit.DIAMONDS, 2));
		cards.add(new Card(CardTag.THREE, Suit.DIAMONDS, 3));
		cards.add(new Card(CardTag.FOUR, Suit.DIAMONDS, 4));
		cards.add(new Card(CardTag.FIVE, Suit.DIAMONDS, 5));
		cards.add(new Card(CardTag.SIX, Suit.DIAMONDS, 6));
		cards.add(new Card(CardTag.SEVEN, Suit.DIAMONDS, 7));
		cards.add(new Card(CardTag.EIGHT, Suit.DIAMONDS, 8));
		cards.add(new Card(CardTag.NINE, Suit.DIAMONDS, 9));
		cards.add(new Card(CardTag.TEN, Suit.DIAMONDS, 10));
		cards.add(new Card(CardTag.JACK, Suit.DIAMONDS, 11));
		cards.add(new Card(CardTag.QUEEN, Suit.DIAMONDS, 12));
		cards.add(new Card(CardTag.KING, Suit.DIAMONDS, 13));

		cards.add(new Card(CardTag.ACE, Suit.SPADES, 1));
		cards.add(new Card(CardTag.TWO, Suit.SPADES, 2));
		cards.add(new Card(CardTag.THREE, Suit.SPADES, 3));
		cards.add(new Card(CardTag.FOUR, Suit.SPADES, 4));
		cards.add(new Card(CardTag.FIVE, Suit.SPADES, 5));
		cards.add(new Card(CardTag.SIX, Suit.SPADES, 6));
		cards.add(new Card(CardTag.SEVEN, Suit.SPADES, 7));
		cards.add(new Card(CardTag.EIGHT, Suit.SPADES, 8));
		cards.add(new Card(CardTag.NINE, Suit.SPADES, 9));
		cards.add(new Card(CardTag.TEN, Suit.SPADES, 10));
		cards.add(new Card(CardTag.JACK, Suit.SPADES, 11));
		cards.add(new Card(CardTag.QUEEN, Suit.SPADES, 12));
		cards.add(new Card(CardTag.KING, Suit.SPADES, 13));
		
		cards.add(new Card(CardTag.ACE, Suit.HEARTS, 1));
		cards.add(new Card(CardTag.TWO, Suit.HEARTS, 2));
		cards.add(new Card(CardTag.THREE, Suit.HEARTS, 3));
		cards.add(new Card(CardTag.FOUR, Suit.HEARTS, 4));
		cards.add(new Card(CardTag.FIVE, Suit.HEARTS, 5));
		cards.add(new Card(CardTag.SIX, Suit.HEARTS, 6));
		cards.add(new Card(CardTag.SEVEN, Suit.HEARTS, 7));
		cards.add(new Card(CardTag.EIGHT, Suit.HEARTS, 8));
		cards.add(new Card(CardTag.NINE, Suit.HEARTS, 9));
		cards.add(new Card(CardTag.TEN, Suit.HEARTS, 10));
		cards.add(new Card(CardTag.JACK, Suit.HEARTS, 11));
		cards.add(new Card(CardTag.QUEEN, Suit.HEARTS, 12));
		cards.add(new Card(CardTag.KING, Suit.HEARTS, 13));
		
		cards.add(new Card(CardTag.ACE, Suit.CLUBS, 1));
		cards.add(new Card(CardTag.TWO, Suit.CLUBS, 2));
		cards.add(new Card(CardTag.THREE, Suit.CLUBS, 3));
		cards.add(new Card(CardTag.FOUR, Suit.CLUBS, 4));
		cards.add(new Card(CardTag.FIVE, Suit.CLUBS, 5));
		cards.add(new Card(CardTag.SIX, Suit.CLUBS, 6));
		cards.add(new Card(CardTag.SEVEN, Suit.CLUBS, 7));
		cards.add(new Card(CardTag.EIGHT, Suit.CLUBS, 8));
		cards.add(new Card(CardTag.NINE, Suit.CLUBS, 9));
		cards.add(new Card(CardTag.TEN, Suit.CLUBS, 10));
		cards.add(new Card(CardTag.JACK, Suit.CLUBS, 11));
		cards.add(new Card(CardTag.QUEEN, Suit.CLUBS, 12));
		cards.add(new Card(CardTag.KING, Suit.CLUBS, 13));
	}
	
}
