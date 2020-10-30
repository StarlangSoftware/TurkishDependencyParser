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
                    System.out.println("Fature does not contain = ->" + features);
                }
            }
        }
    }

    public String getFeatureValue(String feature){
        return featureList.get(feature);
    }
}
