package entities;

public class TrucoPlayer {

	private String name;
	private TrucoTeam team;
	private TrucoCard[] cards = new TrucoCard[3];

	public TrucoPlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrucoTeam getTeam() {
		return team;
	}

	public void setTeam(TrucoTeam team) {
		this.team = team;
	}

	public void joinTeam(TrucoTeam team) {
		this.team = team;
		team.addPlayer(this);
	}

	public TrucoCard[] getCards() {
		return cards;
	}

	public void addCard(TrucoCard card) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = card;
				i = cards.length;
			}
		}
	}

	// !
	public void increaseMaoValue(Mao mao) {
		mao.increaseMaoValue(this);
	}
	
	//!
	public TrucoCard playCard(TrucoCard card) {
		return card;
	}

	public String toString() {
		return this.name;
	}

}
