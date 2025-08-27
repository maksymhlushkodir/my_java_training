import java.util.Scanner;
import java.util.Random;

public class SimilaritiesMenu {

    public static void calculator(Scanner scanner, boolean work_calculator){
        while (work_calculator == true){
            System.out.println("Num1:");
            int num1 = scanner.nextInt();
            System.out.println("Num2:");
            int num2 = scanner.nextInt();

            System.out.println("| 1. Sum (+) | 2. Difference (-) | 3. Product (*) | 4. Quotient (/) | 5. Remainder (%) |");
            System.out.println("choose what to do:");
            int choice_calculator_operators = scanner.nextInt();

            switch (choice_calculator_operators) {
                case 1:
                    int sum = num1 + num2;
                    System.out.println("Sum: " + sum);
                    break;
                case 2:
                    int difference = num1 - num2;
                    System.out.println("Difference: " + difference);
                    break;
                case 3:
                    int product = num1 * num2;
                    System.out.println("Product: " + product);
                    break;
                case 4:
                    double quotient = (double) num1 / num2;
                    System.out.println("Quotient: " + quotient);
                    break;
                case 5:
                    int remainder = num1 % num2;
                    System.out.println("Remainder: " + remainder);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
            System.out.println("| 1. Again | 2. Exit |");
            int choice_calculator_menu = scanner.nextInt();

            switch (choice_calculator_menu) {
                case 1:
                    System.out.println();
                    break;
                case 2:
                    work_calculator = false;
                    break;
            }
        }
    }

    public static void greetings(){
        System.out.println("Hi, this is the second hour of learning Java");
    }

    public static void guess_the_number(Random rand, Scanner scanner,
                                        boolean work_guess_the_number) {
        int attempts = 0;
        int secret_number = rand.nextInt(100) + 1;
        while (work_guess_the_number) {
            System.out.println("Guess the number (1 - 100): ");
            int user_num = scanner.nextInt();
            attempts ++;

            if (user_num > secret_number) {
                System.out.println("\uD83D\uDCC9 less");
            } else if (user_num < secret_number) {
                System.out.println("\uD83D\uDCC8 more");
            } else {
                System.out.println("\uD83C\uDF89 You guessed the number, congratulations! " + secret_number);
                System.out.println("Number of attempts: " + attempts);
                attempts = 0;

                System.out.println("| 1. Again | 2. Exit |");
                int choice_calculator_menu = scanner.nextInt();

                switch (choice_calculator_menu) {
                    case 1:
                        System.out.println();
                        secret_number = rand.nextInt(100) + 1;
                        break;
                    case 2:
                        work_guess_the_number = false;
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;
        while (running) {

            System.out.println("| 1. Greetings | 2. Calculator | 3. Game 'Guess the number' | 4. Exit |");
            System.out.println("your choice: ");
            int Menu_choice = scanner.nextInt();

            switch (Menu_choice) {
                case 1:
                    greetings();
                    break;
                case 2:
                    boolean work_calculator = true;
                    calculator(scanner, work_calculator);
                    break;
                case 3:
                    boolean work_guess_the_number = true;
                    guess_the_number(rand, scanner, work_guess_the_number);
                    break;
                case 4:
                    running = false;
                    break;
            }
        }

    }
}
