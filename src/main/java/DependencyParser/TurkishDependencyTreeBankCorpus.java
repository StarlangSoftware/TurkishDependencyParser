package DependencyParser;

import Corpus.Corpus;
import DataStructure.CounterHashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
        Node rootNode, sentenceNode;
        TurkishDependencyTreeBankSentence sentence;
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            doc = builder.parse(new InputSource(classLoader.getResourceAsStream(fileName)));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
