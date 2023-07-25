/**
 * This class represents a letter.
 * Each letter has an integer label namely UNSET, UNSUSED, USED and CORRECT 
 * indicating it's state with respect to the mystery word.
 *
 */
public class Letter {
    private char letter;
    private int label;

    private static final int UNSET = 0;
    private static final int UNUSED = 1;
    private static final int USED = 2;
    private static final int CORRECT = 3;

    /**
	 * Constructs a Letter object with the given character.
	 *
	 * @param c the character representing the letter
	 */
    public Letter(char c) {
        letter = c;
        label = UNSET;
    }
    
    /**
     * Checks whether two Letter objects are the same or not,
     * by comparing their letter field.
     * 
     * 
     */
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetter = (Letter) otherObject;
            return this.letter == otherLetter.letter;
        }
        else return false;
    }
    
    /**
     * Returns a decorator string based on the label of the letter.
     *
     * @return the decorator string
     */
    public String decorator() {
        switch (label) {
            case USED:
                return "+";
            case UNUSED:
                return "-";
            case CORRECT:
                return "!";
            default:
                return " ";
        }
    }

    /**
     * Returns a string representation of the Letter object.
     *
     * @return the string representation of the letter
     */
    public String toString() {
        return decorator() + letter + decorator();
    }

    /**
     * Sets the label of the letter to UNUSED.
     */
    public void setUnused() {
        label = UNUSED;
    }

    /**
     * Sets the label of the letter to USED.
     */
    public void setUsed() {
        label = USED;
    }

    /**
     * Sets the label of the letter to CORRECT.
     */
    public void setCorrect() {
        label = CORRECT;
    }

    /**
     * Checks whether the label of the letter is UNUSED.
     *
     * @return true if the letter is unused, false otherwise
     */
    public boolean isUnused() {
        return label == UNUSED;
    }

    /**
     * Creates an array of Letter objects from the given string.
     * Each character in the string represents a Letter object.
     *
     * @param s the string to create the array from
     * @return an array of Letter objects
     */
    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) letters[i] = new Letter(s.charAt(i));
        return letters;
    }
}
