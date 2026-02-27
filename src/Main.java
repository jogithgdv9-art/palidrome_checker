import java.util.Scanner;

class PalindromeCheckerApp{

    public static boolean isPalindrome(String str, int start, int end) {

        while (start < end && !Character.isLetterOrDigit(str.charAt(start))) {
            start++;
        }

        while (start < end && !Character.isLetterOrDigit(str.charAt(end))) {
            end--;
        }

        if (start >= end) {
            return true;
        }

        if (Character.toLowerCase(str.charAt(start)) !=
                Character.toLowerCase(str.charAt(end))) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }

        sc.close();
    }
}