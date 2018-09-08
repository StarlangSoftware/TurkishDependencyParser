package DependencyParser;

public class UniversalDependencyRelation extends DependencyRelation{

    private UniversalDependencyType universalDependencyType;

    public static final String[] universalDependencyTypes = {"acl", "advcl", "advmod", "amod", "appos", "aux",
            "case", "cc", "ccomp", "clf", "compound", "conj", "cop", "csubj", "dep", "det", "discourse", "dislocated",
            "expl", "fixed", "flat", "goeswith", "iobj", "list", "mark", "nmod", "nsubj", "nummod", "obj", "obl", "orphan",
            "parataxis", "punct", "reparandum", "root", "vocative", "xcomp"};
    public static final UniversalDependencyType[] universalDependencyTags = {UniversalDependencyType.ACL, UniversalDependencyType.ADVCL,
            UniversalDependencyType.ADVMOD, UniversalDependencyType.AMOD, UniversalDependencyType.APPOS, UniversalDependencyType.AUX, UniversalDependencyType.CASE,
            UniversalDependencyType.CC, UniversalDependencyType.CCOMP, UniversalDependencyType.CLF, UniversalDependencyType.COMPOUND, UniversalDependencyType.CONJ,
            UniversalDependencyType.COP, UniversalDependencyType.CSUBJ, UniversalDependencyType.DEP, UniversalDependencyType.DET, UniversalDependencyType.DISCOURSE,
            UniversalDependencyType.DISLOCATED, UniversalDependencyType.EXPL, UniversalDependencyType.FIXED, UniversalDependencyType.FLAT,
            UniversalDependencyType.GOESWITH, UniversalDependencyType.IOBJ, UniversalDependencyType.LIST, UniversalDependencyType.MARK, UniversalDependencyType.NMOD,
            UniversalDependencyType.NSUBJ, UniversalDependencyType.NUMMOD, UniversalDependencyType.OBJ, UniversalDependencyType.OBL, UniversalDependencyType.ORPHAN,
            UniversalDependencyType.PARATAXIS, UniversalDependencyType.PUNCT, UniversalDependencyType.REPARANDUM, UniversalDependencyType.ROOT,
            UniversalDependencyType.VOCATIVE, UniversalDependencyType.XCOMP};

    protected UniversalDependencyRelation(int toWord) {
        super(toWord);
    }

    public static UniversalDependencyType getDependencyTag(String tag){
        for (int j = 0; j < universalDependencyTags.length; j++) {
            if (tag.equalsIgnoreCase(universalDependencyTypes[j])) {
                return universalDependencyTags[j];
            }
        }
        return null;
    }

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
