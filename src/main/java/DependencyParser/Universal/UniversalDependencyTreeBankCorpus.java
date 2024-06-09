package DependencyParser.Universal;

import Corpus.Corpus;
import DependencyParser.ParserEvaluationScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class UniversalDependencyTreeBankCorpus extends Corpus{

    private String language;

    /**
     * Empty constructor.
     */
    public UniversalDependencyTreeBankCorpus(){

    }

    /**
     * Constructs a universal dependency corpus from an input file. Reads the sentences one by one and constructs a
     * universal dependency sentence from each line read.
     * @param fileName Input file name.
     */
    public UniversalDependencyTreeBankCorpus(String fileName){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            language = fileName.substring(0, fileName.indexOf('_'));
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName), StandardCharsets.UTF_8));
            StringBuilder sentence = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if (line.isEmpty()){
                    addSentence(new UniversalDependencyTreeBankSentence(language, sentence.toString()));
                    sentence = new StringBuilder();
                } else {
                    sentence.append(line).append("\n");
                }
                line = br.readLine();
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Compares the corpus with the given corpus and returns a parser evaluation score for this comparison. The result
     * is calculated by summing up the parser evaluation scores of sentence by sentence comparisons.
     * @param corpus Universal dependency corpus to be compared.
     * @return A parser evaluation score object.
     */
    public ParserEvaluationScore compareParses(UniversalDependencyTreeBankCorpus corpus){
        ParserEvaluationScore score = new ParserEvaluationScore();
        for (int i = 0; i < sentences.size(); i++){
            score.add(((UniversalDependencyTreeBankSentence) sentences.get(i)).compareParses((UniversalDependencyTreeBankSentence) corpus.getSentence(i)));
        }
        return score;
    }
}
