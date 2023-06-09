import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int round = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess a number between " + minRange + " and " + maxRange);
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    int roundScore = maxAttempts - attempts;
                    score += roundScore;
                    System.out.println("Score for this round: " + roundScore);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("The secret number is higher than your guess.");
                } else {
                    System.out.println("The secret number is lower than your guess.");
                }

                attempts++;
            }

            if (attempts >= maxAttempts) {
                System.out.println("Oops! You have reached the maximum number of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
        }

        System.out.println("\nGame over!");
        System.out.println("Your total score: " + score);
        scanner.close();
    }
}