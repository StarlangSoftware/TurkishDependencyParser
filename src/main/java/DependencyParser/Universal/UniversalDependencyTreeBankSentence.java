package DependencyParser.Universal;

import Corpus.Sentence;
import DependencyParser.ParserEvaluationScore;
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

    public ParserEvaluationScore compareParses(UniversalDependencyTreeBankSentence sentence){
        ParserEvaluationScore score = new ParserEvaluationScore();
        for (int i = 0; i < words.size(); i++){
            UniversalDependencyRelation relation1 = ((UniversalDependencyTreeBankWord) words.get(i)).getRelation();
            UniversalDependencyRelation relation2 = ((UniversalDependencyTreeBankWord) sentence.getWord(i)).getRelation();
            if (relation1 != null && relation2 != null){
                score.add(relation1.compareRelations(relation2));
            }
        }
        return score;
    }
}
