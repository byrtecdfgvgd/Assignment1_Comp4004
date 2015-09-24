package JunitTests;

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
