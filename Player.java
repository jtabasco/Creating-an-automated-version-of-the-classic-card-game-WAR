package week06CodingProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the card game.
 * Each player has a name, a hand of cards, and a score.
 */
public class Player {
    
    private List<Card> hand;// List to store the player's current hand of cards
    private int score;// Tracks the player's score during the game
    private String name;// Stores the player's name

    /**
     * Constructs a new Player with the given name.
     * Initializes an empty hand and sets the score to 0.
     * @param name The name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    /**
     * Flips the top card from the player's hand.
     * Removes and returns the first card in the hand.
     * @return The top Card object from the hand
     */
    public Card flip() {
        return hand.remove(0);
    }

    /**
     * Draws a card from the deck and adds it to the player's hand.
     * @param deck The deck from which to draw a card
     */
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
            hand.add(drawnCard);
    }

    /**
     * Increments the player's score by 1.
     * Used when the player wins a round.
     */
    public void incrementScore() {
        score++;
    }

    /**
     * Returns the player's current score as an integer
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the player's name as a String
     */
    public String getName() {
        return name;
    }
}
