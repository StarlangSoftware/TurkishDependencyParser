package DependencyParser;

public class DependencyRelation {
    protected int toWord;

    /**
     * Constructor for a {@link DependencyRelation}. Takes toWord as a parameter and sets the corresponding attribute.
     * @param toWord Index of the word in the sentence that dependency relation is related
     */
    protected DependencyRelation(int toWord){
        this.toWord = toWord;
    }

    /**
     * Accessor for toWord attribute
     * @return toWord attribute value
     */
    public int to(){
        return toWord;
    }

}
