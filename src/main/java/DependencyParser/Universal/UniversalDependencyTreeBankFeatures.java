package DependencyParser.Universal;

import java.util.HashMap;

public class UniversalDependencyTreeBankFeatures {

    private HashMap<String, String> featureList;

    public UniversalDependencyTreeBankFeatures(String features){
        featureList = new HashMap<>();
        if (!features.equals("_")){
            String[] list = features.split("\\|");
            for (String feature : list){
                if (feature.contains("=")){
                    String featureName = feature.substring(0, feature.indexOf("=")).trim();
                    String featureValue = feature.substring(feature.indexOf("=") + 1).trim();
                    featureList.put(featureName, featureValue);
                } else {
                    System.out.println("Feature does not contain = ->" + features);
                }
            }
        }
    }

    public String getFeatureValue(String feature){
        return featureList.get(feature);
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
        return new UniversalDependencyTreeBankFeatures(this.toString());
    }
}
