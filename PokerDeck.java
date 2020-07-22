//Joanne Wang
//Creates the deck of cards

import java.lang.Math;
public class Deck {

	private Card[] cards=new Card[52];
	private int top=0; // the index of the top of the deck
	private Card topCard=new Card(0,0);
	public String word;


	public Deck()
	{
		// make a 52 card deck here
		int position=0;
		for (int s=1; s<=4;s++)
		{
			for (int r=1;r<=13;r++)
			{
				cards[position]=new Card(s,r);
				position++;
				
			}
			
		}
	}

	public void shuffle()
	{
		// shuffle the deck here

		int random;
		for (int i=0; i<52;i++)
		{
			random =(int)((Math.random()*51)+1);
			Card temp= new Card(cards[i].getSuit(),cards[i].getRank());
			cards[i].setSuit(cards[random].getSuit());
			cards[i].setRank(cards[random].getRank());
			cards[random].setSuit(temp.getSuit());
			cards[random].setRank(temp.getRank());
		}
	}

	public Card deal()
	{
		// deal the top card in the deck
		topCard=cards[top];
		top++;
		return topCard;
		
	}
	public String toString()
	{
		for (int i=0; i<52;i++)
		{
			word+=cards[i].toString()+" ";
		}
		return word;
	}


}

