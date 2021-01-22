package entities;

import enums.CardTag;
import enums.Suit;

public class Card{

	private CardTag cardTag;
	private Suit suit;
	protected int relativeValue;

	public Card(CardTag cardTag, Suit suit, int relativeValue) {
		this.cardTag = cardTag;
		this.suit = suit;
		this.relativeValue = relativeValue;
	}

	public CardTag getCardTag() {
		return cardTag;
	}

	public void setCardTag(CardTag cardTag) {
		this.cardTag = cardTag;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getRelativeValue() {
		return relativeValue;
	}

	public void setRelativeValue(int relativeValue) {
		this.relativeValue = relativeValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + relativeValue;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (relativeValue != other.relativeValue)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[" +
				getCardTag().getTag() +
				" " +
				suit+
				"]";
				
	}
	
}
