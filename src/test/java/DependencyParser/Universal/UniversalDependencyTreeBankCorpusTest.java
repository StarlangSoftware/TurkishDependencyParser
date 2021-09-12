package DependencyParser.Universal;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversalDependencyTreeBankCorpusTest {

    private int wordCount(UniversalDependencyTreeBankCorpus corpus){
        int wordCount = 0;
        for (int i = 0; i < corpus.sentenceCount(); i++){
            wordCount += corpus.getSentence(i).wordCount();
        }
        return wordCount;
    }

    @Test
    public void testDependencyCorpus1() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_gb-ud-test.conllu");
        assertEquals(2802, corpus.sentenceCount());
        assertEquals(16881, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus2() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-dev.conllu");
        assertEquals(988, corpus.sentenceCount());
        assertEquals(10046, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus3() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-test.conllu");
        assertEquals(983, corpus.sentenceCount());
        assertEquals(10029, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus4() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-train.conllu");
        assertEquals(3664, corpus.sentenceCount());
        assertEquals(37784, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus5() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_pud-ud-test.conllu");
        assertEquals(1000, corpus.sentenceCount());
        assertEquals(16882, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus6() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-dev.conllu");
        assertEquals(979, corpus.sentenceCount());
        assertEquals(12074, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus7() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-test.conllu");
        assertEquals(979, corpus.sentenceCount());
        assertEquals(12095, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus8() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-train.conllu");
        assertEquals(7803, corpus.sentenceCount());
        assertEquals(98214, wordCount(corpus));
    }

}