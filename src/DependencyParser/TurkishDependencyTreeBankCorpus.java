package DependencyParser;

import Corpus.Corpus;
import DataStructure.CounterHashMap;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;

public class TurkishDependencyTreeBankCorpus extends Corpus{

    public TurkishDependencyTreeBankCorpus(){
        sentences = new ArrayList<>();
        wordList = new CounterHashMap<>();
    }

    public TurkishDependencyTreeBankCorpus emptyCopy(){
        return new TurkishDependencyTreeBankCorpus();
    }

    public TurkishDependencyTreeBankCorpus(String fileName){
        super();
        Node rootNode, sentenceNode;
        TurkishDependencyTreeBankSentence sentence;
        Document doc;
        DOMParser parser = new DOMParser();
        try {
            parser.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc = parser.getDocument();
        rootNode = doc.getFirstChild();
        sentenceNode = rootNode.getFirstChild();
        while (sentenceNode != null){
            if (sentenceNode.getNodeValue() == null){
                sentence = new TurkishDependencyTreeBankSentence(sentenceNode);
                sentences.add(sentence);
            }
            sentenceNode = sentenceNode.getNextSibling();
        }
    }
}
