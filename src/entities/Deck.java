package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Suit;

public class Deck {
	
	List<Card> cards = new ArrayList<>();
	
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
		
		cards.add(new Card("A", Suit.DIAMONDS, 1));
		cards.add(new Card("2", Suit.DIAMONDS, 2));
		cards.add(new Card("3", Suit.DIAMONDS, 3));
		cards.add(new Card("4", Suit.DIAMONDS, 4));
		cards.add(new Card("5", Suit.DIAMONDS, 5));
		cards.add(new Card("6", Suit.DIAMONDS, 6));
		cards.add(new Card("7", Suit.DIAMONDS, 7));
		cards.add(new Card("8", Suit.DIAMONDS, 8));
		cards.add(new Card("9", Suit.DIAMONDS, 9));
		cards.add(new Card("10", Suit.DIAMONDS, 10));
		cards.add(new Card("J", Suit.DIAMONDS, 11));
		cards.add(new Card("Q", Suit.DIAMONDS, 12));
		cards.add(new Card("K", Suit.DIAMONDS, 13));

		cards.add(new Card("A", Suit.SPADES, 1));
		cards.add(new Card("2", Suit.SPADES, 2));
		cards.add(new Card("3", Suit.SPADES, 3));
		cards.add(new Card("4", Suit.SPADES, 4));
		cards.add(new Card("5", Suit.SPADES, 5));
		cards.add(new Card("6", Suit.SPADES, 6));
		cards.add(new Card("7", Suit.SPADES, 7));
		cards.add(new Card("8", Suit.SPADES, 8));
		cards.add(new Card("9", Suit.SPADES, 9));
		cards.add(new Card("10", Suit.SPADES, 10));
		cards.add(new Card("J", Suit.SPADES, 11));
		cards.add(new Card("Q", Suit.SPADES, 12));
		cards.add(new Card("K", Suit.SPADES, 13));
		
		cards.add(new Card("A", Suit.HEARTS, 1));
		cards.add(new Card("2", Suit.HEARTS, 2));
		cards.add(new Card("3", Suit.HEARTS, 3));
		cards.add(new Card("4", Suit.HEARTS, 4));
		cards.add(new Card("5", Suit.HEARTS, 5));
		cards.add(new Card("6", Suit.HEARTS, 6));
		cards.add(new Card("7", Suit.HEARTS, 7));
		cards.add(new Card("8", Suit.HEARTS, 8));
		cards.add(new Card("9", Suit.HEARTS, 9));
		cards.add(new Card("10", Suit.HEARTS, 10));
		cards.add(new Card("J", Suit.HEARTS, 11));
		cards.add(new Card("Q", Suit.HEARTS, 12));
		cards.add(new Card("K", Suit.HEARTS, 13));
		
		cards.add(new Card("A", Suit.CLUBS, 1));
		cards.add(new Card("2", Suit.CLUBS, 2));
		cards.add(new Card("3", Suit.CLUBS, 3));
		cards.add(new Card("4", Suit.CLUBS, 4));
		cards.add(new Card("5", Suit.CLUBS, 5));
		cards.add(new Card("6", Suit.CLUBS, 6));
		cards.add(new Card("7", Suit.CLUBS, 7));
		cards.add(new Card("8", Suit.CLUBS, 8));
		cards.add(new Card("9", Suit.CLUBS, 9));
		cards.add(new Card("10", Suit.CLUBS, 10));
		cards.add(new Card("J", Suit.CLUBS, 11));
		cards.add(new Card("Q", Suit.CLUBS, 12));
		cards.add(new Card("K", Suit.CLUBS, 13));
	}
	
}
