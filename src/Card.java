/**
 * Created by garetvoit on 3/24/17.
 */
public class Card {
    private String suit;
    private String face;

    Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    public String toString() {
        return face + " of " + suit;
    }

    public String getSuit() { return suit; }

    public void setSuit(String suit) { this.suit = suit; }

    public String getFace() { return face; }

    public void setFace(String face) { this.face = face; }
}
