package PokerGame;

import java.util.Scanner;

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
		//TODO sort and rank hands
		for (int i = 0; i < numPlayers; i++)
		{
			for (int j = i + 1; j < numPlayers; j++)
			{
				//System.out.println("j = " + j + ", i = " + i);
				//System.out.println(players[i].toString());
				//System.out.println(players[j].toString());
				//System.out.println("-------------------");
				//players[j].getHandValue();
				//hands are of different base value
				if (players[j].handValue.handVal < players[i].handValue.handVal)
				{
					flipPlayers(i, j);
				}
				//hands of are same base value
				else if (players[j].handValue.handVal == players[i].handValue.handVal)
				{
					//High Cards
					if(players[j].handValue.handVal == 0)
					{
						checkHighCards (i, j);
					}
					//Pair
					else if (players[j].handValue.handVal == 1)
					{
						//one player has a bigger pair
						if (players[j].handValue.pair1 < players[i].handValue.pair1)
						{
							flipPlayers(i, j);
						}
						//same pair is present compare rest of hand
						else if (players[j].handValue.pair1 == players[i].handValue.pair1)
						{
							checkHighCards (i, j);
						}
					}
					//2 Pair
					else if (players[j].handValue.handVal == 2)
					{
						//larger pair, smaller on second 
						if (players[j].handValue.pair1 < players[i].handValue.pair1)
						{
							flipPlayers(i, j);
						}
						//smaller pair, larger on second
						else if (players[j].handValue.pair2 < players[i].handValue.pair2
								&& players[j].handValue.pair1 == players[i].handValue.pair1)
						{
							flipPlayers(i, j);
						}
						//both pairs equal, compare all cards
						else if (players[j].handValue.pair2 == players[i].handValue.pair2
								&& players[j].handValue.pair1 == players[i].handValue.pair1)
						{
							checkHighCards (i, j);						
						}
					}
					//Three Of A Kind
					else if (players[j].handValue.handVal == 3)
					{
						//second three of a kind smaller than first
						if (players[j].handValue.threeOAK < players[i].handValue.threeOAK)
						{
							flipPlayers(i, j);
						}
					}
					//Straight
					else if (players[j].handValue.handVal == 4)
					{
						//second straight smaller than first
						if (players[j].handValue.straight < players[i].handValue.straight)
						{
							flipPlayers(i, j);
						}
					}
					//flush TODO
					else if (players[j].handValue.handVal == 5)
					{
						//second flush smaller than first, this method will flip
						//their positions
						checkHighCards (i, j);
					}
					//full house
					else if (players[j].handValue.handVal == 6)
					{
						//second three of a kind smaller than first
						if (players[j].handValue.threeOAK < players[i].handValue.threeOAK)
						{
							flipPlayers(i, j);
						}
					}
					//Four of a Kind
					else if (players[j].handValue.handVal == 7)
					{
						//second four of a kind smaller than first
						if (players[j].handValue.fourOAK < players[i].handValue.fourOAK)
						{
							flipPlayers(i, j);
						}
					}
					//straight flush
					else if (players[j].handValue.handVal == 8)
					{
						//second straight of a kind smaller than first
						if (players[j].handValue.flush < players[i].handValue.flush)
						{
							flipPlayers(i, j);
						}
					}
				}
			}
		}
	}
	
	//check input length, checks number of words in an array
	protected int checkInputLength(String input)
	{
		int spaceCount = 0;
		boolean lastSpace = false;
		
		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == ' ' && !lastSpace)
			{
				lastSpace = true;
				spaceCount++;
			}
			else if (input.charAt(i) == ' ')
			{
				return -1;
			}
			else if (lastSpace)
			{
				lastSpace = false;
			}
		}
		
		if (spaceCount != 5)
		{
			return -1;
		}
		
		return 0;
	}
	
	protected int checkCard(String myCard, int playerNum, int cardNum)
	{
		Card testCard = new Card();
		int isCard = testCard.setCard(myCard);
		
		if (isCard != 0)
		{
			return -1;
		}
		
		for (int i = 0; i < playerNum; i++)
		{
			if (i == playerNum - 1)
			{
				for (int j = 0; j < cardNum; j++)
				{
					if (players[i].getCard(j).isEqual(testCard))
					{
						return -1;
					}
				}
			}
			else
			{
				for (int j = 0; j < 5; j++)
				{
					if (players[i].getCard(j).isEqual(testCard))
					{
						return -1;
					}
				}			
			}
		}
		
		
		return 0;
	}
	
	protected int checkID(String input, int curPlayers)
	{
		Card testCard = new Card();
		int isCard = testCard.setCard(input);
		
		for (int i = 0; i < curPlayers; i++)
		{
			if (players[i].getID().equals(input))
			{
				return -1;
			}
		}
		
		if (isCard == 0)
		{
			return -1;
		}
		
		return 0;
	}
	
	protected int checkInput(String input, int playerIndex)
	{
		int len = 0;
		int curCard = 0;
		int id = 0;
		String word = "";
		boolean idDone = false;
		int numDoneCards = 0; 
		
		len = checkInputLength(input);
		
		if (len != 0)
		{
			return -1;
		}
		else
		{
			for (int i = 0; i <= input.length(); i++)
			{
				if (i == input.length())
				{
					curCard = checkCard(word, playerIndex, numDoneCards); 
					numDoneCards++;
					
					if (curCard != 0)
					{
						return -1;
					}					
				}
				else if (input.charAt(i) == ' ' && !idDone)
				{
					idDone = true;
					id = checkID(word, playerIndex);
					if (id != 0)
					{
						return -1;
					}
					word = "";
				}
				else if (input.charAt(i) == ' ')
				{
					curCard = checkCard(word, playerIndex, numDoneCards); 
					numDoneCards++;
					
					if (curCard != 0)
					{
						return -1;
					}
					
					word = "";
				}
				else
				{
					word += input.charAt(i);
				}
			}
		}
		
		return 0;
	}
	
	
	//These functions cannot really be tested, but are simply what I would have had in the main function
	//broken up neatly to encapsulate what the main function needs to do as far as getting input and outputting the hands
	//however this way is neater to look at
	
	//prints out players with thier ranks
	//cannot be tested as all it does is print out the toString() 
	//function for each player, which itself has been tested
	public void printPlayers()
	{
		int rank = 1;
		
		for (int i = numPlayers - 1; i >= 0; i--)
		{
			System.out.println(players[i].toString() + " " + rank);
			rank++;
		}
	}
	
	//sets up game and all related variables
	//cannot be tested due to need for user input, however the function is very simple
	public void setUpGame()
	{
		Scanner keyboard = new Scanner(System.in);
		String input;
		
		numPlayers = 0;
		
		
		while (numPlayers < 2 && numPlayers > 4)
		{
			System.out.println("How many players? enter a number from 2-4, and press enter.");
			numPlayers = keyboard.nextInt();
		}
		input = keyboard.nextLine();
		input = "";
		
		players = new PokerPlayer[numPlayers];
		
		for (int i = 0; i < numPlayers; i++)
		{
			players[i] = new PokerPlayer();
			
			//TODO ensure proper cards, proper number, player id entered first, duplicate cards
			System.out.println("input players hand i.e. Player1 OneHearts TwoHearts ThreeClubs fourClubs fiveClubs");
			input = keyboard.nextLine();
			
			players[i].setPlayer(input);
			
			
			players[i].getHandValue();
		}
		
		keyboard.close();
	}
	
	//PokerGame Assignment - call to play assignment game
	public void playGame()
	{
		//sets up the game
		setUpGame();
		
		//sorts the hands worst to best
		sortHands();
		
		//prints all the players out by rank
		printPlayers();
		
		
	}
	
	
}
