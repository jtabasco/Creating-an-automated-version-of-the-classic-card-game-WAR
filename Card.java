package week06CodingProject;

/**
 * Represents a playing card in the game.
 * Each card has a numerical value and a name (e.g., "A♠" for Ace of Spades).
 */
public class Card {
    // The numerical value of the card (e.g., 2 for 2, 11 for Jack, 14 for Ace)
    private int value;

    // The name of the card, combining its value and suit (e.g., "K♥" for King of Hearts)
    private String name;

    /**
     * Constructs a new Card with the specified value and name.
     *
     * @param value The numerical value of the card
     * @param name  The name of the card (e.g., "10♦" for Ten of Diamonds)
     */
    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Returns the numerical value of the card as an integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the name of the card as a String
     */
    public String getName() {
        return name;
    }
 
    /**
     * Describes the card by returning its name as a String
     */
    public String describe() {
        return name;
    }
}