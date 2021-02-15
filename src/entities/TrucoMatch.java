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
	private Scanner sc = new Scanner(System.in);

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
	
	public TrucoTeam getCurrentOpponentTeam() {
		TrucoTeam opponentTeam = null;
		
		for(TrucoTeam team : teams) {
			if(team != getCurrentPlayer().getTeam()) {
				opponentTeam = team;
			}
		}
		
		return opponentTeam;
	}
	
	private boolean canIncreaseMaoValue() {
		return getCurrentMao().getLastToIncreaseValue() == null ||
			getCurrentMao().getLastToIncreaseValue().getTeam() != getCurrentPlayer().getTeam();
	}
	
	private void increaseMaoValue() {
		
		System.out.println();
		
		TrucoTeam opponentTeam = null;
		char option;
		
		for(TrucoTeam team : teams) {
			if(team != getCurrentPlayer().getTeam()) {
				opponentTeam = team;
			}
		}
		
		if(opponentTeam != null) {
			System.out.printf(opponentTeam + ", do you agree increasing current mão's value? (y/n)\n->");
			option = sc.next().charAt(0);
			if(option == 'y') {
				getCurrentMao().increaseMaoValue(getCurrentPlayer());
			}
			else {
				getCurrentMao().setMaoWinner(getCurrentPlayer().getTeam());
			}
		}
		
	}
	
	public void chooseOption() {
		
		ti.printPlayerOptions(this);
		
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
				increaseMaoValue();
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
				increaseMaoValue();
			}
			else {
				System.out.println("Invalid option!");
				chooseOption();
			}
			break;
			
		case 'd':
			if(canIncreaseMaoValue()) {
				increaseMaoValue();
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

	public void closeScanner() {
		sc.close();
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
		if(teams.size() != 2) {
			throw new TrucoException("Can't start Truco Match: truco match must have 2 teams.");
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
				while(getCurrenteRound().getPlayersCardsOnTable().size() < 4
						&& getCurrentMao().getMaoWinner() == null) {
					ti.printScoreboard();
					ti.printMaoRoundHeader();
					ti.printTable();
					System.out.println("Current player: " + getCurrentPlayer()
						+ ", "+ getCurrentPlayer().getTeam() +"\n");
					chooseOption();
					ti.pressEnterKeyToContinue();
					ti.clearScreen();
					
				}
				if(getCurrentMao().getMaoWinner() == null) {
					getCurrenteRound().findRoundWinner();
				}
		
				ti.printScoreboard();
				ti.printMaoRoundHeader();
				ti.printTable();
				if(getCurrentMao().getMaoWinner() == null) {
					System.out.println("Round winner: " + getCurrenteRound().getRoundWinner() +"\n");
				}
				else {
					System.out.println(getCurrentOpponentTeam() + " gave up increasing mão's value!\n");
				}
				ti.pressEnterKeyToContinue();
				ti.clearScreen();
				if(getCurrentMao().getMaoWinner() == null) {
					getCurrentMao().findMaoWinner();
				}
	
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
		closeScanner();
		ti.clearScreen();
		ti.printScoreboard();
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("Winner: " + winner);
		System.out.println("++++++++++++++++++++++++++++++++++");
	}

}
