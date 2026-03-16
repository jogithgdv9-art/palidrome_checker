import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Two Pointer Strategy
    static class TwoPointerStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            int start = 0;
            int end = input.length() - 1;

            while (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Reverse String Method
    public static boolean reversePalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    // Context Class
    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.check(input);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Two Pointer Strategy");
        System.out.println("2. Stack Strategy");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new TwoPointerStrategy();
        } else {
            strategy = new StackStrategy();
        }

        // Strategy Pattern Execution
        PalindromeContext context = new PalindromeContext(strategy);

        long startTime = System.nanoTime();
        boolean result = context.execute(input);
        long endTime = System.nanoTime();
        long strategyTime = endTime - startTime;

        // Reverse Method Timing
        startTime = System.nanoTime();
        boolean reverseResult = reversePalindrome(input);
        endTime = System.nanoTime();
        long reverseTime = endTime - startTime;

        // Stack Direct Method Timing
        startTime = System.nanoTime();
        boolean stackResult = new StackStrategy().check(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        System.out.println("\nPalindrome Check for: " + input);
        System.out.println("--------------------------------");

        System.out.println("Chosen Strategy Result: " + result);
        System.out.println("Execution Time: " + strategyTime + " ns");

        System.out.println("\nReverse String Method: " + reverseResult);
        System.out.println("Execution Time: " + reverseTime + " ns");

        System.out.println("\nStack Method: " + stackResult);
        System.out.println("Execution Time: " + stackTime + " ns");

        sc.close();
    }
}