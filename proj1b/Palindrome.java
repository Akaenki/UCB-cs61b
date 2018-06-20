public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<>();
        for(int i = 0; i<word.length(); i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /** Helper function for recursive check */
    private boolean isPalindrome(Deque d){
        if(d.size() <= 1){
            return true;
        }

        if(d.removeFirst() == d.removeLast()){
            return isPalindrome(d);
        } else{
            return false;
        }
    }

    /** Overloading: Java allows method with same name but different
     *  types of input.
     */
    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        return isPalindrome(d);
    }

    private boolean isPalindrome(Deque d, CharacterComparator cc){
        if(d.size() <= 1){
            return true;
        }

        char c1 = (char) d.removeFirst();
        char c2 = (char) d.removeLast();
        if(cc.equalChars(c1,c2)){
            return isPalindrome(d,cc);
        } else{
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque d = wordToDeque(word);
        return isPalindrome(d, cc);
    }
}
