package PokerGame;

public class PokerPlayer {
	
	private String id;
	private Card hand[];
	protected HandData handValue;
	
	//GET and SET Methods
	public PokerPlayer()
	{
		hand = new Card [5];
		
		for (int i = 0; i < 5; i++)
		{
			hand[i] = new Card();
		}
	}
	
	public String getID()
	{
		return id;
	}
			
	public void setID(String newID)
	{
		id = newID;
	}
	
	public Card getCard(int index)
	{
		return hand[index];
	}
	
	public void setCardAtI(int index, String myCard)
	{
		hand[index].setCard(myCard);
	}
	
	//extracts ID and card data from input string
	public void setPlayer(String input)
	{
		int k = 0, cardNum = 0;
		String subStr = "";
		
		id  = "N/A";
		
		while (k < input.length())
		{
			if (input.charAt(k) != ' ')
			{
				subStr += input.charAt(k);
			}
			else
			{
				if (id.compareTo("N/A") == 0)
				{
					id = subStr;
					subStr = "";
				}
				else
				{
					hand[cardNum].setCard(subStr); 
					cardNum++;
					subStr = "";
				}
			}
			
			k++;
		}
		
		hand[cardNum] = new Card();
		hand[cardNum].setCard(subStr); 
	}
	//END GET and SET methods
	
	//returns string representation of player data
	public String toString()
	{
		String output = "";
		
		output = id;
		
		for (int i = 0;i < 5; i++)
		{
			output += " " + hand[i].toString();
		}
		
		
		return output;
	
	}
	
	//Sorts the players hand numerically
	protected void sortHand()
	{
		//sort Hand 
		for (int i = 0; i < hand.length; i++)
		{
			for (int k = i + 1; k < hand.length; k++)
			{				
				if (hand[k].getNumber() < hand[i].getNumber())
				{
					Card temp = hand[i];
					hand[i] = hand[k];
					hand[k] = temp;
				}
			}
		}
	}
	
	// -> Int
	//checks if there is a flush in the hand i.e. all 1 suit
	//returns High Card if present
	protected int checkFlush()
	{
		if (hand[0].getSuit() == hand[1].getSuit() && hand[0].getSuit() == hand[2].getSuit()
				&& hand[0].getSuit() == hand[3].getSuit() && hand[0].getSuit() == hand[4].getSuit())
		{
			return hand[4].getNumber();
		}
		else
		{
			return -1;
		}
	}
	
	// -> Int
	//Checks if a straight is present
	//returns High Card if present
	protected int checkStraight ()
	{	
		//see if straight is present
		if (hand[0].getNumber() + 1 == hand[1].getNumber() && hand[0].getNumber() + 2 == hand[2].getNumber()
				&& hand[0].getNumber() + 3 == hand[3].getNumber() && hand[0].getNumber() + 4 == hand[4].getNumber())
		{
			return hand[4].getNumber();
		}
		else
		{
			return -1;
		}
	}
	
	//returns High Card if present//
	protected int checkFourOAK()
	{		
		for (int i = 3; i < hand.length; i++)
		{
			if (hand[i - 3].getNumber() == hand[i-2].getNumber() && hand[i-2].getNumber() == hand[i-1].getNumber() 
					&& hand[i-1].getNumber() == hand[i].getNumber())
			{
				return hand[i].getNumber();
			}
		}
		
		return -1;
	}
	
	//returns High Card if present
	protected int checkThreeOAK(int fourOAK)
	{		
		for (int i = 2; i < hand.length; i++)
		{
			if (hand[i - 2].getNumber() == hand[i-1].getNumber() && 
					hand[i-1].getNumber() == hand[i].getNumber() && hand[i].getNumber() != fourOAK)
			{
				return hand[i].getNumber();
			}
		}
		
		return -1;
	}
	
	//checks if a pair is present in the hand,
	//and it is not equal to the three of a kind should that also be present
	protected int checkPair(int threeOAK, int fourOAK)
	{
		for (int i = 1; i < hand.length; i++)
		{
			if (hand[i - 1].getNumber() == hand[i].getNumber() && hand[i].getNumber() != threeOAK && hand[i].getNumber() != fourOAK)
			{
				return hand[i].getNumber();
			}
		}
		return -1;
	}
	
	//checks if a 2nd pair is present in the hand,
	//and it is not equal to the three of a kind should that also be present
	protected int checkPair2(int pair1, int fourOAK, int threeOAK)
	{
		for (int i = 1; i < hand.length; i++)
		{
			if (hand[i - 1].getNumber() == hand[i].getNumber() && hand[i].getNumber() != pair1 &&
					hand[i].getNumber() != fourOAK && hand[i].getNumber() != threeOAK)
			{
				return hand[i].getNumber();
			}
		}
		return -1;
	}
	
	//checks the value of a hand i.e. flush, high card, pair, etc.
	public void getHandValue()
	{
		handValue = new HandData();
		
		sortHand();
		
		handValue.highCard = hand[4].getNumber();
		
		handValue.flush = checkFlush();
		handValue.straight = checkStraight();
		handValue.fourOAK = checkFourOAK();
		handValue.threeOAK = checkThreeOAK(handValue.fourOAK);
		handValue.pair1 = checkPair(handValue.threeOAK, handValue.fourOAK);
		handValue.pair2 = checkPair2(handValue.pair1, handValue.fourOAK, handValue.threeOAK);
		
		
		if (handValue.flush != -1 && handValue.straight != -1 && handValue.flush == 14)
		{
			handValue.handVal = 9;
		}
		else if (handValue.flush != -1 && handValue.straight != -1)
		{
			handValue.handVal = 8;
		}		
		else if (handValue.fourOAK != -1)
		{
			handValue.handVal = 7;
		}	
		else if (handValue.threeOAK != -1 && handValue.pair1 != -1)
		{
			handValue.handVal = 6;
		}	
		else if (handValue.flush != -1)
		{
			handValue.handVal = 5;
		}	
		else if (handValue.straight != -1)
		{
			handValue.handVal = 4;
		}	
		else if (handValue.threeOAK != -1)
		{
			handValue.handVal = 3;
		}	
		else if (handValue.pair1 != -1 && handValue.pair2 != -1)
		{
			handValue.handVal = 2;
		}	
		else if (handValue.pair1 != -1)
		{
			handValue.handVal = 1;
		}	
		else 
		{
			handValue.handVal = 0;
		}	
	}
}
