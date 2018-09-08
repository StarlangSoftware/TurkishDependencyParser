package DependencyParser;

public class DependencyRelation {
    protected int toWord;

    protected DependencyRelation(int toWord){
        this.toWord = toWord;
    }

    public int to(){
        return toWord;
    }

}
