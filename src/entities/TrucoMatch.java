package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import exceptions.TrucoException;
import ui.TrucoInterface;

public class TrucoMatch {

	private TrucoDeck trucoDeck;
	private List<TrucoTeam> teams = new ArrayList<>();
	private List<Mao> maos = new ArrayList<>();
	private HashMap<TrucoPlayer, Integer> defaultSequence = new HashMap<>();
	private HashMap<TrucoTeam, Integer> scoreboard = new HashMap<>();
	private TrucoTeam winner;
	
	private TrucoInterface ti = new TrucoInterface(this);

	public TrucoMatch(List<TrucoTeam> teams) {
		this.trucoDeck = new TrucoDeck();
		this.teams = teams;
		for (TrucoTeam team : teams) {
			scoreboard.put(team, 0);
		}
		verifyTrucoMatchRequirements();
		organizeSequence();
	}

	public TrucoDeck getTrucoDeck() {
		return trucoDeck;
	}
	
	public void setTrucoDeck(TrucoDeck trucoDeck) {
		this.trucoDeck = trucoDeck;
	}

	public List<TrucoTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<TrucoTeam> teams) {
		this.teams = teams;
	}

	public List<Mao> getMaos() {
		return maos;
	}

	public HashMap<TrucoPlayer, Integer> getDefaultSequence() {
		return defaultSequence;
	}

	public HashMap<TrucoTeam, Integer> getScoreboard() {
		return scoreboard;
	}

	public TrucoTeam getWinner() {
		return winner;
	}

	public void setWinner(TrucoTeam winner) {
		this.winner = winner;
	}

	public Mao getCurrentMao() {
		if(maos.size() > 0) {
			return maos.get(maos.size() - 1);
		}
		throw new TrucoException("There isn't any mão on this match!");
	}

	public Mao getLastMao() {
		if(maos.size() > 1) {
			return maos.get(maos.size() - 2);
		}
		if(maos.size() == 1) {
			throw new TrucoException("There is just 01 mão on this match!");
		}
		throw new TrucoException("There isn't any mão on this match!");
	}

	public void setNewMao() {
		for(TrucoTeam team : teams) {
			for(TrucoPlayer player : team.getPlayers()) {
				player.cleanCards();
			}
		}
		trucoDeck.setDefaultDeck();
		trucoDeck.shuffle();
		maos.add(new Mao());
		getCurrentMao().setTrucoMatch(this);
		for(TrucoTeam team : teams) {
			getCurrentMao().getMaoScoreboard().put(team, 0);
		}
		getCurrentMao().getPlayersCards();
	}

	public Round getCurrenteRound() {
		return getCurrentMao().getCurrentRound();
	}

	public Round getLastRound() {

		if (getCurrentMao().getRounds().size() == 1 && maos.size() > 1) {
			return getLastMao().getCurrentRound();
		}
		return getCurrentMao().getLastRound();
	}
	
	public TrucoPlayer getCurrentPlayer() {
		return getCurrenteRound().getCurrentPlayer();
	}
	
	public void increaseScore(TrucoTeam team) {
		Integer currentScore = scoreboard.get(team);
		scoreboard.replace(team, currentScore + getCurrentMao().getMaoValue());
	}
	
	public void findWinner() {
		for(TrucoTeam team : scoreboard.keySet()) {
			if(scoreboard.get(team) >= 12) {
				winner = team;
			}
		}
	}
	
	private boolean canIncreaseMaoValue() {
		return getCurrentMao().getLastToIncreaseValue() == null ||
			getCurrentMao().getLastToIncreaseValue().getTeam() != getCurrentPlayer().getTeam();
	}
	
	public void chooseOption() {
		
		//passar o scanner como parametro para poder fecha-lo ao fim do programa??
		Scanner sc = new Scanner(System.in);
		char option;
		char confirmation;
		System.out.printf("Choose an option: play a card or increase current mão's value if possible."
				+ "\n->");
		option = sc.next().charAt(0);
		switch(option) {
		
		case 'a':
			System.out.printf("Hidden card? (y/n)\n->");
			confirmation = sc.next().charAt(0);
			if(confirmation == 'y') {
				getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 0, true);
			}
			else {
				getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 0, false);
			}
			break;
			
		case 'b':
			if(getCurrentPlayer().getCards()[1]!=null) {
				System.out.printf("Hidden card? (y/n)\n->");
				confirmation = sc.next().charAt(0);
				if(confirmation == 'y') {
					getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 1, true);
				}
				else {
					getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 1, false);
				}
			}
			else if(canIncreaseMaoValue()) {
				getCurrentMao().increaseMaoValue(getCurrentPlayer());
			}
			else {
				System.out.println("Invalid option!");
				chooseOption();
			}
			break;
			
		case 'c':
			if(getCurrentPlayer().getCards()[2]!=null) {
				System.out.printf("Hidden card? (y/n)\n->");
				confirmation = sc.next().charAt(0);
				if(confirmation == 'y') {
					getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 2, true);
				}
				else {
					getCurrenteRound().addPlayerCardOnTable(getCurrentPlayer(), 2, false);
				}
			}
			else if(canIncreaseMaoValue()) {
				getCurrentMao().increaseMaoValue(getCurrentPlayer());
			}
			else {
				System.out.println("Invalid option!");
				chooseOption();
			}
			break;
			
		case 'd':
			if(canIncreaseMaoValue()) {
				getCurrentMao().increaseMaoValue(getCurrentPlayer());
			}
			else {
				System.out.println("Invalid option!");
				chooseOption();
			}
			break;
			
		default:
			System.out.println("Invalid option!");
			chooseOption();
		}
		
	}

	// private method!
	private void organizeSequence() {
		int i = 0;
		int j = 0;
		while (i < teams.get(0).getPlayers().size()) {
			for (TrucoTeam team : teams) {
				defaultSequence.put(team.getPlayers().get(i), j);
				j++;
			}
			i++;
		}
	}
	
	private void verifyTrucoMatchRequirements() {
		int aux = 0;
		if(teams.size() < 2) {
			throw new TrucoException("Can't start Truco Match: insufficient number of teams.");
		}
		int numberOfPlayersPerTeam = teams.get(0).getPlayers().size();
		for(TrucoTeam team : teams) {
			if(team.getPlayers().size() == numberOfPlayersPerTeam) {
				aux++;
			}
		}
		if(aux != teams.size()) {
			throw new TrucoException("Can't start Truco Match: all teams must have "
					+ "the same number of players.");
		}
	}
	
	//(!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
	public void startTrucoMatch() {
		ti.clearScreen();
		while(winner == null) {
			setNewMao();
			while(getCurrentMao().getRounds().size() < 3 && getCurrentMao().getMaoWinner() == null) {
				getCurrentMao().setNewRound();
				while(getCurrenteRound().getPlayersCardsOnTable().size() < 4) {
					ti.printScoreboard();
					ti.printMaoRoundHeader();
					ti.printTable();
					System.out.println("Current player: " + getCurrentPlayer()+", "+ getCurrentPlayer().getTeam() +"\n");
					ti.printPlayerOptions(this);
					chooseOption();
					ti.pressEnterKeyToContinue();
					ti.clearScreen();
					
				}
				getCurrenteRound().findRoundWinner();
				ti.printScoreboard();
				ti.printMaoRoundHeader();
				ti.printTable();
				System.out.println("Round winner: " + getCurrenteRound().getRoundWinner() +"\n");
				ti.pressEnterKeyToContinue();
				ti.clearScreen();
				getCurrentMao().findMaoWinner();
	
			}
			ti.printScoreboard();
			ti.printMaoRoundHeader();
			ti.printTable();
			System.out.println("Mão #" + getMaos().size() + " winner: "+ getCurrentMao().getMaoWinner());
			System.out.println();
			ti.pressEnterKeyToContinue();
			ti.clearScreen();
			findWinner();
		}
		ti.clearScreen();
		ti.printScoreboard();
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("Winner: " + winner);
		System.out.println("++++++++++++++++++++++++++++++++++");
	}

}
