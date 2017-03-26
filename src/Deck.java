import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by garetvoit on 3/24/17.
 */
public class Deck {
    private static final int DEFAULT_DECK_CAPACITY = 52;
    private Card[] deck = new Card[DEFAULT_DECK_CAPACITY]; // The deck of cards
    private int top = 0;

    public static void main(String[] args) {
        /* Shuffle Tests
        Deck myDeck = new Deck();
        System.out.println(Arrays.toString(myDeck.getDeck()));
        myDeck.shuffle();
        System.out.println(Arrays.toString(myDeck.getDeck()));
        Deck myDeck2 = new Deck();
        System.out.println(Arrays.toString(myDeck2.getDeck()));
        myDeck2.shuffle();
        System.out.println(Arrays.toString(myDeck2.getDeck()));
         */
    }

    // A dictionary to simplify later look-ups (avoiding unnecessary switch statements) and future-proof the app
    // If this logic did end up getting used down the road, the "Ace" value would need to be checked again, as it can
    // be assigned multiple values (14 or 1).
    private HashMap<Integer, String> faceValuesMap = new HashMap<Integer, String>() {{
        put(1, "Ace");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Jack");
        put(12, "Queen");
        put(13, "King");
    }};

    // This makes less logical sense than the faceValuesMap, since there is no domain mapping between a number and a suit.
    // However, it significantly reduces code complexity and repetition when initializing the deck.
    private HashMap<Integer, String> suitValuesMap = new HashMap<Integer, String>() {{
        put(0, "Hearts");
        put(1, "Spades");
        put(2, "Diamonds");
        put(3, "Clubs");
    }};

    /**
     * Pre-populates the deck with 52 cards, 13 for each suit, with values Ace, 2-10, Jack, Queen, King.
     * Leverages the faceValuesMap and suitValuesMap to reduce the logic inside of the for loops.
     */
    Deck() {
        // Populate the new deck with 52 cards
        // Insert 13 cards for each suit
        for (int suitIndex=0; suitIndex < 4; suitIndex++) {
            for (int faceValueLookup = 1; faceValueLookup < 14; faceValueLookup++) {
                // Adds a card to the top of the deck, then increments top.
                deck[top++] = new Card(suitValuesMap.get(suitIndex), faceValuesMap.get(faceValueLookup));
            }
        }
        top = DEFAULT_DECK_CAPACITY-1;
    }

    public Card[] getDeck() {
        return deck;
    }

    public void shuffle() {
        int i, swapWith;
        for (i=0; i < 52; i++) {
            // Generate a random number each time
            swapWith = ThreadLocalRandom.current().nextInt(0, 52);
            swapCards(i, swapWith);
        }
    }

    void swapCards(int index, int swapWith) {
        Card temp = deck[index];
        deck[index] = deck[swapWith];
        deck[swapWith] = temp;
    }

    /**
     * Space Complexity O(1)
     * Time Complexity O(1)
     * @return Returns the top Card in this.deck;
     */
    public Card dealOneCard() {
        if (top == -1) return null;
        Card cardToReturn = deck[top]; // Temporarily store the Card which will be returned.
        deck[top] = null; // Remove the top card from the deck.
        top--; //  Tell the array where its new top is
        return cardToReturn; // Return the top Card to the user
    }

}
