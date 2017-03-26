import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by garetvoit on 3/24/17.
 */
public class DeckTest {
    @Test
    public void testDeckConstructor() {
        Deck testDeck = new Deck();
        assertEquals("Deck constructed improperly, first card should be Ace of Hearts",
                "Ace of Hearts", testDeck.getDeck()[0].toString());
        assertEquals("Deck constructed improperly, 12th card should be King of Hearts",
                "King of Hearts", testDeck.getDeck()[12].toString());
        assertEquals("Deck constructed improperly, 14th card should be Two of Spades",
                "Two of Spades", testDeck.getDeck()[14].toString());
        assertEquals("Deck constructed improperly, 25th card should be Jack of Spades",
                "Jack of Spades", testDeck.getDeck()[23].toString());
        assertEquals("Deck constructed improperly, 33rd card should be Eight of Diamonds",
                "Eight of Diamonds",testDeck.getDeck()[33].toString());
        assertEquals("Deck constructed improperly, 37th card should be Queen of Diamonds",
                "Queen of Diamonds", testDeck.getDeck()[37].toString());
        assertEquals("Deck constructed improperly, 39th card should be Ace of Clubs",
                "Ace of Clubs", testDeck.getDeck()[39].toString());
        assertEquals("Deck constructed improperly, last card should be King of Clubs",
                "King of Clubs", testDeck.getDeck()[51].toString());
    }
    @Test
    public void testDealOneCard() {
        Deck testDeck = new Deck();
        assertEquals("Should have returned King of Clubs", "King of Clubs", testDeck.dealOneCard().toString());
        for (int i=0; i < 51; i++) {
            testDeck.dealOneCard().toString();
        }
        assertNull("When we reach the bottom of the deck, we should return null", testDeck.dealOneCard());
        assertNull("When we reach the bottom of the deck, we should return null", testDeck.dealOneCard());
        assertNull("When we reach the bottom of the deck, we should return null", testDeck.dealOneCard());
    }
    @Test
    public void testSwap() {
        Deck testDeck = new Deck();
        testDeck.swapCards(0, 51);
        assertEquals("After swap, top card should be Ace of Hearts", "Ace of Hearts", testDeck.getDeck()[51].toString());
        assertEquals("After swap, bottom card should be King of Clubs", "King of Clubs", testDeck.getDeck()[0].toString());
    }
    @Test
    public void testShuffle() {
        Deck testDeck = new Deck();
        testDeck.shuffle();
        for (int i=0; i < 52; i++) testDeck.dealOneCard();
        assertNull("When we reach the bottom of the deck, we should return null", testDeck.dealOneCard());
    }
}