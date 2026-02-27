import java.util.Scanner;
import java.util.Stack;

class PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Two Pointer Strategy (Optimized)
    static class TwoPointerStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            if (input == null) return false;

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

            if (input == null) return false;

            Stack<Character> stack = new Stack<>();

// Push characters into stack
            for (char c : input.toCharArray()) {
                stack.push(c);
            }

// Compare while popping
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Context Class
    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
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
        sc.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new TwoPointerStrategy();
        } else {
            strategy = new StackStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }

        sc.close();
    }
}