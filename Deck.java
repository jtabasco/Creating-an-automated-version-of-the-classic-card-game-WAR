package week06CodingProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// List to store the collection of Card objects representing the deck of cards
	private List<Card> cards;
	
    public Deck() {
    	// Initialize the deck as an empty ArrayList to store Card objects
    	cards = new ArrayList<>();

    	// Define the four suits in a deck of cards: Hearts, Spades, Clubs, Diamonds
    	String[] suits = {"♥", "♠", "♣", "♦"};

    	// Define the thirteen card values in a standard deck: 2 through Ace
    	String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
     // Iterate through each suit and value to create a full deck of cards
        for (String suit : suits) {
            for (int i = 0; i < values.length; i++) {
                // Assign a numerical value to the card (2-14, where 2=2, J=11, Q=12, K=13, A=14)
                int value = i + 2; 
                
                // Construct the card's name by combining the value and suit (e.g., "K♠" or "10♥")
                String name = values[i] + suit; 
                
                // Create a new Card object with the calculated value and name
                Card card = new Card(value, name);
                
                // Add the card to the deck
                cards.add(card);
            }
        }
    }

    /**
     * Shuffles the deck of cards using Java's Collections.shuffle() method.
     * This randomizes the order of the cards in the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws the top card from the deck.
     * Removes and returns the first card in the list.
     * @return The top Card object from the deck
     */
    public Card draw() {
        return cards.remove(0);
    }
}
