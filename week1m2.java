import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        text = text.toLowerCase();
        int left = 0, right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        text = text.toLowerCase();
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        text = text.toLowerCase();
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String text = scanner.nextLine();

        boolean iterativeRes = isPalindromeIterative(text);
        boolean recursiveRes = isPalindromeRecursive(text);
        boolean arrayRes = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + (iterativeRes ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (recursiveRes ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arrayRes ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}