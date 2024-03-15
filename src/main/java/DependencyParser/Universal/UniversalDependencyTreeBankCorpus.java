package DependencyParser.Universal;

import Corpus.Corpus;
import DependencyParser.ParserEvaluationScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class UniversalDependencyTreeBankCorpus extends Corpus{

    private String language;

    public UniversalDependencyTreeBankCorpus(){

    }

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

    public ParserEvaluationScore compareParses(UniversalDependencyTreeBankCorpus corpus){
        ParserEvaluationScore score = new ParserEvaluationScore();
        for (int i = 0; i < sentences.size(); i++){
            score.add(((UniversalDependencyTreeBankSentence) sentences.get(i)).compareParses((UniversalDependencyTreeBankSentence) corpus.getSentence(i)));
        }
        return score;
    }
}
