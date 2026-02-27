import java.util.Scanner;
import java.util.Stack;

class PalindromeCheckerApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("system initialized successfully");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();



        Stack<Character> stack = new Stack<>();


        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;


        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }

        sc.close();
    }
}