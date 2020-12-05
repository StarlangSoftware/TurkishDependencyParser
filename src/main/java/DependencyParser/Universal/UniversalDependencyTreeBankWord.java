package DependencyParser.Universal;

import Dictionary.Word;

public class UniversalDependencyTreeBankWord extends Word {

    private int id;
    private String lemma;
    private UniversalDependencyPosType upos;
    private String xpos;
    private UniversalDependencyTreeBankFeatures features;
    private UniversalDependencyRelation relation;
    private String deps;
    private String misc;

    public UniversalDependencyTreeBankWord(int id, String name, String lemma, UniversalDependencyPosType upos, String xpos,
                                           UniversalDependencyTreeBankFeatures features,
                                           UniversalDependencyRelation relation, String deps, String misc){
        super(name);
        this.id = id;
        this.lemma = lemma;
        this.upos = upos;
        this.xpos = xpos;
        this.deps = deps;
        this.features = features;
        this.relation = relation;
        this.misc = misc;
    }

    public int getId() {
        return id;
    }

    public String getLemma() {
        return lemma;
    }

    public UniversalDependencyPosType getUpos() {
        return upos;
    }

    public String getXpos() {
        return xpos;
    }

    public UniversalDependencyTreeBankFeatures getFeatures() {
        return features;
    }

    public String getFeatureValue(String featureName) {
        return features.getFeatureValue(featureName);
    }

    public UniversalDependencyRelation getRelation() {
        return relation;
    }

    public void setRelation(UniversalDependencyRelation relation) {
        this.relation = relation;
    }

    public String getDeps() {
        return deps;
    }

    public String getMisc() {
        return misc;
    }

    public String toString(){
        return id + "\t" + name + "\t" + lemma + "\t" + upos + "\t" +
                xpos + "\t" + features.toString() + "\t" + relation.to() + "\t" +
                relation.toString().toLowerCase() + "\t" + deps + "\t" + misc;
    }

}
