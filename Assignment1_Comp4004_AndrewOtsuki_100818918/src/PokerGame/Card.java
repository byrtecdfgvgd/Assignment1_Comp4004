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
		if (myCard.indexOf("Two") != -1)
		{
			number = 2;
		}
		else if (myCard.indexOf("Three") != -1)
		{
			number = 3;
		}
		else if (myCard.indexOf("Four") != -1)
		{
			number = 4;
		}
		else if (myCard.indexOf("Five") != -1)
		{
			number = 5;
		}
		else if (myCard.indexOf("Six") != -1)
		{
			number = 6;
		}
		else if (myCard.indexOf("Seven") != -1)
		{
			number = 7;
		}
		else if (myCard.indexOf("Eight") != -1)
		{
			number = 8;
		}
		else if (myCard.indexOf("Nine") != -1)
		{
			number = 9;
		}
		else if (myCard.indexOf("Ten") != -1)
		{
			number = 10;
		}
		else if (myCard.indexOf("Jack") != -1)
		{
			number = 11;
		}
		else if (myCard.indexOf("Queen") != -1)
		{
			number = 12;
		}
		else if (myCard.indexOf("King") != -1)
		{
			number = 13;
		}
		else if (myCard.indexOf("Ace") != -1)
		{
			number = 14;
		}
		else
		{
			return -1;
		}
		
		if (myCard.indexOf("Club") != -1)
		{
			suit = 1;
		}	
		else if (myCard.indexOf("Heart") != -1)
		{
			suit = 2;
		}
		else if (myCard.indexOf("Spade") != -1)
		{
			suit = 3;
		}
		else if (myCard.indexOf("Diamond") != -1)
		{
			suit = 4;
		}
		else
		{
			return -2;
		}
		
		
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
	
	protected boolean isEqual(Card cmp)
	{
		return false;
	}
	
}
