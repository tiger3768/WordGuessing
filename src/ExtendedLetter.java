/**
 * This class is a subclass of Letter.
 * It adds extra features and methods.
 * {@link} Letter
 *
 */
public class ExtendedLetter extends Letter {
    private String content;
    private int family;
    private boolean related;

    private static final int SINGLETON = -1;

    /**
     * Constructs an ExtendedLetter object with the given content.
     *
     * @param s the content of the extended letter
     */
    public ExtendedLetter(String s) {
        super('/');
        content = s;
        related = false;
        family = SINGLETON;
    }

    /**
     * Constructs an ExtendedLetter object with the given content and family.
     *
     * @param s the content of the extended letter
     * @param fam the family of the extended letter
     */
    public ExtendedLetter(String s, int fam) {
        super('/');
        content = s;
        related = false;
        family = fam;
    }

    /**
     * Checks if the ExtendedLetter object is equal to another object,
     * by comparing the content of the ExtendedLetter.
     * <br>If the other object has the same family,
     * the related status of this object is set to true.
     *
     * @param other the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
    	if (!(other instanceof ExtendedLetter)) return false;

        ExtendedLetter otherLetter = (ExtendedLetter) other;
        if (otherLetter.family == this.family) this.related = true;
   
        return otherLetter.content.equals(this.content);
    }

    /**
     * Returns a string representation of the ExtendedLetter object.
     *
     * @return the string representation of the extended letter
     */
    @Override
    public String toString() {
        if (isUnused() && related) return "." + content + ".";
        else return super.decorator() + content + super.decorator();
    }

    /**
     * Creates an array of Letter objects from the given content and codes.
     * 
     * @param content the array of content
     * @param codes the array of family codes
     * @return an array of Letter objects
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];

        for (int i = 0; i < content.length; i++) {
            if (codes == null) letters[i] = new ExtendedLetter(content[i]);
            else letters[i] = new ExtendedLetter(content[i], codes[i]);
        }

        return letters;
    }
}
