package enums;

public enum TrucoDeckIncreasingSequence {

	FOUR(1),
	FIVE (2),
	SIX(3),
	SEVEN(4),
	QUEEN(5),
	JACK(6),
	KING(7),
	ACE(8),
	TWO(9),
	THREE(10);
	
	private int defaultSequence;
	
	TrucoDeckIncreasingSequence (int defaultSequence){
		this.defaultSequence = defaultSequence;
	}
	
	public int getDeafaultSequence() {
		return defaultSequence;
	}
	
	public static TrucoDeckIncreasingSequence[] trucoCardsTags = new TrucoDeckIncreasingSequence[]{
           FOUR, FIVE, SIX, SEVEN, QUEEN, JACK, KING, ACE, TWO, THREE
        };
	

}
