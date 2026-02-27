import java.util.Scanner;

class PalindromeService {

    public boolean isPalindrome(String input) {

        if (input == null) {
            return false;
        }

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            while (start < end && !Character.isLetterOrDigit(input.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(input.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(input.charAt(start)) !=
                    Character.toLowerCase(input.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeService service = new PalindromeService();

        boolean result = service.isPalindrome(input);

        if (result) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }

        sc.close();
    }
}