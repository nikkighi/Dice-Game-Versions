package projects;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;

public class P3_Getting_Started {

    // Declare Scanner variable
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Declare variables
        int die1, die2, die3;
        int score;
        int tempDie;
        int games; // number of games player wants to play
        LocalDate currentDate;
        String firstName;
        String playAgain;

        // Instantiate objects
        Random random = new Random(); // Randomizer
        currentDate = LocalDate.now(); // Local date

        // Prompt for and read-in the user's name
        firstName = getName();

        // Welcome message and game rules
        prtWelcome(firstName);

        // Start the do-while loop to enable the user to play again
        do {
            // Prompt for and read-in the number of games to be played
            games = getGames();
            scanner.nextLine();
            System.out.println();

            // Start the for loop to control the number of games and prompt key to start game
            for (int game = 1; game <= games; game++) {
                System.out.print("Press and enter any key to begin the game: ");
                System.out.println();
                scanner.nextLine(); // Wait for user to press a key
                System.out.println("\n*** Game " + game + " Results ***");

                // Roll the dice
                die1 = getDie(random);
                die2 = getDie(random);
                die3 = getDie(random);

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
                int bonus = getBonus(die1, die2, die3);
                score += bonus;
                String result = getResult(bonus);
                if (!result.isEmpty()) {
                    System.out.println(result + "! +" + bonus + " bonus points");
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
            playAgain = getPlayAgain();
            System.out.println();
            
            // End of the do-while loop
        } while (playAgain.equals("Y"));

        // Print the outro message
        prtOutMessage(firstName);

        // Close the scanner
        scanner.close();
    }

	    // Start methods
	    
	    // getName
	    public static String getName() {
	        System.out.println("3311 3-Dice Game");
	        System.out.print("Please enter your first name: ");
	        return scanner.nextLine();
	    }
	    
	    // prtWelcome
	    public static void prtWelcome(String name) {
	        System.out.println();
	        System.out.println("Welcome to the 3311 3-Dice Game, " + name + ".");
	        System.out.println();
	        System.out.println("Rules of the game.");
	        System.out.println("In this game, the computer \"rolls\" 3 dice for you.");
	        System.out.println("You earn points based on the sum of the 3 dice.");
	        System.out.println("If you roll a pair from the 3 dice (aka Doublet), you earn 5 bonus points.");
	        System.out.println("If you roll three-of-a-kind (aka Triplet), you earn 20 bonus points.");
	        System.out.println("BEST OF LUCK!");
	        System.out.println();
	    }
	    
	    // getGames
	    public static int getGames() {
	        System.out.print("How many games would you like to play? ");
	        return scanner.nextInt();
	    }
	    
	    // getDie
	    public static int getDie(Random rand) {
	        return rand.nextInt(6) + 1;
	    }
	    
	    // getBonus
	    public static int getBonus(int die1, int die2, int die3) {
	        if (die1 == die2 && die2 == die3) {
	            return 20; // Triplet
	        } else if (die1 == die2 || die2 == die3 || die1 == die3) {
	            return 5; // Doublet
	        }
	        return 0; 
	    }
	    
	    // getResult
	    public static String getResult(int bonus) {
	        if (bonus == 20) {
	            return "Triplet";
	        } else if (bonus == 5) {
	            return "Doublet";
	        }
	        return "";
	    }
	    
	    // getPlayAgain
	    public static String getPlayAgain() {
	        System.out.print("Would you like to play again? (Y or N): ");
	        return scanner.next().toUpperCase();
	    }
	    
	    // prtOutMessage
	    public static void prtOutMessage(String name) {
	        System.out.println();
	        System.out.println("Thank you, " + name + ", for playing the 3311 3-Dice Game.");
	        System.out.println("We hope you enjoyed it.");
	        System.out.println("Come back soon to play again!");
	        System.out.println("So long...");
	   }
}
