package DependencyParser.Universal;

import Corpus.Sentence;

import java.util.ArrayList;
import java.util.HashMap;

public class UniversalDependencyTreeBankSentence extends Sentence {
    private ArrayList<String> comments;

    public UniversalDependencyTreeBankSentence(){
        super();
        comments = new ArrayList<>();
    }

    public void addComment(String comment){
        comments.add(comment);
    }
}
