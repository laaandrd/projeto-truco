package entities;

import enums.Suit;

public class TrucoCard extends Card {

	private boolean isVira;
	private boolean isManilha;

	public TrucoCard(String tag, Suit suit, int relativeValue) {
		super(tag, suit, relativeValue);
	}

	@Override
	public int getRelativeValue() {
		if (isManilha) {
			return relativeValue * 10 + this.getSuitValue();
		}

		return this.relativeValue*10;
	}
	
	public boolean isVira() {
		return isVira;
	}
	
	public boolean isManilha() {
		return isManilha;
	}

	public void makeVira() {
		this.isVira = true;
	}

	public void makeManilha() {
		this.isManilha = true;
	}

	public int getSuitValue() {
		
		int value = 0;

		switch (this.getSuit()) {
		case DIAMONDS:
			value = 1;
			break;
		case SPADES:
			value = 2;
			break;
		case HEARTS:
			value = 3;
			break;
		case CLUBS:
			value = 4;
			break;
		}

		return value;
	}
}
