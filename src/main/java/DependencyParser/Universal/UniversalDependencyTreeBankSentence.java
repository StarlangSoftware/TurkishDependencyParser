package DependencyParser.Universal;

import Corpus.Sentence;
import DependencyParser.ParserEvaluationScore;
import Dictionary.Word;

import java.util.ArrayList;

public class UniversalDependencyTreeBankSentence extends Sentence {
    private final ArrayList<String> comments;

    /**
     * Empty constructor for the UniversalDependencyTreeBankSentence. Initializes comments.
     */
    public UniversalDependencyTreeBankSentence(){
        super();
        comments = new ArrayList<>();
    }

    /**
     * Constructor for the UniversalDependencyTreeBankSentence.  Get a line as input and splits the line wrt tab
     * character. The number of items should be 10. The items are id, surfaceForm, lemma, upos, xpos, feature list,
     * head word index, dependency type, external dependencies and miscellaneous things for one word.
     * @param language Language name. Currently, 'en' and 'tr' languages are supported.
     * @param sentence Sentence string to be processed.
     */
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

    /**
     * Adds a comment string to comments array list.
     * @param comment Comment to be added.
     */
    public void addComment(String comment){
        comments.add(comment);
    }

    /**
     * Overridden toString method. Concatenates the strings of words to get the string of a sentence.
     * @return Concatenation of the strings of words.
     */
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

    /**
     * Compares the sentence with the given sentence and returns a parser evaluation score for this comparison. The result
     * is calculated by summing up the parser evaluation scores of word by word dpendency relation comparisons.
     * @param sentence Universal dependency sentence to be compared.
     * @return A parser evaluation score object.
     */
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
