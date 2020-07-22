//Joanne Wang
//Creates the player

import java.util.ArrayList;
import java.util.Collections;
public class Player {


	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
	private double bet;
	private String handCards;


	public Player(){		
		// create a player here
		bankroll=25.0;
		hand=new ArrayList<Card>();
		bet=0;
		handCards="";
	}

	public void addCard(Card c){
		// add the card c to the player's hand
		hand.add(c);
	}

	public void addCard(int index, Card c) {
		hand.add(index, c);
	}

	public ArrayList<Card> pCards()
	{
		return hand;
	}

	public void removeCard(Card c){
		// remove the card c from the player's hand
		hand.remove(c);
	}

	public void removeCard (int index) {
		hand.remove(index);
	}

	public void bets(double amt){
		// player makes a bet
		bet=amt;
		bankroll-=bet;
	}

	public void winnings(double odds){
		//	adjust bankroll if player wins
		if (odds!=0)
		{
			bankroll+=(int)((odds*bet)+bet);
		}
	}


	public double getBankroll(){
		// return current balance of bankroll
		return bankroll;
	}

	public Card getCard(int i){
		return hand.get(i);
	}

	public String toString() {
		handCards="";
		for (int i=0;i<hand.size();i++)
		{
			handCards+=hand.get(i).toString()+" ";
		}
		return handCards;
	}

	public void removeCards() {
		int j=hand.size();
		for (int i=0;i<j;i++)
		{
			hand.remove(0);
		}
	}

	public void sortCards(ArrayList<Card> cards) {
		Collections.sort(cards);
	}


}

