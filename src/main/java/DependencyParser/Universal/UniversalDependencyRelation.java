package DependencyParser.Universal;

import DependencyParser.DependencyRelation;
import DependencyParser.ParserEvaluationScore;

public class UniversalDependencyRelation extends DependencyRelation {

    private UniversalDependencyType universalDependencyType;

    public static final String[] universalDependencyTypes = {"ACL", "ADVCL",
            "ADVMOD", "AMOD", "APPOS", "AUX", "CASE",
            "CC", "CCOMP", "CLF", "COMPOUND", "CONJ",
            "COP", "CSUBJ", "DEP", "DET", "DISCOURSE",
            "DISLOCATED", "EXPL", "FIXED", "FLAT",
            "GOESWITH", "IOBJ", "LIST", "MARK", "NMOD",
            "NSUBJ", "NUMMOD", "OBJ", "OBL", "ORPHAN",
            "PARATAXIS", "PUNCT", "REPARANDUM", "ROOT",
            "VOCATIVE", "XCOMP", "ACL:RELCL", "AUX:PASS",
            "CC:PRECONJ", "COMPOUND:PRT", "DET:PREDET", "FLAT:FOREIGN",
            "NSUBJ:PASS", "CSUBJ:PASS", "NMOD:NPMOD", "NMOD:POSS",
            "NMOD:TMOD", "ADVMOD:EMPH", "AUX:Q", "COMPOUND:LVC",
            "COMPOUND:REDUP", "CSUBJ:COP", "NMOD:COMP", "NMOD:PART",
            "NSUBJ:COP", "OBL:AGENT", "OBL:TMOD"};
    public static final UniversalDependencyType[] universalDependencyTags = {UniversalDependencyType.ACL, UniversalDependencyType.ADVCL,
            UniversalDependencyType.ADVMOD, UniversalDependencyType.AMOD, UniversalDependencyType.APPOS, UniversalDependencyType.AUX, UniversalDependencyType.CASE,
            UniversalDependencyType.CC, UniversalDependencyType.CCOMP, UniversalDependencyType.CLF, UniversalDependencyType.COMPOUND, UniversalDependencyType.CONJ,
            UniversalDependencyType.COP, UniversalDependencyType.CSUBJ, UniversalDependencyType.DEP, UniversalDependencyType.DET, UniversalDependencyType.DISCOURSE,
            UniversalDependencyType.DISLOCATED, UniversalDependencyType.EXPL, UniversalDependencyType.FIXED, UniversalDependencyType.FLAT,
            UniversalDependencyType.GOESWITH, UniversalDependencyType.IOBJ, UniversalDependencyType.LIST, UniversalDependencyType.MARK, UniversalDependencyType.NMOD,
            UniversalDependencyType.NSUBJ, UniversalDependencyType.NUMMOD, UniversalDependencyType.OBJ, UniversalDependencyType.OBL, UniversalDependencyType.ORPHAN,
            UniversalDependencyType.PARATAXIS, UniversalDependencyType.PUNCT, UniversalDependencyType.REPARANDUM, UniversalDependencyType.ROOT,
            UniversalDependencyType.VOCATIVE, UniversalDependencyType.XCOMP, UniversalDependencyType.ACL_RELCL, UniversalDependencyType.AUX_PASS,
            UniversalDependencyType.CC_PRECONJ, UniversalDependencyType.COMPOUND_PRT, UniversalDependencyType.DET_PREDET, UniversalDependencyType.FLAT_FOREIGN,
            UniversalDependencyType.NSUBJ_PASS, UniversalDependencyType.CSUBJ_PASS, UniversalDependencyType.NMOD_NPMOD, UniversalDependencyType.NMOD_POSS,
            UniversalDependencyType.NMOD_TMOD, UniversalDependencyType.ADVMOD_EMPH, UniversalDependencyType.AUX_Q, UniversalDependencyType.COMPOUND_LVC,
            UniversalDependencyType.COMPOUND_REDUP, UniversalDependencyType.CSUBJ_COP, UniversalDependencyType.NMOD_COMP, UniversalDependencyType.NMOD_PART,
            UniversalDependencyType.NSUBJ_COP, UniversalDependencyType.OBL_AGENT, UniversalDependencyType.OBL_TMOD};
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

    public ParserEvaluationScore compareRelations(UniversalDependencyRelation relation){
        double LS = 0.0, LAS = 0.0, UAS = 0.0;
        if (toString().equals(relation.toString())){
            LS = 1.0;
            if (toWord == relation.to()){
                LAS = 1.0;
            }
        }
        if (toWord == relation.to()){
            UAS = 1.0;
        }
        return new ParserEvaluationScore(LAS, UAS, LS, 1);
    }

    public String toString(){
        return universalDependencyTypes[universalDependencyType.ordinal()];
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UniversalDependencyRelation)) {
            return false;
        }
        UniversalDependencyRelation relation = (UniversalDependencyRelation) obj;
        return handleUniversalDependencyType(this.universalDependencyType, relation.universalDependencyType) && this.toWord == relation.toWord;
    }

    private boolean handleUniversalDependencyType(UniversalDependencyType type1, UniversalDependencyType type2) {
        if (type1 == null && type2 == null) {
            return true;
        } else if (type1 != null && type2 != null) {
            return type1.equals(type2);
        }
        return false;
    }

    @Override
    protected UniversalDependencyRelation clone() throws CloneNotSupportedException {
        return new UniversalDependencyRelation(toWord, this.toString());
    }
}
