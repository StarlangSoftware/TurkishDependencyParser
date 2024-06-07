package DependencyParser.Universal;

import java.util.HashMap;

public class UniversalDependencyTreeBankFeatures {

    private final HashMap<String, String> featureList;

    private static final String[] universalFeatureTypes =
            {"PronType", "NumType", "Poss", "Reflex", "Foreign",
            "Abbr", "Typo", "Gender", "Animacy", "NounClass",
            "Number", "Case", "Definite", "Degree", "VerbForm",
            "Mood", "Tense", "Aspect", "Voice", "Evident",
            "Polarity", "Person", "Polite", "Clusivity", "NumForm"};

    private static final String[][] universalFeatureValues = {
            {"Art", "Dem",	"Emp", "Exc", "Ind", "Int", "Neg", "Prs", "Rcp", "Rel", "Tot"},
            {"Card", "Dist", "Frac", "Mult", "Ord", "Range", "Sets"},
            {"Yes"},
            {"Yes"},
            {"Yes"},

            {"Yes"},
            {"Yes"},
            {"Com", "Fem", "Masc", "Neut"},
            {"Anim", "Hum", "Inan", "Nhum"},
            {"Bantu1", "Bantu2", "Bantu3", "Bantu4", "Bantu5", "Bantu6", "Bantu7", "Bantu8", "Bantu9", "Bantu10", "Bantu11", "Bantu12", "Bantu13", "Bantu14", "Bantu15", "Bantu16", "Bantu17", "Bantu18", "Bantu19", "Bantu20", "Bantu21", "Bantu22", "Bantu23", "Wol1", "Wol2", "Wol3", "Wol4", "Wol5", "Wol6", "Wol7", "Wol8", "Wol9", "Wol10", "Wol11", "Wol12"},

            {"Coll", "Count", "Dual", "Grpa", "Grpl", "Inv", "Pauc", "Plur", "Ptan", "Sing", "Tri"},
            {"Abs", "Acc", "Erg", "Nom", "Abe", "Ben", "Cau", "Cmp", "Cns", "Com", "Dat", "Dis", "Equ", "Gen", "Ins", "Par", "Tem", "Tra", "Voc", "Abl", "Add", "Ade", "All", "Del", "Ela", "Ess", "Ill", "Ine", "Lat", "Loc", "Per", "Sbe", "Sbl", "Spl", "Sub", "Sup", "Ter"},
            {"Com", "Cons", "Def", "Ind", "Spec"},
            {"Abs", "Aug", "Cmp", "Dim", "Equ", "Pos", "Sup"},
            {"Conv", "Fin", "Gdv", "Ger", "Inf", "Part", "Sup", "Vnoun"},

            {"Adm", "Cnd", "Des", "Imp", "Ind", "Int", "Irr", "Jus", "Nec", "Opt", "Pot", "Prp", "Qot", "Sub"},
            {"Fut", "Imp", "Past", "Pqp", "Pres"},
            {"Hab", "Imp", "Iter", "Perf", "Prog", "Prosp"},
            {"Act", "Antip", "Bfoc", "Cau", "Dir", "Inv", "Lfoc", "Mid", "Pass", "Rcp"},
            {"Fh", "Nfh"},

            {"Neg", "Pos"},
            {"0", "1", "2", "3", "4"},
            {"Elev", "Form", "Humb", "Infm"},
            {"Ex", "In"},
            {"Word", "Digit", "Roman"},
    };

    private static final String[][] turkishFeatureValues = {
            {"Art", "Dem",	"Ind", "Int", "Neg", "Prs", "Rcp", "Rel", "Tot"},
            {"Card", "Dist", "Ord"},
            {},
            {"Yes"},
            {},

            {"Yes"},
            {},
            {},
            {},
            {},

            {"Plur", "Sing"},
            {"Acc", "Nom", "Dat", "Equ", "Gen", "Ins", "Abl", "Loc"},
            {"Def", "Ind"},
            {"Cmp", "Sup"},
            {"Conv", "Fin", "Part", "Vnoun"},

            {"Cnd", "Des", "Gen", "Imp", "Ind", "Nec", "Opt", "Pot", "DesPot", "CndPot", "CndGen", "CndGenPot", "GenPot", "PotPot", "GenNecPot", "GenNec", "NecPot", "GenPotPot", "ImpPot"},
            {"Fut", "Past", "Pqp", "Pres", "Aor"},
            {"Imp", "Perf", "Prog", "Prosp", "Hab", "Rapid"},
            {"Cau", "Pass", "Rcp", "Rfl", "CauCau", "CauCauPass", "CauPass", "CauPassRcp", "CauRcp", "PassPass", "PassRfl", "PassRcp"},
            {"Fh", "Nfh"},

            {"Neg", "Pos"},
            {"1", "2", "3"},
            {},
            {},
            {}
    };

    private static final String[][] englishFeatureValues = {
            {"Art", "Dem",	"Emp", "Ind", "Int", "Neg", "Prs", "Rcp", "Rel", "Tot"},
            {"Card", "Frac", "Mult", "Ord"},
            {"Yes"},
            {"Yes"},
            {"Yes"},

            {"Yes"},
            {"Yes"},
            {"Fem", "Masc", "Neut"},
            {},
            {},

            {"Plur", "Sing"},
            {"Acc", "Nom", "Gen"},
            {"Def", "Ind"},
            {"Cmp", "Pos", "Sup"},
            {"Fin", "Ger", "Inf", "Part"},

            {"Imp", "Ind", "Sub"},
            {"Past", "Pres"},
            {},
            {"Pass"},
            {},

            {"Neg"},
            {"1", "2", "3"},
            {},
            {},
            {"Word", "Digit", "Roman"}
    };

    /**
     * Returns the index of the universal feature type in the universalFeatureTypes array, given the name of the feature
     * type.
     * @param featureName Name of the feature type
     * @return Index of the universal feature type in the universalFeatureTypes array. If the name does not exist, the
     * function returns -1.
     */
    private static int featureIndex(String featureName){
        if (featureName.contains("[")){
            featureName = featureName.substring(0, featureName.indexOf('['));
        }
        for (int i = 0; i < universalFeatureTypes.length; i++){
            if (universalFeatureTypes[i].equals(featureName)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the given universal dependency pos.
     * @param uPos Given universal dependency part of speech tag.
     * @return The index of the universal dependency pos.
     */
    public static int posIndex(String uPos){
        int index = 0;
        for (UniversalDependencyPosType universalDependencyPosType : UniversalDependencyPosType.values()){
            if (universalDependencyPosType.toString().equals(uPos)){
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the universal dependency type in the universalDependencyTypes array, given the name of the
     * universal dependency type.
     * @param universalDependency Universal dependency type
     * @return Index of the universal dependency type in the universalDependencyTypes array. If the name does not exist,
     * the function returns -1.
     */
    public static int dependencyIndex(String universalDependency){
        int index = 0;
        for (String dependency : UniversalDependencyRelation.universalDependencyTypes){
            if (dependency.equals(universalDependency)){
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Returns the number of distinct values for a feature in a given language
     * @param language Language name. Currently, 'en' and 'tr' languages are supported.
     * @param featureName Name of the feature type.
     * @return The number of distinct values for a feature in a given language
     */
    public static int numberOfValues(String language, String featureName){
        int featureIndex = featureIndex(featureName);
        if (featureIndex != -1) {
            switch (language) {
                case "en":
                    return englishFeatureValues[featureIndex].length;
                case "tr":
                    return turkishFeatureValues[featureIndex].length;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the given value in the feature value array for the given feature in the given
     * language.
     * @param language Language name. Currently, 'en' and 'tr' languages are supported.
     * @param featureName Name of the feature.
     * @param featureValue Value of the feature.
     * @return The index of the given feature value in the feature value array for the given feature in the given
     * language.
     */
    public static int featureValueIndex(String language, String featureName, String featureValue){
        String[][] searchArray;
        int featureIndex = featureIndex(featureName);
        if (featureIndex != -1){
            switch (language){
                case "en":
                    searchArray = englishFeatureValues;
                    break;
                case "tr":
                    searchArray = turkishFeatureValues;
                    break;
                case "u":
                default:
                    searchArray = universalFeatureValues;
                    break;
            }
            int featureValueIndex = -1;
            for (int i = 0; i < searchArray[featureIndex].length; i++){
                if (searchArray[featureIndex][i].equals(featureValue)){
                    featureValueIndex = i;
                }
            }
            return featureValueIndex;
        }
        return -1;
    }

    /**
     * Constructor of a UniversalDependencyTreeBankFeatures object. Given the language of the word and features of the
     * word as a string, the method splits the features with respect to pipe character. Then for each feature type and
     * value pair, their values and types are inserted into the featureList hash map. The method also check for validity
     * of the feature values for that feature type.
     * @param language Language name. Currently, 'en' and 'tr' languages are supported.
     * @param features Feature string.
     */
    public UniversalDependencyTreeBankFeatures(String language, String features){
        featureList = new HashMap<>();
        if (!features.equals("_")){
            String[] list = features.split("\\|");
            for (String feature : list){
                if (feature.contains("=")){
                    String featureName = feature.substring(0, feature.indexOf("=")).trim();
                    String featureValue = feature.substring(feature.indexOf("=") + 1).trim();
                    if (featureValueIndex(language, featureName, featureValue) != -1){
                        featureList.put(featureName, featureValue);
                    } else {
                        System.out.println("Either the feature " + featureName + " or the value " + featureValue + " is wrong");
                    }
                } else {
                    System.out.println("Feature does not contain = ->" + features);
                }
            }
        }
    }

    /**
     * Gets the value of a given feature.
     * @param feature Name of the feature
     * @return Value of the feature
     */
    public String getFeatureValue(String feature){
        return featureList.get(feature);
    }

    /**
     * Checks if the given feature exists in the feature list.
     * @param feature Name of the feature
     * @return True, if the feature list contains the feature, false otherwise.
     */
    public boolean featureExists(String feature){
        return featureList.containsKey(feature);
    }

    /**
     * Overridden toString method. Returns feature with their values separated with pipe characters.
     * @return A string of feature values and their names separated with pipe character.
     */
    public String toString(){
        if (featureList.isEmpty()){
            return "_";
        }
        StringBuilder result = new StringBuilder();
        for (String feature : featureList.keySet()){
            if (result.toString().isEmpty()){
                result = new StringBuilder(feature + "=" + getFeatureValue(feature));
            } else {
                result.append("|").append(feature).append("=").append(getFeatureValue(feature));
            }
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UniversalDependencyTreeBankFeatures)) {
            return false;
        }
        UniversalDependencyTreeBankFeatures features = (UniversalDependencyTreeBankFeatures) obj;
        return this.featureList.equals(features.featureList);
    }

    @Override
    protected UniversalDependencyTreeBankFeatures clone() throws CloneNotSupportedException {
        return new UniversalDependencyTreeBankFeatures("u", this.toString());
    }
}
