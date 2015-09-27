package PokerGame;

import static org.junit.Assert.*;

import org.junit.Test;

import PokerGame.Card;
import PokerGame.PokerPlayer;

public class PokerGameTests {

	//------------------------------Poker Game Tests------------------------------------------------
	
	//Tests for PokerGames - many of these tests rely on information created at the start of this function it
		//ended up feeling more redundant to rewrite this function into individual function tests when half
		//the method would of had to have been coppy and pasted over anyways for these tests to run as such
		//Poker game tests are all within a single well commented function
	@Test
	public void testGames()
	{
		//Setting up variables for testing
		PokerGame myGame = new PokerGame();
		
		myGame.players = new PokerPlayer[4];
		myGame.numPlayers = 4;
		
		for (int  i = 0; i < 4; i++)
		{
			myGame.players[i] = new PokerPlayer();
		}
		
		
		myGame.players[0].setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		myGame.players[1].setPlayer("Player2 TwoHearts TwoDiamonds NineClubs JackClubs KingClubs");
		myGame.players[2].setPlayer("Player3 ThreeDiamonds FourDiamonds FiveDiamonds SixDiamonds SevenDiamonds");
		myGame.players[3].setPlayer("Player4 TwoClubs ThreeClubs TwoSpades FourSpades SixClubs");

		for (int i = 0; i < 4; i++)
		{
			myGame.players[i].sortHand();
			myGame.players[i].getHandValue();
		}
		//End Variable Setup
		
		//testing flip players
		myGame.flipPlayers(0,1);
		assertEquals("Player2", myGame.players[0].getID());
		
		//Testing Check High card
		myGame.checkHighCards(0, 3);
		assertEquals("Player2", myGame.players[3].getID());
		
		//Testing the hand sorting function		
		myGame.sortHands();
		
		assertEquals("Player4", myGame.players[0].getID());
		assertEquals("Player2", myGame.players[1].getID());
		assertEquals("Player1", myGame.players[2].getID());
		assertEquals("Player3", myGame.players[3].getID());
		
		
		//testing a checker for counting number of words in the input
		assertEquals(0, myGame.checkInputLength("Player4 TwoClubs ThreeClubs TwoSpades FourSpades SixClubs"));
		assertEquals(-1, myGame.checkInputLength("Player4 ThreeClubs TwoSpades FourSpades SixClubs"));
		assertEquals(-1, myGame.checkInputLength("Player4 FourClubs EightSpades TwoClubs TwoSpades FourSpades SixClubs"));
		assertEquals(-1, myGame.checkInputLength("Player4  TwoClubs ThreeClubs TwoSpades FourSpades SixClubs"));
		assertEquals(-1, myGame.checkInputLength("Player4  TwoClubs TwoSpades FourSpades SixClubs"));
		
		//testing a checker for ID's to ensure they are valid and an the first position and not already taken
		//for the purposes of this assignment a valid id is one that has not been taken and is not a card i.e. TwoClubs
		//will not be accepted but Player1 or 09872634 or ID1 etc will be accepted
			//new ID
		assertEquals(0, myGame.checkID("Player7", 4));
			//used ID
		assertEquals(-1, myGame.checkID("Player4", 4));
			//improper id
		assertEquals(-1, myGame.checkID("TwoClubs", 4));
		
		//checking each card entered is indeed a card and is unique
		//new unique card
		assertEquals(0, myGame.checkCard("KingDiamonds" , 4, 5));
		//used card
		assertEquals(-1, myGame.checkCard("TwoHearts" , 4, 5));
		//unique card up to position 2, 3 in list
		assertEquals(0, myGame.checkCard("JackClubs" , 2, 3));
		//used card
		assertEquals(-1, myGame.checkCard("JackClubs" , 2, 4));
		//not a card
		assertEquals(-1, myGame.checkCard("thClubs" , 4, 4));
		
		//lastly I combine my checking fucntions into one fucntion that goes through an entire input string looking for mistakes
		assertEquals(0, myGame.checkInput("Player9 FiveSpades SixSpades SevenSpades EightSpades NineSpades", 4));
		assertEquals(-1, myGame.checkInput("Player1 TwoClubs ThreeClubs TwoSpades FourSpades SixClubs", 4));
		assertEquals(-1, myGame.checkInput("TwoSpades TwoClubs ThreeClubs TwoSpades FourSpades SixClubs", 4));
		assertEquals(-1, myGame.checkInput("Player9  ThreeClubs TwoSpades FourSpades SixClubs", 4));
		assertEquals(-1, myGame.checkInput("Player9 TwoSpades SixSpades SevenSpades EightSpades NineSpades", 4));
	}
	
	
	//---------------------------Tests for PokerPlayers---------------------------------------------------
	@Test
	public void testPokerPlayerSetnGetID()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//Testing GET and Set Methods for a Players
		//ID
		testPlayer.setID("player1");
		assertEquals("player1", testPlayer.getID());
	}
	
	@Test
	public void testPokerPlayerSetnGetCard()
	{
		PokerPlayer testPlayer = new PokerPlayer();
				
		//Testing setCardAtI() and getcard()
		testPlayer.setCardAtI(0, "FourClubs");
		assertEquals("FourClubs", testPlayer.getCard(0).toString());
	}
	
	@Test
	public void testPokerPlayerSetPlayer()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//Testing setPlayer()
		//extracts id and card info from string
		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		assertEquals("Player1", testPlayer.getID());
		assertEquals("TwoHearts", testPlayer.getCard(0).toString());
		assertEquals("SixHearts", testPlayer.getCard(4).toString());
		
	}
	
	
	@Test
	public void testPokerPlayertoString()
	{
		PokerPlayer testPlayer = new PokerPlayer();

		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");

		//Testing PokerPlayer toString() function
		assertEquals("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts" ,testPlayer.toString());		
	}
	
	@Test
	public void testPokerPlayerSortHand()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//Testing sortHand()
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts SixHearts TwoHearts FourHearts");
		testPlayer.sortHand();
		assertEquals ("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts", testPlayer.toString());
	}
	
	@Test
	public void testPokerPlayerCheckFlush()
	{
		PokerPlayer testPlayer = new PokerPlayer();

		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		
		//testing checkFlush()
		assertEquals(6 ,testPlayer.checkFlush());
		//non-flush
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts SixHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkFlush());
	}
	
	@Test
	public void testPokerPlayerCheckStraight()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//testing checkStraight()
		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		testPlayer.sortHand();
		assertEquals(6 ,testPlayer.checkStraight());
		//non-straight
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkStraight());
	}
	
	public void testPokerPlayerCheckFourOAK()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//testing checkFourOAK()
		testPlayer.setPlayer("Player1 TwoHearts TwoDiamonds TwoClubs TwoSpades SixHearts");
		testPlayer.sortHand();
		assertEquals(2 ,testPlayer.checkFourOAK());
		//non-4OAK
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkFourOAK());
			
	}
	
	public void testPokerPlayerCheckThreeOAK()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//testing checkThreeOAK()
		testPlayer.setPlayer("Player1 TwoHearts TwoDiamonds TwoClubs FourSpades SixHearts");
		testPlayer.sortHand();
		assertEquals(2 ,testPlayer.checkThreeOAK(-1));
		//non-3OAK
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkThreeOAK(-1));
			
	}
	
	public void testPokerPlayerCheckPair()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//testing checkPair()
		testPlayer.setPlayer("Player1 TwoHearts ThreeDiamonds TwoClubs FourSpades SixHearts");
		testPlayer.sortHand();
		assertEquals(2 ,testPlayer.checkPair(-1, -1));
		//non-pair
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkPair(-1, -1));
		
	}
	
	public void testPokerPlayerCheck2Pair()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//testing checkPair2
		testPlayer.setPlayer("Player1 TwoHearts ThreeClubs TwoClubs ThreeSpades SixHearts");
		testPlayer.sortHand();
		assertEquals(2 ,testPlayer.checkPair2(3, -1, -1));
		//non-pair
		testPlayer.setPlayer("Player1 TwoHearts ThreeDiamonds TwoClubs FourSpades SixHearts");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkPair2(2, -1, -1));	
		
	}
	
	public void testPokerPlayerGetHandValue()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//Tests for getHandValue()
		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		//checking for a flush
		testPlayer.getHandValue();
		assertEquals(6, testPlayer.handValue.flush);
		//checking for a straight
		assertEquals(6, testPlayer.handValue.straight);
		//checking the function has read a straight flush
		assertEquals(8, testPlayer.handValue.handVal);
		//the rest should be -1 (not present)
		assertEquals(-1, testPlayer.handValue.fourOAK);
		assertEquals(-1, testPlayer.handValue.threeOAK);
		assertEquals(-1, testPlayer.handValue.pair2);
		assertEquals(-1, testPlayer.handValue.pair1);
		
		
	}
	
	
	//-----------------CARD Tests-------------------------------------------
	
	@Test
	public void testCardSetnGetNumber()
	{
		Card testCard = new Card();
		
		//test get and set methods for card number
		//these functions must be tested together as 
		//I need a way to check the private variables
		testCard.setNumber(6);
		assertEquals(6, testCard.getNumber());
	}
	
	@Test
	public void testCardSetnGetSuit()
	{
		Card testCard = new Card();
		
		//test get and set methods for card suit
		//these functions must be tested together as 
		//I need a way to check the private variables
		testCard.setSuit(1);
		assertEquals(1, testCard.getSuit());
	}
	
	@Test
	public void testCardToString()
	{
		Card testCard = new Card();
		
		//Testing a cards toString() Functions
		//test ace of clubs
		testCard.setNumber(14);
		testCard.setSuit(1);
		assertEquals("AceClubs", testCard.toString());
		//test seven of hearts
		testCard.setNumber(7);
		testCard.setSuit(2);
		assertEquals("SevenHearts", testCard.toString());		
		//test jack of spades
		testCard.setNumber(11);
		testCard.setSuit(3);
		assertEquals("JackSpades", testCard.toString());
	}
	
	@Test
	public void testCardSetCard()
	{
		Card testCard = new Card();
		
		//Testing Set Card Functions
		//setCard(String) test1 *Valid Input*
		assertEquals(0, testCard.setCard("TwoSpades"));
		assertEquals("TwoSpades", testCard.toString());
		
		//setCard(String) test2 *Valid Input*
		assertEquals(0, testCard.setCard("QueenClubs"));
		assertEquals("QueenClubs", testCard.toString());
		
		//setCard(String) test3 *Invalid Input*
		assertEquals(-1, testCard.setCard("OneSpades"));
		
		//setCard(String) test4 *Invalid Input*
		assertEquals(-2, testCard.setCard("TwoHeads"));
	}
	
	@Test
	public void testCardisEqual()
	{
		Card testCard = new Card();
		
		//isEqual(Card anotherCard) testign if 2 cards are equal
		testCard.setCard("QueenClubs");
		Card tempCard = new Card();
		tempCard.setCard("QueenClubs");
		assertEquals(true, testCard.isEqual(tempCard));
		tempCard.setCard("ThreeHearts");
		assertEquals(false , testCard.isEqual(tempCard));
	}
	
}
