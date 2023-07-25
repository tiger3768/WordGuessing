/**
 * The WordLL class represents a central hub for information about a WordLL game.
 */
public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    /**
     * Constructs a WordLL object with the given mystery word.
     *
     * @param mystery the mystery word to be guessed
     */
    public WordLL(Word mystery) {
        mysteryWord = mystery;
        history = null;
    }

    /**
     * Tries a word guess and updates the history.
     * Adds the guess word to the front of the history.
     *
     * @param guess the word guess to be tried
     * @return true if the guess word is identical to the mystery word, false otherwise
     */
    public boolean tryWord(Word guess) {
    	LinearNode<Word> newNode = new LinearNode<>(guess);
        newNode.setNext(history);
        history = newNode;
        
        return guess.labelWord(mysteryWord);
    }

    /**
     * Returns a string representation of the past word guesses in the history.
     *
     * @return the string representation of the word guess history
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<Word> current = history;

        while (current != null) {
            sb.append(current.getElement()).append("\n");
            current = current.getNext();
        }

        return sb.toString();
    }
}
