package DependencyParser.Universal;

import Corpus.Sentence;
import Dictionary.Word;

import java.util.ArrayList;

public class UniversalDependencyTreeBankSentence extends Sentence {
    private ArrayList<String> comments;

    public UniversalDependencyTreeBankSentence(){
        super();
        comments = new ArrayList<>();
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public String toString(){
        String result = "";
        for (String comment : comments){
            result += comment + "\n";
        }
        for (Word w : words){
            UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) w;
            result += word.toString() + "\n";
        }
        return result;
    }
}
