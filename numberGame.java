
    import java.util.Random;
    import java.util.Scanner;
    
    
    public class numberGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            
            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 3;
            int score = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I've Choosen a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            boolean start = true;
            while (start) {
                int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    
                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed it right.");
                        score++;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                    
                    attempts++;
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was " + targetNumber + ".");
                }
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                start = playAgainInput.equalsIgnoreCase("yes");
            }
            
            System.out.println("Game over! Your total score is: " + score);
            scanner.close();
        }
    }
     