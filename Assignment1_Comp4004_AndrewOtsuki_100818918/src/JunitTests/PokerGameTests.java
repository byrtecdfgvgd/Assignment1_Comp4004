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
		
	}
}
