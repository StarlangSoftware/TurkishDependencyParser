package DependencyParser.Turkish;

import Corpus.Corpus;
import DataStructure.CounterHashMap;
import Xml.XmlDocument;
import Xml.XmlElement;

import java.util.ArrayList;

public class TurkishDependencyTreeBankCorpus extends Corpus{

    /**
     * Empty constructor for {@link TurkishDependencyTreeBankCorpus}. Initializes the sentences and wordList attributes.
     */
    public TurkishDependencyTreeBankCorpus(){
        sentences = new ArrayList<>();
        wordList = new CounterHashMap<>();
    }

    /**
     * Constructor to create an empty copy of this corpus.
     * @return An empty copy of this corpus.
     */
    public TurkishDependencyTreeBankCorpus emptyCopy(){
        return new TurkishDependencyTreeBankCorpus();
    }

    /**
     * Another constructor for {@link TurkishDependencyTreeBankCorpus}. The method gets the corpus as an xml file, and
     * reads sentences one by one. For each sentence, the function constructs a TurkishDependencyTreeBankSentence.
     * @param fileName Input file name to read the TurkishDependencyTreeBankCorpus.
     */
    public TurkishDependencyTreeBankCorpus(String fileName){
        super();
        XmlElement rootNode, sentenceNode;
        TurkishDependencyTreeBankSentence sentence;
        ClassLoader classLoader = getClass().getClassLoader();
        XmlDocument doc = new XmlDocument(classLoader.getResourceAsStream(fileName));
        doc.parse();
        rootNode = doc.getFirstChild();
        sentenceNode = rootNode.getFirstChild();
        while (sentenceNode != null){
            sentence = new TurkishDependencyTreeBankSentence(sentenceNode);
            sentences.add(sentence);
            sentenceNode = sentenceNode.getNextSibling();
        }
    }
}
