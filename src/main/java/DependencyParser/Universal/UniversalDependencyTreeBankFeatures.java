package DependencyParser.Universal;

import java.util.HashMap;

public class UniversalDependencyTreeBankFeatures {

    private HashMap<String, String> featureList;

    private static final String[] universalFeatureTypes =
            {"PronType", "NumType", "Poss", "Reflex", "Foreign",
            "Abbr", "Typo", "Gender", "Animacy", "NounClass",
            "Number", "Case", "Definite", "Degree", "VerbForm",
            "Mood", "Tense", "Aspect", "Voice", "Evident",
            "Polarity", "Person", "Polite", "Clusivity"};

    private static final String universalFeatureValues[][] = {
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
            {"Ex", "In"}
    };

    private static final String turkishFeatureValues[][] = {
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
            {}
    };

    private static final String englishFeatureValues[][] = {
            {"Art", "Dem",	"Emp", "Ind", "Int", "Neg", "Prs", "Rcp", "Rel", "Tot"},
            {"Card", "Frac", "Mult", "Ord"},
            {"Yes"},
            {},
            {},

            {},
            {},
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

            {},
            {"1", "2", "3"},
            {},
            {}
    };

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

    public String getFeatureValue(String feature){
        return featureList.get(feature);
    }

    public boolean featureExists(String feature){
        return featureList.containsKey(feature);
    }

    public String toString(){
        if (featureList.isEmpty()){
            return "_";
        }
        String result = "";
        for (String feature : featureList.keySet()){
            if (result.equals("")){
                result = feature + "=" + getFeatureValue(feature);
            } else {
                result += "|" + feature + "=" + getFeatureValue(feature);
            }
        }
        return result;
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
