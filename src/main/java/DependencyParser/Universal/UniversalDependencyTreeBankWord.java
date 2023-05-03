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

    public UniversalDependencyTreeBankWord(){
        super("root");
        this.id = 0;
        this.lemma = "";
        this.upos = null;
        this.xpos = "";
        this.features = null;
        this.deps = "";
        this.misc = "";
        this.relation = new UniversalDependencyRelation(-1, "DEP");
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

    public boolean featureExists(String featureName) {
        return features.featureExists(featureName);
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UniversalDependencyTreeBankWord)) {
            return false;
        }
        UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) obj;
        return this.id == word.id && this.lemma.equals(word.lemma) && handleUpos(this.upos, word.upos) && this.xpos.equals(word.xpos) && handleFeatures(this.features, word.features) && handleRelation(this.relation, word.relation) && this.deps.equals(word.deps) && this.misc.equals(word.misc);
    }

    private boolean handleUpos(UniversalDependencyPosType upos1, UniversalDependencyPosType upos2) {
        if (upos1 == null && upos2 == null) {
            return true;
        } else if (upos1 != null && upos2 != null) {
            return upos1.equals(upos2);
        }
        return false;
    }

    private boolean handleFeatures(UniversalDependencyTreeBankFeatures features1, UniversalDependencyTreeBankFeatures features2) {
        if (features1 == null && features2 == null) {
            return true;
        } else if (features1 != null && features2 != null) {
            return features1.equals(features2);
        }
        return false;
    }

    private boolean handleRelation(UniversalDependencyRelation relation1, UniversalDependencyRelation relation2) {
        if (relation1 == null && relation2 == null) {
            return true;
        } else if (relation1 != null && relation2 != null) {
            return relation1.equals(relation2);
        }
        return false;
    }

    @Override
    public UniversalDependencyTreeBankWord clone() {
        UniversalDependencyTreeBankWord word = new UniversalDependencyTreeBankWord(id, name, lemma, upos, xpos, null, null, deps, misc);
        try {
            word.features = this.features.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (relation != null) {
            try {
                word.relation = this.relation.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            relation = null;
        }
        return word;
    }
}
