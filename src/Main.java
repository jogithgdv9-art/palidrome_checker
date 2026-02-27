import java.util.Scanner;

class PalindromeCheckerApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("system initialized successfully");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if(input.charAt(i) != input.charAt(input.length() - 1 - i)){
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println("Is it a Palindrome? : true...");
        }else{
            System.out.println("Is it a Palindrome? : false...");
        }

        sc.close();
    }
}