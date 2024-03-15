package DependencyParser.Turkish;

import DependencyParser.DependencyRelation;

public class TurkishDependencyRelation extends DependencyRelation {

    private final int toIG;
    private final TurkishDependencyType turkishDependencyType;

    public static final String[] turkishDependencyTypes = {"VOCATIVE", "SUBJECT", "DATIVE.ADJUNCT", "OBJECT", "POSSESSOR",
            "MODIFIER", "S.MODIFIER", "ABLATIVE.ADJUNCT", "DETERMINER", "SENTENCE",
            "CLASSIFIER", "LOCATIVE.ADJUNCT", "COORDINATION", "QUESTION.PARTICLE", "INTENSIFIER",
            "INSTRUMENTAL.ADJUNCT", "RELATIVIZER", "NEGATIVE.PARTICLE", "ETOL", "COLLOCATION",
            "FOCUS.PARTICLE", "EQU.ADJUNCT", "APPOSITION"};
    public static final TurkishDependencyType[] turkishDependencyTags = {TurkishDependencyType.VOCATIVE, TurkishDependencyType.SUBJECT, TurkishDependencyType.DATIVE_ADJUNCT, TurkishDependencyType.OBJECT, TurkishDependencyType.POSSESSOR,
            TurkishDependencyType.MODIFIER, TurkishDependencyType.S_MODIFIER, TurkishDependencyType.ABLATIVE_ADJUNCT, TurkishDependencyType.DETERMINER, TurkishDependencyType.SENTENCE,
            TurkishDependencyType.CLASSIFIER, TurkishDependencyType.LOCATIVE_ADJUNCT, TurkishDependencyType.COORDINATION, TurkishDependencyType.QUESTION_PARTICLE, TurkishDependencyType.INTENSIFIER,
            TurkishDependencyType.INSTRUMENTAL_ADJUNCT, TurkishDependencyType.RELATIVIZER, TurkishDependencyType.NEGATIVE_PARTICLE, TurkishDependencyType.ETOL, TurkishDependencyType.COLLOCATION,
            TurkishDependencyType.FOCUS_PARTICLE, TurkishDependencyType.EQU_ADJUNCT, TurkishDependencyType.APPOSITION};

    /**
     * The getDependencyTag method takes a dependency tag as string and returns the {@link TurkishDependencyType}
     * form of it.
     *
     * @param tag  Type of the dependency tag in string form
     * @return Type of the dependency in {@link TurkishDependencyType} form
     */
    public static TurkishDependencyType getDependencyTag(String tag){
        for (int j = 0; j < turkishDependencyTypes.length; j++) {
            if (tag.equalsIgnoreCase(turkishDependencyTypes[j])) {
                return turkishDependencyTags[j];
            }
        }
        return null;
    }

    /**
     * Another constructor for TurkishDependencyRelation. Gets input toWord, toIG, and dependencyType as arguments and
     * calls the super class's constructor and sets the IG and dependency type.
     * @param toWord Index of the word in the sentence that dependency relation is related
     * @param toIG Index of the inflectional group the dependency relation is related
     * @param dependencyType Type of the dependency relation in string form
     */
    public TurkishDependencyRelation(int toWord, int toIG, String dependencyType){
        super(toWord);
        this.toIG = toIG;
        this.turkishDependencyType = getDependencyTag(dependencyType);
        if (this.turkishDependencyType == null){
            System.out.println("Dependency Tag " + dependencyType + " does not exist\n");
        }
    }

    /**
     * Accessor for the toIG attribute
     * @return toIG attribute
     */
    public int toIG(){
        return toIG;
    }

    /**
     * Accessor for the turkishDependencyType attribute
     * @return turkishDependencyType attribute
     */
    public TurkishDependencyType getTurkishDependencyType(){
        return turkishDependencyType;
    }

    public String toString(){
        return turkishDependencyTypes[turkishDependencyType.ordinal()];
    }

}
