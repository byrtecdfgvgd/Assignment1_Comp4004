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
	public void sortHand()
	{
	}
}
