//Joanne Wang
//creates the game

import java.util.ArrayList;
import java.util.Scanner;
public class Game {

	Scanner scan=new Scanner(System.in);

	private Player p;
	private Deck cards;
	public String type;
	double token;
	int points;
	int win;
	boolean royalFlush, straightFlush, foK, fullHouse, flush,
	straight, toK, twoPairs, onePair;


	public Game(String[] testHand){

		p=new Player();
		cards=new Deck();
		type="";
		token=0;
		points=0;
		win=0;


		royalFlush=false;
		straightFlush=false;
		foK=false;
		fullHouse=false;
		flush=false;
		straight=false;
		toK=false;
		twoPairs=false;
		onePair=false;


		for (int i=0; i<testHand.length;i++)
		{
			Card c=new Card(0,0);
			int num=0;
			for (int j=1; j<testHand[i].length();j++)
			{
				num+=testHand[i].charAt(j);
			}
			if (num>=49&&num<=57)
			{
				num-=48;
			}
			else
				num-=87;

			if (testHand[i].charAt(0)=='d')
			{
				c.setSuit(1);
				c.setRank(num);
				p.addCard(c);
			}
			if (testHand[i].charAt(0)=='h')
			{
				c.setSuit(2);
				c.setRank(num);
				p.addCard(c);
			}
			if (testHand[i].charAt(0)=='s')
			{
				c.setSuit(3);
				c.setRank(num);
				p.addCard(c);
			}
			if (testHand[i].charAt(0)=='c')
			{
				c.setSuit(4);
				c.setRank(num);
				p.addCard(c);
			}

		}

	}

	public Game(){

		p=new Player();
		cards=new Deck();
		type="";
		token=0;
		points=0;
		win=0;


		royalFlush=false;
		straightFlush=false;
		foK=false;
		fullHouse=false;
		flush=false;
		straight=false;
		toK=false;
		twoPairs=false;
		onePair=false;

		for (int i=0;i<5;i++)
		{
			p.addCard(cards.deal());
		}

	}

	public void play(){
		
		// this method plays the game	
		int change=0;
		int thisCard=0;
		boolean again=true;

		String yesNo="";
		cards.shuffle();
		System.out.println("Hello! Welcome to the game of Poker");


		while(again) 
		{
			win=0;
			while (token<=0) 
			{
				System.out.println("Currently, you have "+p.getBankroll()+" tokens.");
				System.out.println("How many tokens would you like to bet? (between 1-5)");
				token=scan.nextInt();
				if (token<=0)
				{
					System.out.println("Sorry have to bet at least 1 token to play.");
				}
				else if(token>5)
				{
					System.out.println("Token has to be less than 5");
					token=0;
				}
				else if (token>p.getBankroll())
				{
					System.out.println("You do not have enough tokens to bet that amount.");
					token=0;
				}
			}
			p.bets(token);


			System.out.println("Your cards are:");
			System.out.println(p.toString());
			System.out.println("That is a: "+ this.checkHand(p.pCards()));
			System.out.println("How many cards would you like to exchange?");
			change=scan.nextInt();

			if (change!=0)
			{
				for (int i=0;i <change;i++)
				{
					System.out.println("Which card would you like to exchange? It cannot be one that "
							+ "has already been exchanged. (1,2,3,4,5)");
					thisCard=scan.nextInt()-1;
					p.removeCard(thisCard);
					p.addCard(thisCard,cards.deal());

				}

				System.out.println("Your cards are:");
				System.out.println(p.toString());
				System.out.println("That is a: "+ this.checkHand(p.pCards()));
			}

			win=this.handValue();
			p.winnings(win);
			System.out.println("You have won "+(int)(token*win)+" tokens!");
			System.out.println("Currently, you have "+p.getBankroll()+" tokens.");
			System.out.println("Do you want to play again?");
			yesNo=scan.next();
			yesNo.toLowerCase();
			if(yesNo.equals("no"))
			{
				again=false;
				System.out.println("See you next time!");
			}
			else if (p.getBankroll()<=0)
			{
				System.out.println("Sorry you have no tokens left");
				System.out.println("See you next time!");
				again=false;
			}
			else
			{
				p.removeCards();

				for (int i=0;i<5;i++)
				{
					p.addCard(cards.deal());

				}
				token=0;
				win=0;
			}
		}

	}


	public String checkHand(ArrayList<Card> hand){
		// this method takes in an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String

		royalFlush=false;
		straightFlush=false;
		foK=false;
		fullHouse=false;
		flush=false;
		straight=false;
		toK=false;
		twoPairs=false;
		onePair=false;
		ArrayList<Card> newHand=new ArrayList<Card>();


		//sorts the cards in order
		for (int i=0; i<hand.size();i++)
		{
			newHand.add(hand.get(i));
		}
		p.sortCards(newHand);

		//counts how many adjacent cards
		int adjCount=0;
		for(int i=0;i<4;i++)
		{
			if (newHand.get(i).compareToCount(newHand.get(i+1))==1)
			{
				adjCount++;
			}
		}

		//counts how many equivalent sets
		int equalCount=0;
		for (int i=0;i<4;i++)
		{
			if (newHand.get(i).compareToCount(newHand.get(i+1))==0)
			{
				equalCount++;
			}
		}


		int rFlush=0;
		int sFlush=0;
		int flushcount=0;


		for (int i=1;i<5;i++)
		{
			if (newHand.get(0).compareSuit(newHand.get(i))==0)
			{
				rFlush++;
			}
			if (newHand.get(0).compareSuit(newHand.get(i))==0)
			{
				sFlush++;
			}
			if (newHand.get(0).compareSuit(newHand.get(i))==0)
			{
				flushcount++;
			}
		}

		//checks if full house is true
		if (newHand.get(0).compareToCount(newHand.get(1))==0&&
				newHand.get(0).compareToCount(newHand.get(2))==0
				&&newHand.get(3).compareToCount(newHand.get(4))==0
				||newHand.get(0).compareToCount(newHand.get(1))==0&&
				newHand.get(2).compareToCount(newHand.get(3))==0&&
				newHand.get(2).compareToCount(newHand.get(4))==0)
		{
			fullHouse=true;
		}

		//checks if two pairs is true
		if (newHand.get(0).compareToCount(newHand.get(1))==0&&
				newHand.get(2).compareToCount(newHand.get(3))==0
				||newHand.get(1).compareToCount(newHand.get(2))==0&&
				newHand.get(3).compareToCount(newHand.get(4))==0
				||newHand.get(0).compareToCount(newHand.get(1))==0&&
				newHand.get(3).compareToCount(newHand.get(4))==0)
		{
			twoPairs=true;
		}

		//royal flush
		//System.out.println("wanted"+fHouse);
		if (rFlush==4&&newHand.get(0).getRank()==1&& newHand.get(1).getRank()==10&&
				newHand.get(2).getRank()==11&&newHand.get(3).getRank()==12&&
				newHand.get(4).getRank()==13)
		{
			royalFlush=true;
			type="Royal Flush!";
		}

		//straight flush
		else if (sFlush==4&&adjCount==4)
		{
			straightFlush=true;
			type="Straight Flush!";
		}

		//full house
		else if (fullHouse)
		{
			type="Full House!";
		}

		//four of kind
		else if (equalCount==3)
		{
			foK=true;
			type="Four of a Kind!";
		}

		//two pairs
		else if (twoPairs)
		{

			type="Two Pairs!";
		}

		//flush
		else if (flushcount==4)
		{
			flush=true;
			type="Flush!";
		}

		//straight
		else if (newHand.get(0).getRank()==1&& newHand.get(1).getRank()==10&&newHand.get(2).getRank()==11
				&&newHand.get(3).getRank()==12&&newHand.get(4).getRank()==13&&sFlush!=4)
		{
			straight=true;
			type="Straight!";
		}
		else if (adjCount==4)
		{
			straight=true;
			type="Straight!";
		}

		//three of kind
		else if (equalCount==2)
		{
			toK=true;
			type="Three of a Kind!";
		}

		//one pair
		else if (equalCount==1)
		{
			onePair=true;
			type="One Pair!";
		}

		//no pair
		else
		{
			type="No Pair...";
		}

		equalCount=0;
		return type;
	}

	private int handValue()
	{
		points=0;

		if (royalFlush==true)
		{
			points=250;
		}
		else if (straightFlush==true)
		{
			points=50;
		}
		else if (foK==true)
		{
			points=25;
		}
		else if (fullHouse==true)
		{
			points=6;
		}
		else if (flush==true)
		{
			points=5;
		}
		else if (straight==true)
		{
			points=4;
		}
		else if (toK==true)
		{
			points=3;
		}
		else if (twoPairs==true)
		{
			points=2;
		}
		else if (onePair==true)
		{
			points=1;
		}
		return points;
	}

}


