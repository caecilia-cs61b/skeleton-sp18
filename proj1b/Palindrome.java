public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> result = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    private class CharacterEquals implements CharacterComparator {
        @Override
        public boolean equalChars(char x, char y) {
            return x == y;
        }
    }

    private boolean isPalindrome(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        } else {
            Character head = deque.removeFirst();
            Character tail = deque.removeLast();
            return cc.equalChars(head, tail) && isPalindrome(deque, cc);
        }
    }

    private boolean isPalindrome(Deque<Character> deque) {
        return isPalindrome(deque, new CharacterEquals());
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }
}
