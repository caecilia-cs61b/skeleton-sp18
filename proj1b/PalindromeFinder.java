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
        } catch (Exception e) {
            off = 0;
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
