import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running){
            System.out.println("\nGame Guess the number\n");
            System.out.println("1 - game with bot \n2 - game with friend\n3 - Exit");
            System.out.println("Select mode:");
            int playerState = scanner.nextInt();
            int playerNum = 0;
            int attempts = 0;
            int secretNumber_friend = 0;

            if (playerState == 1) {
                System.out.println("with bot");
                int secretNumber_bot = random.nextInt(100) + 1;

                while (secretNumber_bot  != playerNum) {
                    System.out.println("Guess the number (1/100): ");
                    playerNum = scanner.nextInt();
                    attempts ++;

                    if (playerNum > secretNumber_bot ) {
                        System.out.println("\uD83D\uDCC9 less");
                    } else if (playerNum < secretNumber_bot ) {
                        System.out.println("\uD83D\uDCC8 more");
                    } else {
                        System.out.println("\uD83C\uDF89 You guessed the number, congratulations! " + secretNumber_bot);
                        System.out.println("Number of attempts: " + attempts);
                        attempts = 0;
                    }
                }
            } else if (playerState == 2) {
                System.out.println("with friend");
                boolean run_friend = true;
                while (run_friend) {
                    System.out.println("choose a number for a friend (1/100):");
                    secretNumber_friend = scanner.nextInt();
                    if (secretNumber_friend < 1) {
                        System.out.println("Please enter a number between 1 and 100.");
                    } else if (secretNumber_friend > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                    } else {
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.println("The number meets all requirements. Now we hide it.\n");
                        while (playerNum != secretNumber_friend) {
                            System.out.println("guess the number (1/100): ");
                            playerNum = scanner.nextInt();
                            attempts ++;

                            if (playerNum > secretNumber_friend ) {
                                System.out.println("\uD83D\uDCC9 less");
                            } else if (playerNum < secretNumber_friend ) {
                                System.out.println("\uD83D\uDCC8 more");
                            } else {
                                System.out.println("\uD83C\uDF89 You guessed the number, congratulations! " + secretNumber_friend);
                                System.out.println("Number of attempts: " + attempts);
                                attempts = 0;
                                run_friend = false;
                            }
                        }
                    }
                }
            } else if (playerState == 3) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Exit");
                running = false;
            }
        }
    }
}