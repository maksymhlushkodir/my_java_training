public class MiniCalculator {
    public static void main(String[] args) {
        int x = 12;
        int y = 3;

        int sum = x + y;
        int difference = x - y;
        int product = x * y;
        double quotient = (double) x / y;
        int remainder = x % y;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}