package entities;

import enums.CardTag;
import enums.Suit;
import enums.TrucoDeckIncreasingSequence;

public class TrucoCard extends Card {
	
	public TrucoCard(CardTag cardTag, Suit suit) {
		super(cardTag, suit);
		this.relativeValue = this.getDefaultTrucoValue();
	}

	public TrucoCard(CardTag cardTag, Suit suit, int relativeValue) {
		super(cardTag, suit, relativeValue);
	}

	private boolean isVira;
	private boolean isManilha;
	//!
	private TrucoDeckIncreasingSequence [] trucoCardsTags = TrucoDeckIncreasingSequence.trucoCardsTags;

	@Override
	public int getRelativeValue() {
		if (isManilha) {
			return 11 * 10 + this.getSuitValue();
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
	
	//!
	public int getDefaultTrucoValue() {
		for(TrucoDeckIncreasingSequence trucoCardTag : trucoCardsTags) {
			if(trucoCardTag.toString().equals(this.getCardTag().toString())){
				return trucoCardTag.getDeafaultSequence();
			}
		}
		return -1;
	}
	
}
