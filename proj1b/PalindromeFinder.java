/**
 * This class outputs all palindromes in the words file in the current
 * directory.
 */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        int off;
        try {
            off = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e1) {
            off = 0;
        } catch (NumberFormatException e2) {
            off = 0;
            System.out.println("Usage: PalindromeFinder [N]");
            System.out.println("The optional parameter `N` must be an integer. Continue with the default value of 0...");
        }
        CharacterComparator offByN = new OffByN(off);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offByN)) {
                System.out.println(word);
            }
        }
    }
}
