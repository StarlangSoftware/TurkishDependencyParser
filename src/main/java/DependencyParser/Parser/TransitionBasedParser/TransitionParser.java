package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import Classification.DataSet.DataSet;
import Classification.Instance.Instance;
import DependencyParser.Universal.*;

import java.util.ArrayList;

public abstract class TransitionParser {

    public TransitionParser() {
    }

    protected UniversalDependencyTreeBankSentence createResultSentence(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence) {
        UniversalDependencyTreeBankSentence sentence = new UniversalDependencyTreeBankSentence();
        for (int i = 0; i < universalDependencyTreeBankSentence.wordCount(); i++) {
            UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) universalDependencyTreeBankSentence.getWord(i);
            sentence.addWord(new UniversalDependencyTreeBankWord(word.getId(), word.getName(), word.getLemma(), word.getUpos(), word.getXpos(), word.getFeatures(), null, word.getDeps(), word.getMisc()));
        }
        return sentence;
    }

    public DataSet simulateParse(UniversalDependencyTreeBankCorpus corpus, int windowSize) {
        DataSet dataSet = new DataSet();
        for (int i = 0; i < corpus.sentenceCount(); i++) {
            dataSet.addInstanceList(simulateParse((UniversalDependencyTreeBankSentence) corpus.getSentence(i), windowSize));
        }
        return dataSet;
    }

    public abstract ArrayList<Instance> simulateParse(UniversalDependencyTreeBankSentence sentence, int windowSize);

    public abstract UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, Oracle oracle);

    public UniversalDependencyTreeBankCorpus dependencyParse(UniversalDependencyTreeBankCorpus universalDependencyTreeBankCorpus, Oracle oracle) {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus();
        for (int i = 0; i < universalDependencyTreeBankCorpus.sentenceCount(); i++) {
            UniversalDependencyTreeBankSentence sentence = (UniversalDependencyTreeBankSentence) universalDependencyTreeBankCorpus.getSentence(i);
            corpus.addSentence(dependencyParse(sentence, oracle));
        }
        return corpus;
    }
}
