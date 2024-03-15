package DependencyParser.Universal;

import Corpus.Sentence;
import DependencyParser.ParserEvaluationScore;
import Dictionary.Word;

import java.util.ArrayList;

public class UniversalDependencyTreeBankSentence extends Sentence {
    private final ArrayList<String> comments;

    public UniversalDependencyTreeBankSentence(){
        super();
        comments = new ArrayList<>();
    }

    public UniversalDependencyTreeBankSentence(String language, String sentence){
        this();
        UniversalDependencyRelation relation;
        String[] lines = sentence.split("\\n");
        for (String line : lines){
            if (line.startsWith("#")){
                addComment(line.trim());
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
                        UniversalDependencyTreeBankFeatures features = new UniversalDependencyTreeBankFeatures(language, items[5]);
                        if (!items[6].equals("_")){
                            int to = Integer.parseInt(items[6]);
                            String dependencyType = items[7].toUpperCase();
                            relation = new UniversalDependencyRelation(to, dependencyType);
                        } else {
                            relation = null;
                        }
                        String deps = items[8];
                        String misc = items[9];
                        UniversalDependencyTreeBankWord word = new UniversalDependencyTreeBankWord(Integer.parseInt(id), surfaceForm,
                                lemma, upos, xpos, features, relation, deps, misc);
                        addWord(word);
                    }
                }
            }
        }
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (String comment : comments){
            result.append(comment).append("\n");
        }
        for (Word w : words){
            UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) w;
            result.append(word.toString()).append("\n");
        }
        return result.toString();
    }

    public ParserEvaluationScore compareParses(UniversalDependencyTreeBankSentence sentence){
        ParserEvaluationScore score = new ParserEvaluationScore();
        for (int i = 0; i < words.size(); i++){
            UniversalDependencyRelation relation1 = ((UniversalDependencyTreeBankWord) words.get(i)).getRelation();
            UniversalDependencyRelation relation2 = ((UniversalDependencyTreeBankWord) sentence.getWord(i)).getRelation();
            if (relation1 != null && relation2 != null){
                score.add(relation1.compareRelations(relation2));
            }
        }
        return score;
    }
}
