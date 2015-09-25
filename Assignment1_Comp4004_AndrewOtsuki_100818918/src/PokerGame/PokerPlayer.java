package PokerGame;

public class PokerPlayer {
	
	private String id;
	private Card hand[];
	private HandData handValue;
	
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
		return 0;
	}
}
