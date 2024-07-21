import java.util.*;

public class NumberGuessingGame_Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 5; // Maximum number of attempts allowed per round
        int score = 0; // Initialize score counter
        
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        
        while (playAgain) {
            int secretNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            System.out.println("I'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND);
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number (" + secretNumber + ") in " + attempts + " attempts.");
                    score += MAX_ATTEMPTS - attempts + 1; // Adjust score based on attempts left
                    guessedCorrectly = true;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Game ended. Your total score is: " + score);
        scanner.close();
    }
}
