package DependencyParser.Universal;

import DependencyParser.DependencyRelation;

public class UniversalDependencyRelation extends DependencyRelation {

    private UniversalDependencyType universalDependencyType;

    public static final String[] universalDependencyTypes = {"ACL", "ADVCL", "ADVMOD", "AMOD", "APPOS", "AUX",
            "CASE", "CC", "CCOMP", "CLF", "COMPOUND", "CONJ", "COP", "CSUBJ", "CSUBJPASS", "DEP", "DET", "DISCOURSE", "DISLOCATED",
            "EXPL", "FIXED", "FLAT", "GOESWITH", "IOBJ", "LIST", "MARK", "NMOD", "NEG", "NSUBJ", "NSUBJPASS", "NUMMOD", "OBJ", "OBL", "ORPHAN",
            "PARATAXIS", "PUNCT", "REPARANDUM", "ROOT", "VOCATIVE", "XCOMP"};
    public static final UniversalDependencyType[] universalDependencyTags = {UniversalDependencyType.ACL, UniversalDependencyType.ADVCL,
            UniversalDependencyType.ADVMOD, UniversalDependencyType.AMOD, UniversalDependencyType.APPOS, UniversalDependencyType.AUX, UniversalDependencyType.CASE,
            UniversalDependencyType.CC, UniversalDependencyType.CCOMP, UniversalDependencyType.CLF, UniversalDependencyType.COMPOUND, UniversalDependencyType.CONJ,
            UniversalDependencyType.COP, UniversalDependencyType.CSUBJ, UniversalDependencyType.CSUBJPASS, UniversalDependencyType.DEP, UniversalDependencyType.DET, UniversalDependencyType.DISCOURSE,
            UniversalDependencyType.DISLOCATED, UniversalDependencyType.EXPL, UniversalDependencyType.FIXED, UniversalDependencyType.FLAT,
            UniversalDependencyType.GOESWITH, UniversalDependencyType.IOBJ, UniversalDependencyType.LIST, UniversalDependencyType.MARK, UniversalDependencyType.NMOD,
            UniversalDependencyType.NEG, UniversalDependencyType.NSUBJ, UniversalDependencyType.NSUBJPASS, UniversalDependencyType.NUMMOD, UniversalDependencyType.OBJ, UniversalDependencyType.OBL, UniversalDependencyType.ORPHAN,
            UniversalDependencyType.PARATAXIS, UniversalDependencyType.PUNCT, UniversalDependencyType.REPARANDUM, UniversalDependencyType.ROOT,
            UniversalDependencyType.VOCATIVE, UniversalDependencyType.XCOMP};
    public static final String[] universalDependencyPosTypes = {"ADJ", "ADV", "INTJ", "NOUN", "PROPN", "VERB", "ADP", "AUX", "CCONJ",
            "DET", "NUM", "PART", "PRON", "SCONJ", "PUNCT", "SYM", "X"};
    public static final UniversalDependencyPosType[] universalDependencyPosTags = {UniversalDependencyPosType.ADJ, UniversalDependencyPosType.ADV, UniversalDependencyPosType.INTJ, UniversalDependencyPosType.NOUN, UniversalDependencyPosType.PROPN,
            UniversalDependencyPosType.VERB, UniversalDependencyPosType.ADP, UniversalDependencyPosType.AUX, UniversalDependencyPosType.CCONJ, UniversalDependencyPosType.DET, UniversalDependencyPosType.NUM, UniversalDependencyPosType.PART,
            UniversalDependencyPosType.PRON, UniversalDependencyPosType.SCONJ, UniversalDependencyPosType.PUNCT, UniversalDependencyPosType.SYM, UniversalDependencyPosType.X};

    /**
     * Overriden Universal Dependency Relation constructor. Gets toWord as input and calls it super class's constructor
     * @param toWord Index of the word in the sentence that dependency relation is related
     */
    public UniversalDependencyRelation(int toWord) {
        super(toWord);
    }

    /**
     * The getDependencyTag method takes an dependency tag as string and returns the {@link UniversalDependencyType}
     * form of it.
     *
     * @param tag  Type of the dependency tag in string form
     * @return Type of the dependency in {@link UniversalDependencyType} form
     */
    public static UniversalDependencyType getDependencyTag(String tag){
        for (int j = 0; j < universalDependencyTags.length; j++) {
            if (tag.equalsIgnoreCase(universalDependencyTypes[j])) {
                return universalDependencyTags[j];
            }
        }
        return null;
    }

    public static UniversalDependencyPosType getDependencyPosType(String tag){
        for (int i = 0; i < universalDependencyPosTypes.length; i++) {
            if (tag.equalsIgnoreCase(universalDependencyPosTypes[i])) {
                return universalDependencyPosTags[i];
            }
        }
        return null;
    }

    /**
     * Another constructor for UniversalDependencyRelation. Gets input toWord and dependencyType as arguments and
     * calls the super class's constructor and sets the dependency type.
     * @param toWord Index of the word in the sentence that dependency relation is related
     * @param dependencyType Type of the dependency relation in string form
     */
    public UniversalDependencyRelation(int toWord, String dependencyType){
        super(toWord);
        this.universalDependencyType = getDependencyTag(dependencyType);
        if (this.universalDependencyType == null){
            System.out.println("Dependency Tag " + dependencyType + " does not exist\n");
        }
    }

    public String toString(){
        return universalDependencyTypes[universalDependencyType.ordinal()];
    }

}
