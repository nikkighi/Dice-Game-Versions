package projects;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class P1_Getting_Started {
	
	/*
	// Developer: Nikita Ghimire
	// Date: 09/02/2024
	// System description: 
	 * Implement a Java program that simulates the rolling of 3 dice
	 * and then evaluates the dice roll to determine points scored based on the game’s rules. 
	 * The game score is the sum of the dice plus bonus points for rolling a pair 
	 * (aka Doublet – 5 bonus points) or three-of-a kind (aka Triplet – 20 bonus points).  
	 * The score for the game is the sum of the dice plus the bonus points.
	*/

	
	    public static void main(String[] args) {
	    	
	    	// Declare variables
	        int die1, die2, die3;
	        int score;
	        int tempDie;
	        LocalDate currentDate;
	        String firstName;
	    
	        // Instantiate objects
	        	// Scanner
	        Scanner scanner = new Scanner(System.in);
	        	// Randomizer
	        Random random = new Random();
	        	// Local date
	        currentDate = LocalDate.now();

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
	        System.out.print("Press and enter any key to begin the game: ");

	        // Prompt for any key to start the game
	        scanner.nextLine(); 

	        // Roll the dice
	        random.nextInt(6);
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
	        	// Sum
	        score = die1 + die2 + die3;
	        	// Determine doublet/triplet
	        if (die1 == die2 && die2 == die3) {
	            // Triplet
	            score += 20;
	        } else if (die1 == die2 || die2 == die3 || die1 == die3) {
	            // Doublet
	            score += 5;
	        }

	        // Print final score and results
	        System.out.println();
	        System.out.println("*** Game Results ***");
	        System.out.println("Date: " + currentDate);
	        System.out.println("Roll: " + die1 + "," + die2 + "," + die3);
	        System.out.println("Score: " + score);
	        System.out.println("*******************");

	        // Print outro message
	        System.out.println();
	        System.out.println("Thank you, " + firstName + ", for playing the 3311 3-Dice Game.");
	        System.out.println("We hope you enjoyed it.");
	        System.out.println("Come back soon to play again!");
	        System.out.println("So long...");

	        // Close the scanner
	        scanner.close();
	    }
	}	
	  