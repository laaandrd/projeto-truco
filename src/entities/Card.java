package entities;

import enums.Suit;

public class Card{

	private String tag;
	private Suit suit;
	private int relativeValue;

	public Card(String tag, Suit suit, int relativeValue) {
		this.tag = tag;
		this.suit = suit;
		this.relativeValue = relativeValue;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
				tag +
				" " +
				suit+
				"]";
				
	}
	
}
