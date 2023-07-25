/**
 * This class represents a word.
 *
 */
public class Word {
    private LinearNode<Letter> firstLetter;
    
    /**
     * Constructs a Word object with the given array of letters.
     *
     * @param letters the array of letters to construct the word from
     */
    public Word(Letter[] letters) {
        if (letters.length == 0) firstLetter = null;
        else {
            firstLetter = new LinearNode<>(letters[0]);
            LinearNode<Letter> current = firstLetter;
            
            for (int i = 1; i < letters.length; i++) {
                LinearNode<Letter> newNode = new LinearNode<>(letters[i]);
                current.setNext(newNode);
                current = newNode;
            }
        }
    }

    /**
     * Returns a string representation of the Word object.
     *
     * @return a string representation of the word
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Word: ");
        LinearNode<Letter> current = firstLetter;

        while (current != null) {
            sb.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        
        return sb.toString();
    }
    
    /**
     * This is a private helper method.
     * Finds the length of a linked list.
     *
     * @param list the head of the linked list
     * @return the length of the linked list
     */
    private int findLength(LinearNode<Letter> list) {
    	int n = 0;
    	
    	while(list != null) {
    		++n;
    		list = list.getNext();
    	}
    	
    	return n;
    }

    /**
     * Labels the letters in the word based on the corresponding letters in the mystery word.
     * <br>Sets the label for each letter as used if the mystery word uses that letter.
     * <br>Sets the label as correct if the mystery word uses that letter and is present at the same location.
     * <br>Sets the label as unused if the mystery word doesn't use that letter.
     *
     * @param mystery the mystery word to compare with
     * @return true if the word is identical to the mystery word, false otherwise
     */
    public boolean labelWord(Word mystery) {
        LinearNode<Letter> current = firstLetter;
        LinearNode<Letter> mysteryCurrent = mystery.firstLetter;
        boolean isIdentical = true;
        
        int n = findLength(current);
        int m = findLength(mysteryCurrent);
        if(n != m) isIdentical = false;
        
        for(int i = 0 ; i < n ; i++) {
        	Letter currentLetter = current.getElement();
        	currentLetter.setUnused();
        	LinearNode<Letter> temporary = mysteryCurrent;
        	boolean flag = false;
        	
        	for(int j = 0 ; j < m ; j++) {
        		Letter mysteryLetter = temporary.getElement();
        		if(currentLetter.equals(mysteryLetter)) {
        			currentLetter.setUsed();
        			if(i == j) {
        				currentLetter.setCorrect();
        				flag = true;
        				break;
        			}
        		}
        		temporary = temporary.getNext();
        	}
        	isIdentical = isIdentical && flag;
        	current = current.getNext();
        }
        
        return isIdentical;
    }
}
