package DependencyParser;

import Corpus.Sentence;
import org.w3c.dom.Node;

public class TurkishDependencyTreeBankSentence extends Sentence{

    /**
     * Given the parsed xml node which contains information about a sentence, the method constructs a
     * {@link TurkishDependencyTreeBankSentence} from it.
     * @param sentenceNode Xml parsed node containing information about a sentence.
     */
    public TurkishDependencyTreeBankSentence(Node sentenceNode){
        super();
        Node wordNode;
        TurkishDependencyTreeBankWord word;
        wordNode = sentenceNode.getFirstChild();
        while (wordNode != null){
            word = new TurkishDependencyTreeBankWord(wordNode);
            words.add(word);
            wordNode = wordNode.getNextSibling();
        }
    }

    /**
     * Calculates the maximum of all word to related word distances, where the distances are calculated in terms of
     * index differences.
     * @return Maximum of all word to related word distances.
     */
    public int maxDependencyLength(){
        int max = 0;
        for (int i = 0; i < words.size(); i++){
            TurkishDependencyTreeBankWord word = (TurkishDependencyTreeBankWord) words.get(i);
            if (word.getRelation() != null && word.getRelation().to() - i > max){
                max = word.getRelation().to() - i;
            }
        }
        return max;
    }

}
