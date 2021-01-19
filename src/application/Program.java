package application;

import java.util.ArrayList;
import java.util.List;

import entities.Card;
import entities.Deck;

public class Program {

	public static void main(String[] args) {
		
		Deck baralho = new Deck();
		List <Card> c1 = new ArrayList<>();
		
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		
		System.out.println(c1);
		
		baralho.setDefaultDeck();
		baralho.shuffle();
		c1.clear();
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		
		System.out.println(c1);

		baralho.setDefaultDeck();
		baralho.shuffle();
		c1.clear();
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		c1.add(baralho.takeCard());
		
		System.out.println(c1);
	}

}
