//Joanne Wang
//Creates the card

public class Card implements Comparable<Card>{

	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank

	public Card(int s, int r){

		suit=s;
		rank=r;
	}

	public int compareTo(Card c){

		if (rank==c.rank)
			return 0;
		else if (rank>c.rank)
			return 1;
		else
			return -1;
	}
	
	public int compareSuit(Card c) {
		if (suit==c.suit)
			return 0;
		else return 1;
	}
	
	public int compareToCount(Card c) {
		if (rank==c.rank)
			return 0;
		else if (rank-c.rank==-1)
			return 1;
		else if (c.rank-rank==1)
			return -1;
		else return 2;
	}

	public String toString(){

		if(suit ==1)
		{
			return "diamond["+rank+"]";
		}
		else if(suit ==2)
		{
			return "heart["+rank+"]";
		}
		else if(suit ==3)
		{
			return "spade["+rank+"]";
		}
		else
		{
			return "club["+rank+"]";
		}

	}
	
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	public void setRank(int r) {
		rank=r;
	}
	public void setSuit(int s) {
		suit =s;
	}

}

