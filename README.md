# Assignment1_Comp4004
Otsuki, Andrew - 100818918

Otsuki, Andrew
100 818 918
Comp4004 – Assignment1
https://github.com/byrtecdfgvgd
https://github.com/byrtecdfgvgd/Assignment1_Comp4004


Running my Code
	For my code to run all you need to do is run the MainGame Class, it will begin by asking for the number of players then ask you enter the hands and id of each player, then it will output then in order of best to worst hand. For running my Junit tests, go to PokerGameTests and press run.













Card Tests
testCardSetAndGetNumber() – Testing the set and get methods for a Cards number variable.
testCardSetAndGetNumber() – Testing the set and get  methods for a Cards suit variable.
testCardToString() – Testing a cards toString() function. Returns string representation of card data i.e. “TwoHearts”
testCardSetCard() – Testing a Cards setCard function, which sets the cards value from a string input.
testCardisEqual() – testing a cards, is equal function which checks if 2 cards are numerically the same and have the same suit.

PokerPlayer Tests
testPokerPlayerGetHandValue() – tests the getHandvalue function, which determines the value of a players hand, i.e. is it a flush? What is the high card? Etc.
testPokerPlayerCheck2Pair() – tests if a second pair unrelated to the first is present in a hand.
testPokerPlayerCheckPair() – tests the checkPair() function which determines if a Pair is present in a players hand (not associated with a ThreeOAK or FourOAK)
testPokerPlayerCheckThreeOAK() – tests the checkThreeOAK() function which determines if a three of a kind is present in a players hand
testPokerPlayerCheckFourOAK() – tests the checkFourOAK() function which determines if a Four of a kind is present in a players hand
 testPokerPlayerCheckStraight() – tests the checkStraight() function which determines if a straight is present in a players hand
testPokerPlayerCheckFlush() – tests the checkFlush() function which determines if a flush is present in a players hand


 
 Requirements
1.	The determining number of players and getting their hand info is done within setupGame() function in PokerGame class, however this function is only a function so as to clear up my mian function and as such there are no associated tests
2.	Outputting each hand is done in printPlayers() in Poker Game as well, likewise this function was created merely to keep my main function small and tidy, all it does it output to system.out and cannot be tested
3.	For ranking hands the function sortHands() is used from PokerGame class, and tests for it can be found in PokerGameTests, testGame() function (this function also tests for duplicate hands and will order them correctly)
4.	For testing the input, i.e. the player id was entered first, or there are no repeat cards, no spelling error with cards i.e. ThClubs,  ensuring 5 cards are dealt to each player. Functions for this can be found in PokerGame
a.	checkID() – checks for valid non-repeated ID’s
b.	checkInputLength() – ensures there are not too many or too few words in the input string.
c.	checkCard() – ensures there are no repeat or invalid cards
d.	checkInput() – ensures proper number of cards, and calls the rest of the input checking functions
•	Tests for all these functions can be found within PokerGameTests testGames() function. They are all within one large function as testing a PokerGame requires a lot of setup, and it is much simpler to setup all the data one time, than for each test, also considerably neater to look at and modify.



