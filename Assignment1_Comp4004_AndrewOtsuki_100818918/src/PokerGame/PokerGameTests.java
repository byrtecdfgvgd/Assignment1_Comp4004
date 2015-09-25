package PokerGame;

import static org.junit.Assert.*;

import org.junit.Test;

import PokerGame.Card;
import PokerGame.PokerPlayer;

public class PokerGameTests {
	
	//Tests for PokerPlayers
	@Test
	public void testPlayers()
	{
		PokerPlayer testPlayer = new PokerPlayer();
		
		//Testing GET and Set Methods for a Players
		//ID
		testPlayer.setID("player1");
		assertEquals("player1", testPlayer.getID());
		
		
		//Testing setCardAtI() and getcard()
		testPlayer.setCardAtI(0, "FourClubs");
		assertEquals("FourClubs", testPlayer.getCard(0).toString());
		
		
		//Testing setPlayer()
		//extracts id and card info from string
		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		assertEquals("Player1", testPlayer.getID());
		assertEquals("TwoHearts", testPlayer.getCard(0).toString());
		assertEquals("SixHearts", testPlayer.getCard(4).toString());
		
		//Testing PokerPlayer toString() function
		assertEquals("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts" ,testPlayer.toString());
		
		//Testing sortHand()
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts SixHearts TwoHearts FourHearts");
		testPlayer.sortHand();
		assertEquals ("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts", testPlayer.toString());
		
		//testing checkFlush()
		assertEquals(6 ,testPlayer.checkFlush());
		//non-flush
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts SixHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkFlush());
		
		//testing checkStraight()
		testPlayer.setPlayer("Player1 TwoHearts ThreeHearts FourHearts FiveHearts SixHearts");
		assertEquals(6 ,testPlayer.checkStraight());
		//non-straight
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkStraight());
		
		//testing checkFourOAK()
		testPlayer.setPlayer("Player1 TwoHearts TwoDiamonds TwoClubs TwoSpades SixHearts");
		assertEquals(2 ,testPlayer.checkFourOAK());
		//non-4OAK
		testPlayer.setPlayer("Player1 FiveHearts ThreeHearts NineHearts TwoHearts FourClubs");
		testPlayer.sortHand();
		assertEquals(-1 ,testPlayer.checkFourOAK());		
	}
	
	
	//TESTS FOR CARDS
	@Test
	public void testCards()
	{
		Card testCard = new Card();
		
		
		//test get and set methods for card number
		//these functions must be tested together as 
		//I need a way to check the private variables
		testCard.setNumber(6);
		assertEquals(6, testCard.getNumber());
		
		
		
		
		//test get and set methods for card suit
		//these functions must be tested together as 
		//I need a way to check the private variables
		testCard.setSuit(1);
		assertEquals(1, testCard.getSuit());
		
		
		
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
}
