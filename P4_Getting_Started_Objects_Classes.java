package projects;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.util.Arrays;

public class P4_Getting_Started_Objects_Classes {

	/*
	// Developer: Nikita Ghimire
	// Date: 11/07/2024
	// System description: 
	 * Implement a Java program that simulates the rolling of 3 dice
	 * and then evaluates the dice roll to determine points scored based on the game’s rules. 
	 * The game score is the sum of the dice plus bonus points for rolling a pair 
	 * (aka Doublet – 5 bonus points) or three-of-a kind (aka Triplet – 20 bonus points).  
	 * The score for the game is the sum of the dice plus the bonus points.
	*/

	
    public static void main(String[] args) {
        // Instantiate objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LocalDate currentDate = LocalDate.now();

        // Session and Game objects
        Session session = new Session();
        Game game = new Game();

        // Initialize player details and welcome message
        session.setName(scanner);
        session.prtWelcome();

        // Main game loop for setting number of games
        do {
            game.setGames(scanner); 

            // For loop
            for (int i = 1; i <= game.getGames(); i++) {
                System.out.print("Press and enter any key to begin the game: ");
                scanner.nextLine(); 

                // Set game and play
                game.setGame(i);
                game.setDice(random); 
                game.setInitBonusResult(); 
                game.setBonus();
                game.setScore(); 
                
                // Game results
                game.prtScoreResults(currentDate);
            }

            // Prompt for replay
            session.setPlayAgain(scanner);
        } while (session.getPlayAgain().equalsIgnoreCase("Y"));

        // Goodbye message
        session.prtOutMessage();
        scanner.close();
    }
}

// Game class 
class Game {
    private int games;
    private int game;
    private int[] dice = new int[3];
    private int sum;
    private int bonus;
    private int score;
    private String result;

    // Set number of games
    public void setGames(Scanner scanner) {
        System.out.print("How many games would you like to play? ");
        this.games = scanner.nextInt();
        scanner.nextLine(); 
    }

    public int getGames() {
        return games;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int getGame() {
        return game;
    }

    // Reset bonus
    public void setInitBonusResult() {
        this.bonus = 0;
        this.result = "";
    }

    // Roll dice and sorting
    public void setDice(Random random) {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
        Arrays.sort(dice);
        sum = Arrays.stream(dice).sum();
    }

    public int[] getDice() {
        return dice;
    }

    // Calculate bonus
    public void setBonus() {
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            bonus = 20;
            result = "Triplet";
        } else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
            bonus = 5;
            result = "Doublet";
        }
    }

    public int getBonus() {
        return bonus;
    }

    public String getResult() {
        return result;
    }

    // Final score
    public void setScore() {
        score = sum + bonus;
    }

    public int getScore() {
        return score;
    }

    // Print score and game results
    public void prtScoreResults(LocalDate currentDate) {
        System.out.println("\n*** Game " + game + " Results ***");
        System.out.println("Date: " + currentDate);
        System.out.println("Roll: " + dice[0] + ", " + dice[1] + ", " + dice[2]);
        if (!result.isEmpty()) {
            System.out.println(result + "! +" + bonus + " bonus points");
        }
        System.out.println("Score: " + score);
        System.out.println("*******************\n");
    }
}

// Session class
class Session {
    private String name;
    private String playAgain;

    // Set player name
    public void setName(Scanner scanner) {
        System.out.println("3311 3-Dice Game");
        System.out.print("Please enter your first name: ");
        this.name = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    // Print welcome message
    public void prtWelcome() {
        System.out.println("\nWelcome to the 3311 3-Dice Game, " + name + ".");
        System.out.println("\nRules of the game.");
        System.out.println("In this game, the computer \"rolls\" 3 dice for you.");
        System.out.println("You earn points based on the sum of the 3 dice.");
        System.out.println("If you roll a pair from the 3 dice (aka Doublet), you earn 5 bonus points.");
        System.out.println("If you roll three-of-a-kind (aka Triplet), you earn 20 bonus points.");
        System.out.println("BEST OF LUCK!\n");
    }

    // Print play again
    public void setPlayAgain(Scanner scanner) {
        System.out.print("Would you like to play again? (Y or N): ");
        this.playAgain = scanner.nextLine().toUpperCase();
    }

    public String getPlayAgain() {
        return playAgain;
    }

    // Print goodbye message
    public void prtOutMessage() {
        System.out.println("\nThank you, " + name + ", for playing the 3311 3-Dice Game.");
        System.out.println("We hope you enjoyed it.");
        System.out.println("Come back soon to play again!");
        System.out.println("So long...");
    }
}
