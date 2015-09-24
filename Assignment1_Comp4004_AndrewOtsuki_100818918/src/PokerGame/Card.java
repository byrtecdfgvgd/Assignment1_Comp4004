package PokerGame;

public class Card {

	private int number, suit;
	
	//BASIC GET AND SET METHODS
	public void setNumber (int num)
	{
		number = num;
	}
	
	public int getNumber ()
	{
		return number;
	}
	
	public void setSuit (int sui)
	{
		suit = sui;
	}
	
	public int getSuit ()
	{
		return suit;
	}
	//END BASIC GET AND SET METHODS
	
	//SetCard: sets the card variables form string input
	public int setCard(String myCard)
	{
		return 0;
	}
	
	public String toString()
	{
		String myNumber, mySuit;
			
		if (suit == 1)	
		{
			mySuit = "Clubs";
		}
		else if (suit == 2)
		{
			mySuit = "Hearts";
		}
		else if (suit == 3)
		{
			mySuit = "Spades";
		}
		else
		{
			mySuit = "Diamonds";
		}
		
		
		if (number == 14)
		{
			myNumber = "Ace";
		}
		else if (number == 2)
		{
			myNumber = "Two";
		}
		else if (number == 3)
		{
			myNumber = "Three";
		}
		else if (number == 4)
		{
			myNumber = "Four";
		}
		else if (number == 5)
		{
			myNumber = "Five";
		}
		else if (number == 6)
		{
			myNumber = "Six";
		}
		else if (number == 7)
		{
			myNumber = "Seven";
		}
		else if (number == 8)
		{
			myNumber = "Eight";
		}
		else if (number == 9)
		{
			myNumber = "Nine";
		}
		else if (number == 10)
		{
			myNumber = "Ten";
		}
		else if (number == 11)
		{
			myNumber = "Jack";
		}
		else if (number == 12)
		{
			myNumber = "Queen";
		}
		else
		{
			myNumber = "King";
		}
		
		return myNumber + mySuit;
		
	}
	
	
}
