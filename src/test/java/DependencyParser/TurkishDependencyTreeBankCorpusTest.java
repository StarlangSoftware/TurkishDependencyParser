package DependencyParser;

import DataStructure.CounterHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurkishDependencyTreeBankCorpusTest {

    @Test
    public void testDependencyCorpus() {
        CounterHashMap<TurkishDependencyType> relationCounts = new CounterHashMap<>();
        TurkishDependencyTreeBankCorpus corpus = new TurkishDependencyTreeBankCorpus("metu-treebank.xml");
        assertEquals(5635, corpus.sentenceCount());
        int wordCount = 0;
        for (int i = 0; i < corpus.sentenceCount(); i++){
            TurkishDependencyTreeBankSentence sentence = (TurkishDependencyTreeBankSentence) corpus.getSentence(i);
            wordCount += sentence.wordCount();
            for (int j = 0; j < sentence.wordCount(); j++){
                TurkishDependencyTreeBankWord word = (TurkishDependencyTreeBankWord) sentence.getWord(j);
                if (word.getRelation() != null){
                    relationCounts.put(word.getRelation().getTurkishDependencyType());
                }
            }
        }
        assertEquals(11692, (int) relationCounts.get(TurkishDependencyType.MODIFIER));
        assertEquals(903, (int) relationCounts.get(TurkishDependencyType.INTENSIFIER));
        assertEquals(1142, (int) relationCounts.get(TurkishDependencyType.LOCATIVE_ADJUNCT));
        assertEquals(240, (int) relationCounts.get(TurkishDependencyType.VOCATIVE));
        assertEquals(7261, (int) relationCounts.get(TurkishDependencyType.SENTENCE));
        assertEquals(16, (int) relationCounts.get(TurkishDependencyType.EQU_ADJUNCT));
        assertEquals(159, (int) relationCounts.get(TurkishDependencyType.NEGATIVE_PARTICLE));
        assertEquals(4481, (int) relationCounts.get(TurkishDependencyType.SUBJECT));
        assertEquals(2476, (int) relationCounts.get(TurkishDependencyType.COORDINATION));
        assertEquals(2050, (int) relationCounts.get(TurkishDependencyType.CLASSIFIER));
        assertEquals(73, (int) relationCounts.get(TurkishDependencyType.COLLOCATION));
        assertEquals(1516, (int) relationCounts.get(TurkishDependencyType.POSSESSOR));
        assertEquals(523, (int) relationCounts.get(TurkishDependencyType.ABLATIVE_ADJUNCT));
        assertEquals(23, (int) relationCounts.get(TurkishDependencyType.FOCUS_PARTICLE));
        assertEquals(1952, (int) relationCounts.get(TurkishDependencyType.DETERMINER));
        assertEquals(1361, (int) relationCounts.get(TurkishDependencyType.DATIVE_ADJUNCT));
        assertEquals(202, (int) relationCounts.get(TurkishDependencyType.APPOSITION));
        assertEquals(289, (int) relationCounts.get(TurkishDependencyType.QUESTION_PARTICLE));
        assertEquals(597, (int) relationCounts.get(TurkishDependencyType.S_MODIFIER));
        assertEquals(10, (int) relationCounts.get(TurkishDependencyType.ETOL));
        assertEquals(8338, (int) relationCounts.get(TurkishDependencyType.OBJECT));
        assertEquals(271, (int) relationCounts.get(TurkishDependencyType.INSTRUMENTAL_ADJUNCT));
        assertEquals(85, (int) relationCounts.get(TurkishDependencyType.RELATIVIZER));
        assertEquals(53993, wordCount);
    }


}