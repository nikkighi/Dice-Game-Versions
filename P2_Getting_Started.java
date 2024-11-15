package projects;

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

public class P2_Getting_Started {
    public static void main(String[] args) {
    	
    	/*
    	// Developer: Nikita Ghimire
    	// Date: 09/16/2024
    	// System description: 
    	 * Implement a Java program that simulates the rolling of 3 dice
    	 * and then evaluates the dice roll to determine points scored based on the game’s rules. 
    	 * User is asked how many games they want to play and for each game
    	 * the game score is the sum of the dice plus bonus points for rolling a pair 
    	 * (aka Doublet – 5 bonus points) or three-of-a kind (aka Triplet – 20 bonus points).  
    	 * The score for the game is the sum of the dice plus the bonus points.
    	 * User is asked if they want to play again and the game restarts.
    	*/
    	
        // Declare variables
        int die1, die2, die3;
        int score;
        int tempDie;
        int games; // number of games player wants to play
        LocalDate currentDate;
        String firstName;
        String playAgain;

        // Instantiate objects
        Scanner scanner = new Scanner(System.in); // Scanner
        Random random = new Random(); // Randomizer
        currentDate = LocalDate.now(); // Local date

        // Prompt for and read-in the user's name
        System.out.println("3311 3-Dice Game");
        System.out.print("Please enter your first name: ");
        firstName = scanner.nextLine();

        // Welcome message and game rules
        System.out.println();
        System.out.println("Welcome to the 3311 3-Dice Game, " + firstName + ".");
        System.out.println();
        System.out.println("Rules of the game.");
        System.out.println("In this game, the computer \"rolls\" 3 dice for you.");
        System.out.println("You earn points based on the sum of the 3 dice.");
        System.out.println("If you roll a pair from the 3 dice (aka Doublet), you earn 5 bonus points.");
        System.out.println("If you roll three-of-a-kind (aka Triplet), you earn 20 bonus points.");
        System.out.println("BEST OF LUCK!");
        System.out.println();

        // Start the do-while loop to enable the user to play again
        do {
            // Prompt for and read-in the number of games to be played
            System.out.print("How many games would you like to play? ");
            games = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println();

            // Start the for loop to control the number of games and prompt key to start game
            for (int game = 1; game <= games; game++) {
            	 System.out.print("Press and enter any key to begin the game: ");
                 scanner.nextLine(); // Wait for user to press a key
                System.out.println("\n*** Game " + game + " Results ***");

                // Roll the dice
                die1 = random.nextInt(6) + 1; 
                die2 = random.nextInt(6) + 1; 
                die3 = random.nextInt(6) + 1; 

                // Sort dice rolls in numerical order
                if (die2 < die1) {
                    tempDie = die1;
                    die1 = die2;
                    die2 = tempDie;
                }
                if (die3 < die2) {
                    tempDie = die2;
                    die2 = die3;
                    die3 = tempDie;
                }
                if (die2 < die1) {
                    tempDie = die1;
                    die1 = die2;
                    die2 = tempDie;
                }

                // Evaluate dice
                score = die1 + die2 + die3; // Sum of dice rolls

                // Determine doublet or triplet
                if (die1 == die2 && die2 == die3) {
                    // Triplet
                    score += 20;
                    System.out.println("Triplet! +20 bonus points");
                } else if (die1 == die2 || die2 == die3 || die1 == die3) {
                    // Doublet
                    score += 5;
                    System.out.println("Doublet! +5 bonus points");
                }

                // Print final score and results
                System.out.println();
                System.out.println("Date: " + currentDate);
                System.out.println("Roll: " + die1 + ", " + die2 + ", " + die3);
                System.out.println("Score: " + score);
                System.out.println("*******************");
                System.out.println();
            }

            // Prompt for and read-in player's desire to play again
            System.out.print("Would you like to play again? (Y or N): ");
            playAgain = scanner.next().toUpperCase();
            scanner.nextLine(); 
            System.out.println();
            
            // End of the do-while loop
        } while (playAgain.equals("Y"));

        // Print the outro message
        System.out.println();
        System.out.println("Thank you, " + firstName + ", for playing the 3311 3-Dice Game.");
        System.out.println("We hope you enjoyed it.");
        System.out.println("Come back soon to play again!");
        System.out.println("So long...");

        // Close the scanner
        scanner.close();
    }
}

	  