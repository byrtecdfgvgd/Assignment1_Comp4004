package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import PokerGame.Card;

public class PokerGameTests {

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
		//returnCardString() test1
		testCard.setNumber(14);
		testCard.setSuit(1);
		assertEquals("AceClubs", testCard.toString());
		
		//returnCardString() test2
		testCard.setNumber(7);
		testCard.setSuit(2);
		assertEquals("SevenHearts", testCard.toString());		

		//returnCardString() test3
		testCard.setNumber(11);
		testCard.setSuit(3);
		assertEquals("JackSpades", testCard.toString());
		
	}
}
