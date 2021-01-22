package enums;

public enum Suit {
	
	DIAMONDS("♦"),
	SPADES("♠"),
	HEARTS("♥"),
	CLUBS("♣");

	private String suitTag;

	Suit(String suitTag) {
		this.suitTag = suitTag;
	}

	public String getTag() {
		return suitTag;
	}
}
