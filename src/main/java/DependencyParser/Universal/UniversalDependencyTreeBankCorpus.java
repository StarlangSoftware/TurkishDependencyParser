package DependencyParser.Universal;

import Corpus.Corpus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class UniversalDependencyTreeBankCorpus extends Corpus{

    public UniversalDependencyTreeBankCorpus(){

    }

    public UniversalDependencyTreeBankCorpus(String fileName){
        try {
            UniversalDependencyTreeBankSentence sentence = null;
            UniversalDependencyRelation relation;
            ClassLoader classLoader = getClass().getClassLoader();
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line != null) {
                if (line.length() == 0){
                    addSentence(sentence);
                    sentence = null;
                } else {
                    if (line.startsWith("#")){
                        if (sentence == null){
                            sentence = new UniversalDependencyTreeBankSentence();
                        }
                        sentence.addComment(line.trim());
                    } else {
                        String[] items = line.split("\\t");
                        if (items.length != 10){
                            System.out.println("Line does not contain 10 items ->" + line);
                        } else {
                            String id = items[0];
                            if (id.matches("\\d+")){
                                String surfaceForm = items[1];
                                String lemma = items[2];
                                UniversalDependencyPosType upos = UniversalDependencyRelation.getDependencyPosType(items[3]);
                                if (upos == null){
                                    System.out.println("Line does not contain universal pos ->" + line);
                                }
                                String xpos = items[4];
                                UniversalDependencyTreeBankFeatures features = new UniversalDependencyTreeBankFeatures(items[5]);
                                if (!items[6].equals("_")){
                                    int to = Integer.parseInt(items[6]);
                                    String dependencyType = items[7].toUpperCase();
                                    if (dependencyType.contains(":")){
                                        dependencyType = dependencyType.substring(0, dependencyType.indexOf(":"));
                                    }
                                    relation = new UniversalDependencyRelation(to, dependencyType);
                                } else {
                                    relation = null;
                                }
                                String deps = items[8];
                                String misc = items[9];
                                UniversalDependencyTreeBankWord word = new UniversalDependencyTreeBankWord(Integer.parseInt(id), surfaceForm,
                                        lemma, upos, xpos, features, relation, deps, misc);
                                sentence.addWord(word);
                            }
                        }
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
