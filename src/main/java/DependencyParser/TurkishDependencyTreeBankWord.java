package DependencyParser;

import Dictionary.Word;
import MorphologicalAnalysis.MorphologicalParse;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class TurkishDependencyTreeBankWord extends Word{

    private MorphologicalParse parse;
    private ArrayList<MorphologicalParse> originalParses;
    private TurkishDependencyRelation relation = null;

    public TurkishDependencyTreeBankWord(Node wordNode){
        super();
        NamedNodeMap attributes;
        String IG, relationName, dependencyType;
        int i, index, toWord = 0, toIG = 0;
        originalParses = new ArrayList<MorphologicalParse>();
        if (wordNode.hasAttributes()){
            if (wordNode.getFirstChild().getNodeValue() != null){
                name = wordNode.getFirstChild().getNodeValue();
            } else {
                System.out.println("Word data does not exist\n");
            }
            attributes = wordNode.getAttributes();
            if (attributes.getNamedItem("IG") != null){
                IG = attributes.getNamedItem("IG").getNodeValue();
                parse = new MorphologicalParse(splitIntoInflectionalGroups(IG));
            } else {
                System.out.println("No IG defined for the word " + wordNode.getFirstChild().getNodeValue() + "\n");
            }
            if (attributes.getNamedItem("REL") != null){
                relationName = attributes.getNamedItem("REL").getNodeValue();
                if (!relationName.equals("[,( )]")){
                    String[] relationParts = relationName.split("[\\[\\(\\)\\],]");
                    index = 0;
                    for (i = 0; i < relationParts.length; i++){
                        if (relationParts[i].length() != 0){
                            index++;
                            switch (index){
                                case 1:toWord = Integer.parseInt(relationParts[i]);
                                    break;
                                case 2:toIG = Integer.parseInt(relationParts[i]);
                                    break;
                                case 3:dependencyType = relationParts[i];
                                    relation = new TurkishDependencyRelation(toWord - 1, toIG - 1, dependencyType);
                                    break;
                            }
                        }
                    }
                }
            } else {
                System.out.println("No REL defined for the word " + wordNode.getFirstChild().getNodeValue() + "\n");
            }
            for (i = 1; i <= 9; i++){
                if (attributes.getNamedItem("ORG_IG" + i) != null){
                    IG = attributes.getNamedItem("ORG_IG" + i).getNodeValue();
                    if (i == 1){
                        originalParses.add(new MorphologicalParse(splitIntoInflectionalGroups(IG)));
                    }
                } else {
                    break;
                }
            }
        } else {
            System.out.println("No attributes defined for the word\n");
        }
    }

    private ArrayList<String> splitIntoInflectionalGroups(String IG){
        ArrayList<String> inflectionalGroups = new ArrayList<String>();
        IG = IG.replaceAll("\\(\\+Punc", "@").replaceAll("\\)\\+Punc", "\\$");
        String[] iGs = IG.split("[\\[\\(\\)\\]]");
        for (int i = 0; i < iGs.length; i++){
            iGs[i] = iGs[i].replaceAll("@", "\\(\\+Punc").replaceAll("\\$", "\\)\\+Punc");
            if (iGs[i].length() != 0){
                inflectionalGroups.add(iGs[i]);
            }
        }
        return inflectionalGroups;
    }

    public MorphologicalParse getParse(){
        return parse;
    }

    public MorphologicalParse getOriginalParse(int index){
        if (index < originalParses.size()){
            return originalParses.get(index);
        } else {
            return null;
        }
    }

    public int size(){
        return originalParses.size();
    }

    public TurkishDependencyRelation getRelation(){
        return relation;
    }

}
