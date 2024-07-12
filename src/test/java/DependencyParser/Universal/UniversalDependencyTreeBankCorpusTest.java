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
        assertEquals(2880, corpus.sentenceCount());
        assertEquals(17177, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus2() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-dev.conllu");
        assertEquals(1100, corpus.sentenceCount());
        assertEquals(10542, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus3() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-test.conllu");
        assertEquals(1100, corpus.sentenceCount());
        assertEquals(10032, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus4() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_imst-ud-train.conllu");
        assertEquals(3435, corpus.sentenceCount());
        assertEquals(37522, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus5() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_pud-ud-test.conllu");
        assertEquals(1000, corpus.sentenceCount());
        assertEquals(16881, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus6() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-dev.conllu");
        assertEquals(979, corpus.sentenceCount());
        assertEquals(12289, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus7() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-test.conllu");
        assertEquals(979, corpus.sentenceCount());
        assertEquals(12210, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus8() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_boun-ud-train.conllu");
        assertEquals(7803, corpus.sentenceCount());
        assertEquals(100713, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus9() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_atis-ud-dev.conllu");
        assertEquals(572, corpus.sentenceCount());
        assertEquals(6644, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus10() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_atis-ud-test.conllu");
        assertEquals(586, corpus.sentenceCount());
        assertEquals(6580, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus11() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_atis-ud-train.conllu");
        assertEquals(4274, corpus.sentenceCount());
        assertEquals(48655, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus12() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_atis-ud-dev.conllu");
        assertEquals(572, corpus.sentenceCount());
        assertEquals(4862, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus13() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_atis-ud-test.conllu");
        assertEquals(586, corpus.sentenceCount());
        assertEquals(4813, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus14() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_atis-ud-train.conllu");
        assertEquals(4274, corpus.sentenceCount());
        assertEquals(36200, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus15() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_framenet-ud-dev.conllu");
        assertEquals(205, corpus.sentenceCount());
        assertEquals(1421, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus16() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_framenet-ud-test.conllu");
        assertEquals(205, corpus.sentenceCount());
        assertEquals(1467, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus17() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_framenet-ud-train.conllu");
        assertEquals(2288, corpus.sentenceCount());
        assertEquals(16333, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus18() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_kenet-ud-dev.conllu");
        assertEquals(1646, corpus.sentenceCount());
        assertEquals(17554, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus19() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_kenet-ud-test.conllu");
        assertEquals(1643, corpus.sentenceCount());
        assertEquals(17817, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus20() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_kenet-ud-train.conllu");
        assertEquals(15398, corpus.sentenceCount());
        assertEquals(143287, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus21() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_penn-ud-dev.conllu");
        assertEquals(622, corpus.sentenceCount());
        assertEquals(6994, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus22() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_penn-ud-test.conllu");
        assertEquals(924, corpus.sentenceCount());
        assertEquals(10047, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus23() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_penn-ud-train.conllu");
        assertEquals(14850, corpus.sentenceCount());
        assertEquals(166513, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus24() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_tourism-ud-dev.conllu");
        assertEquals(2166, corpus.sentenceCount());
        assertEquals(10203, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus25() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_tourism-ud-test.conllu");
        assertEquals(2191, corpus.sentenceCount());
        assertEquals(10125, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus26() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("tr_tourism-ud-train.conllu");
        assertEquals(15476, corpus.sentenceCount());
        assertEquals(71141, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus27() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_ewt-ud-dev.conllu");
        assertEquals(2001, corpus.sentenceCount());
        assertEquals(25149, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus28() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_ewt-ud-test.conllu");
        assertEquals(2077, corpus.sentenceCount());
        assertEquals(25094, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus29() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_ewt-ud-train.conllu");
        assertEquals(12544, corpus.sentenceCount());
        assertEquals(204576, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus30() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_gum-ud-dev.conllu");
        assertEquals(1117, corpus.sentenceCount());
        assertEquals(19642, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus31() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_gum-ud-test.conllu");
        assertEquals(1096, corpus.sentenceCount());
        assertEquals(19905, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus32() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_gum-ud-train.conllu");
        assertEquals(8548, corpus.sentenceCount());
        assertEquals(147869, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus33() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_lines-ud-dev.conllu");
        assertEquals(1032, corpus.sentenceCount());
        assertEquals(19170, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus34() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_lines-ud-test.conllu");
        assertEquals(1035, corpus.sentenceCount());
        assertEquals(17675, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus35() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_lines-ud-train.conllu");
        assertEquals(3176, corpus.sentenceCount());
        assertEquals(57372, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus36() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_partut-ud-dev.conllu");
        assertEquals(156, corpus.sentenceCount());
        assertEquals(2722, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus37() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_partut-ud-test.conllu");
        assertEquals(153, corpus.sentenceCount());
        assertEquals(3408, wordCount(corpus));
    }

    @Test
    public void testDependencyCorpus38() {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus("en_partut-ud-train.conllu");
        assertEquals(1781, corpus.sentenceCount());
        assertEquals(43503, wordCount(corpus));
    }

}