package entities;

public class TrucoPlayer {

	private String name;
	private TrucoTeam team;
	private TrucoCard[] cards = new TrucoCard[3];
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addCard(TrucoCard card) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = card;
				i = cards.length;
			}
		}
	}
	
	public void removeCard(int cardIndex) {
		cards [cardIndex] = null;
	}
	
	public void cleanCards() {
		cards [0] = null;
		cards [1] = null;
		cards [2] = null;
	} 
	
	public TrucoCard playCard(int cardIndex) {
		TrucoCard card = cards [cardIndex];
		removeCard(cardIndex);
		
		for(int i = 0; i < cards.length - 1; i++) {
			if(cards [i] == null) {
				cards [i] = cards [i + 1];
				cards [i + 1] = null;
			}
		}
		
		return card;
	}
	
	public TrucoCard playHiddenCard(int cardIndex) {
		TrucoCard card = cards [cardIndex];
		card.makeHiddenCard();
		removeCard(cardIndex);
		
		for(int i = 0; i < cards.length - 1; i++) {
			if(cards [i] == null) {
				cards [i] = cards [i + 1];
				cards [i + 1] = null;
			}
		}
		
		return card;
	}
	
	public void increaseMaoValue(Mao mao) {
		mao.increaseMaoValue(this);
	}
	
	public int numberOfCards() {
		int i = 0;
		for(TrucoCard card : cards) {
			if(card != null) {
				i++;
			}
		}
		return i;
	}

	public String toString() {
		return this.name;
	}

}
