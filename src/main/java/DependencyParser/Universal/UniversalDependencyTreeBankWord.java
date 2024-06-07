package DependencyParser.Universal;

import Dictionary.Word;

public class UniversalDependencyTreeBankWord extends Word {

    private final int id;
    private final String lemma;
    private final UniversalDependencyPosType upos;
    private final String xpos;
    private UniversalDependencyTreeBankFeatures features;
    private UniversalDependencyRelation relation;
    private final String deps;
    private final String misc;

    /**
     * Constructor of the universal dependency word. Sets the attributes.
     * @param id Id of the word
     * @param name Name of the word
     * @param lemma Lemma of the word
     * @param upos Universal part of speech tag.
     * @param xpos Extra part of speech tag
     * @param features Feature list of the word
     * @param relation Universal dependency relation of the word
     * @param deps External dependencies for the word
     * @param misc Miscellaneous information for the word.
     */
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

    /**
     * Default constructor for the universal dependency word. Sets the attributes to default values.
     */
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

    /**
     * Accessor for the id attribute.
     * @return Id attribute
     */
    public int getId() {
        return id;
    }

    /**
     * Accessor for the lemma attribute
     * @return Lemma attribute
     */
    public String getLemma() {
        return lemma;
    }

    /**
     * Accessor for the upos attribute
     * @return Upos attribute
     */
    public UniversalDependencyPosType getUpos() {
        return upos;
    }

    /**
     * Accessor for the xpos attribute
     * @return Xpos attribute
     */
    public String getXpos() {
        return xpos;
    }

    /**
     * Accessor for the features attribute
     * @return Features attribute
     */
    public UniversalDependencyTreeBankFeatures getFeatures() {
        return features;
    }

    /**
     * Gets the value of a given feature.
     * @param featureName Name of the feature
     * @return Value of the feature
     */
    public String getFeatureValue(String featureName) {
        return features.getFeatureValue(featureName);
    }

    /**
     * Checks if the given feature exists.
     * @param featureName Name of the feature
     * @return True if the given feature exists, false otherwise.
     */
    public boolean featureExists(String featureName) {
        return features.featureExists(featureName);
    }

    /**
     * Accessor for the relation attribute.
     * @return Relation attribute
     */
    public UniversalDependencyRelation getRelation() {
        return relation;
    }

    /**
     * Mutator for the relation attribute
     * @param relation New relation attribute
     */
    public void setRelation(UniversalDependencyRelation relation) {
        this.relation = relation;
    }

    /**
     * Accessor for the deps attribute
     * @return Xpos attribute
     */
    public String getDeps() {
        return deps;
    }

    /**
     * Accessor for the misc attribute
     * @return Xpos attribute
     */
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

    /**
     * Compares two universal dependency pos types. If both are null, returns true. If none of them are null, they are
     * compared, if they are same, returns true, otherwise returns false. If only one of them is null, returns false.
     * @param upos1 First universal dependency type.
     * @param upos2 Second universal dependency type.
     * @return If both are null, returns true. If none of them are null, they are compared, if they are same, returns
     * true, otherwise returns false. If only one of them is null, returns false.
     */
    private boolean handleUpos(UniversalDependencyPosType upos1, UniversalDependencyPosType upos2) {
        if (upos1 == null && upos2 == null) {
            return true;
        } else if (upos1 != null && upos2 != null) {
            return upos1.equals(upos2);
        }
        return false;
    }

    /**
     * Compares two feature sets. If both are null, returns true. If none of them are null, they are
     * compared, if they are same, returns true, otherwise returns false. If only one of them is null, returns false.
     * @param features1 First feature set.
     * @param features2 Second feature set.
     * @return If both are null, returns true. If none of them are null, they are compared, if they are same, returns
     * true, otherwise returns false. If only one of them is null, returns false.
     */
    private boolean handleFeatures(UniversalDependencyTreeBankFeatures features1, UniversalDependencyTreeBankFeatures features2) {
        if (features1 == null && features2 == null) {
            return true;
        } else if (features1 != null && features2 != null) {
            return features1.equals(features2);
        }
        return false;
    }

    /**
     * Compares two universal dependency relations. If both are null, returns true. If none of them are null, they are
     * compared, if they are same, returns true, otherwise returns false. If only one of them is null, returns false.
     * @param relation1 First universal dependency relation.
     * @param relation2 Second universal dependency relation.
     * @return If both are null, returns true. If none of them are null, they are compared, if they are same, returns
     * true, otherwise returns false. If only one of them is null, returns false.
     */
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
        } catch (CloneNotSupportedException ignored) {
        }
        if (relation != null) {
            try {
                word.relation = this.relation.clone();
            } catch (CloneNotSupportedException ignored) {
            }
        } else {
            word.relation = null;
        }
        return word;
    }
}
