package PokerGame;

public class PokerPlayer {
	
	private String id;
	private Card hand[];
	private HandData handValue;
	
	//GET and SET Methods
	//GET and SET Methods
	public PokerPlayer()
	{
		hand = new Card [5];
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
		return new Card();
	}
	
	public void setCardAtI(int index, String myCard)
	{
		
	}
	
	//extracts ID and card data from input string
	//public void setPlayer(String input)
	//{
	//}
	//END GET and SET methods
}
