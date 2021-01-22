package entities;

import enums.CardTag;
import enums.Suit;
import enums.TrucoDeckIncreasingSequence;

public class TrucoCard extends Card {

	public TrucoCard(CardTag cardTag, Suit suit, int relativeValue) {
		super(cardTag, suit, relativeValue);
	}

	private boolean isVira;
	private boolean isManilha;
	
	//may be replaced to a future "TrucoMatch class"
	private TrucoDeckIncreasingSequence [] trucoCardsTags = TrucoDeckIncreasingSequence.trucoCardsTags;

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
	
	//may be replaced to a future "TrucoMatch class"
	public int getDefaultTrucoValue() {
		for(TrucoDeckIncreasingSequence trucoCardTag : trucoCardsTags) {
			if(trucoCardTag.toString().equals(this.getCardTag().toString())){
				return 10 * trucoCardTag.getDeafaultSequence();
			}
		}
		return -1;
	}
	
}
