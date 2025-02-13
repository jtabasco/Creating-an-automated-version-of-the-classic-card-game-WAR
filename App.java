package week06CodingProject;
	/**
	 * Main method that runs the card game application.
	 * Initializes players, deals cards, plays rounds, and displays results.
	 */

public class App {
    /**
     * The main method that runs the card game.
     * Initializes the deck, players, and handles the game logic.
     */
    public static void main(String[] args) {
        // Initialize the deck and player names
        Deck deck = new Deck();
        String name1 = "player 1";
        String name2 = "Jon";

        // Validate and adjust player names to ensure minimum length
        name1 = validLenName(name1);
        name2 = validLenName(name2);

        // Create players with validated names
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        // Shuffle the deck to randomize card order
        deck.shuffle();

        // Variable to store the winner of each round
        String roundWin = "";

        // Determine the maximum length of player names for table alignment
        int maxLenPlayer = lenPlayer(player1.getName(), player2.getName());

        // Deal cards to players alternately
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck); // Draw a card for player 1
            } else {
                player2.draw(deck); // Draw a card for player 2
            }
        }

        // Print the table header for the game results
        System.out.println("╔═════╦" + repeatString("═", 2 * maxLenPlayer + 1) + "╦" + repeatString("═", maxLenPlayer) + "╦" + repeatString("═", maxLenPlayer * 2 + 1) + "╗");
        System.out.println("║     ║" + textCenter("Flip", 2 * maxLenPlayer + 1) + "║" + repeatString(" ", maxLenPlayer) + "║" + textCenter("Score", maxLenPlayer * 2 + 1) + "║");
        System.out.println("║Round║" + textCenter(player1.getName(), maxLenPlayer) + "║" + textCenter(player2.getName(), maxLenPlayer) + "║" + textCenter("Win", maxLenPlayer) + "║" + textCenter(player1.getName(), maxLenPlayer) + "║" + textCenter(player2.getName(), maxLenPlayer) + "║");
        System.out.println("╠═════╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╣");

        // Play 26 rounds of the game
        for (int round = 1; round <= 26; round++) {
            // Flip cards for both players
            Card card1 = player1.flip();
            Card card2 = player2.flip(); 

            // Compare card values to determine the round winner
            int value1 = card1.getValue();
            int value2 = card2.getValue();

            if (value1 > value2) {
                player1.incrementScore(); // Increment player 1's score
                roundWin = player1.getName(); // Set round winner to player 1
            } else if (value2 > value1) {
                player2.incrementScore(); // Increment player 2's score
                roundWin = player2.getName(); // Set round winner to player 2
            } else {
                roundWin = "TIE"; // Round is a tie
            }

            // Print the round results in the table
            System.out.println("║ " + insertSpace(round) + "  ║" + textCenter(card1.describe(), maxLenPlayer) + "║" + textCenter(card2.describe(), maxLenPlayer) +
                    "║" + textCenter(roundWin, maxLenPlayer) + "║" + textCenter(insertSpace(player1.getScore()), maxLenPlayer) + "║" + textCenter(insertSpace(player2.getScore()), maxLenPlayer) + "║");

            // Print a separator line between rounds (except after the last round)
            if (round != 26) {
                System.out.println("╠═════╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╣");
            }
        }

        // Print the footer of the table
        System.out.println("╠═════╩" + repeatString("═", maxLenPlayer) + "╩" + repeatString("═", maxLenPlayer) + "╩" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╬" + repeatString("═", maxLenPlayer) + "╣");

        // Determine and display the final result
        int score1 = player1.getScore();
        int score2 = player2.getScore();
        System.out.println("║" + repeatString(" ", 3 + 3 * maxLenPlayer) + "Final║" + textCenter(insertSpace(player1.getScore()), maxLenPlayer) + "║" + textCenter(insertSpace(player2.getScore()), maxLenPlayer) + "║");
        System.out.println("║" + repeatString(" ", 8 + 3 * maxLenPlayer) + "╚" + repeatString("═", maxLenPlayer) + "╩" + repeatString("═", maxLenPlayer) + "╣");

        // Announce the game winner or if it's a draw
        if (score1 > score2) {
            System.out.println("║" + textCenter(player1.getName() + " wins the game!", 10 + 5 * maxLenPlayer) + "║");
        } else if (score2 > score1) {
            System.out.println("║" + textCenter(player2.getName() + " wins the game!", 10 + 5 * maxLenPlayer) + "║");
        } else {
            System.out.println("║" + textCenter("The game is a draw!", 10 + 5 * maxLenPlayer) + "║");
        }
        System.out.println("╚" + repeatString("═", 10 + 5 * maxLenPlayer) + "╝");
    }

    /**
     * Validates and adjusts player name length to ensure a minimum length of 3 characters.
     * If the name is shorter than 3 characters, it is centered within a 3-character width.
     * @param name The original player name
     * @return The validated/centered name string
     */
    private static String validLenName(String name) {
        if (name.length() >= 3) {
            return name;
        } else {
            return textCenter(name, 3);
        }
    }

    /**
     * Centers text within a specified width using spaces.
     * If the specified width is smaller than the text length, it expands to fit the text.
     * @param str The text to center
     * @param num The total width for the centered text
     * @return The centered string with padding spaces
     */
    public static String textCenter(String str, int num) {
        if (num < str.length()) {
            num = str.length();
        }
        int spaceLeft = (num - str.length()) / 2;
        int spaceRight = num - str.length() - spaceLeft;
        return repeatString(" ",spaceLeft) + str + repeatString(" ",spaceRight);
    }

    /**
     * Formats numbers for consistent table display by adding a leading space
     * to single-digit numbers (1-9) to maintain alignment.
     * @param num The number to format
     * @return The formatted string with a leading space if needed
     */
    public static String insertSpace(int num) {
        return num < 10 ? " " + num : "" + num;
    }

    /**
     * Determines the maximum length between two player names.
     * Used for formatting table columns based on the longest name.
     * @param str1 The first player's name
     * @param str2 The second player's name
     * @return The length of the longer name
     */
    public static int lenPlayer(String str1, String str2) {
        return str1.length() >= str2.length() ? str1.length() : str2.length();
    }

    /**
     * Generates a string by repeating a given character/string multiple times.
     * @param ch  The character or string pattern to repeat (e.g., " ", "═", "ab")
     * @param num The number of times to repeat the input string (≥0)
     * @return The concatenated string containing 'ch' repeated 'num' times
     */
    public static String repeatString(String ch, int num) {
        return ch.repeat(num);
    }
}