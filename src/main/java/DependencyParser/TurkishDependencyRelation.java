package DependencyParser;

public class TurkishDependencyRelation extends DependencyRelation{

    private int toIG;
    private TurkishDependencyType turkishDependencyType;

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

    public static TurkishDependencyType getDependencyTag(String tag){
        for (int j = 0; j < turkishDependencyTypes.length; j++) {
            if (tag.equalsIgnoreCase(turkishDependencyTypes[j])) {
                return turkishDependencyTags[j];
            }
        }
        return null;
    }

    public TurkishDependencyRelation(int toWord, int toIG, String dependencyType){
        super(toWord);
        this.toIG = toIG;
        this.turkishDependencyType = getDependencyTag(dependencyType);
        if (this.turkishDependencyType == null){
            System.out.println("Dependency Tag " + dependencyType + " does not exist\n");
        }
    }

    public int toIG(){
        return toIG;
    }

    public TurkishDependencyType getTurkishDependencyType(){
        return turkishDependencyType;
    }

    public String toString(){
        return turkishDependencyTypes[turkishDependencyType.ordinal()];
    }

}
