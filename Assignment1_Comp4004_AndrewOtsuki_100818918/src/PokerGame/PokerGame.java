package PokerGame;

public class PokerGame {

	public PokerPlayer[] players;
	public int numPlayers;
	
	//flips the position in array of players at player1,player2
	public void flipPlayers(int player1, int player2)
	{
		PokerPlayer temp = players[player1];
		players[player1] = players[player2];
		players[player2] = temp;		
	}
	
	//checks each card in 2 hands to find which one has 
	//a higher card
	public void checkHighCards(int player1, int player2)
	{
		for (int k = 4; k >= 0; k--)
		{
			if (players[player2].getCard(k).getNumber() < players[player1].getCard(k).getNumber())
			{
				flipPlayers(player1, player2);
				break;
			}
		}			
	}
	
	//sorts each player in the arrays hand based on card values
		//can be tested vie checkign the player ordering after this is called
		public void sortHands()
		{
		}
	
}
