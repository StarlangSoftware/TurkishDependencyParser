package DependencyParser;

import Corpus.Sentence;
import org.w3c.dom.Node;

public class TurkishDependencyTreeBankSentence extends Sentence{

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
