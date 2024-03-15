package DependencyParser.Turkish;

import Dictionary.Word;
import MorphologicalAnalysis.MorphologicalParse;
import Xml.XmlElement;

import java.util.ArrayList;

public class TurkishDependencyTreeBankWord extends Word{

    private MorphologicalParse parse;
    private final ArrayList<MorphologicalParse> originalParses;
    private TurkishDependencyRelation relation = null;

    /**
     * Given the parsed xml node which contains information about a word and related attributes including the
     * dependencies, the method constructs a {@link TurkishDependencyTreeBankWord} from it.
     * @param wordNode Xml parsed node containing information about a word.
     */
    public TurkishDependencyTreeBankWord(XmlElement wordNode){
        super();
        String IG, relationName, dependencyType;
        int i, index, toWord = 0, toIG = 0;
        originalParses = new ArrayList<>();
        if (wordNode.hasAttributes()){
            if (!wordNode.getPcData().isEmpty()){
                name = wordNode.getPcData();
            } else {
                System.out.println("Word data does not exist\n");
            }
            if (!wordNode.getAttributeValue("IG").isEmpty()){
                IG = wordNode.getAttributeValue("IG");
                parse = new MorphologicalParse(splitIntoInflectionalGroups(IG));
            } else {
                System.out.println("No IG defined for the word " + wordNode.getPcData() + "\n");
            }
            if (!wordNode.getAttributeValue("REL").isEmpty()){
                relationName = wordNode.getAttributeValue("REL");
                if (!relationName.equals("[,( )]")){
                    String[] relationParts = relationName.split("[\\[()\\],]");
                    index = 0;
                    for (i = 0; i < relationParts.length; i++){
                        if (!relationParts[i].isEmpty()){
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
                System.out.println("No REL defined for the word " + wordNode.getPcData() + "\n");
            }
            for (i = 1; i <= 9; i++){
                if (!wordNode.getAttributeValue("ORG_IG" + i).isEmpty()){
                    IG = wordNode.getAttributeValue("ORG_IG" + i);
                    originalParses.add(new MorphologicalParse(splitIntoInflectionalGroups(IG)));
                } else {
                    break;
                }
            }
        } else {
            System.out.println("No attributes defined for the word\n");
        }
    }

    /**
     * Given the morphological parse of a word, this method splits it into inflectional groups.
     * @param IG Morphological parse of the word in string form.
     * @return An array of inflectional groups stored as strings.
     */
    private ArrayList<String> splitIntoInflectionalGroups(String IG){
        ArrayList<String> inflectionalGroups = new ArrayList<>();
        IG = IG.replaceAll("\\(\\+Punc", "@").replaceAll("\\)\\+Punc", "\\$");
        String[] iGs = IG.split("[\\[()\\]]");
        for (int i = 0; i < iGs.length; i++){
            iGs[i] = iGs[i].replaceAll("@", "(+Punc").replaceAll("\\$", ")+Punc");
            if (!iGs[i].isEmpty()){
                inflectionalGroups.add(iGs[i]);
            }
        }
        return inflectionalGroups;
    }

    /**
     * Accessor for the parse attribute
     * @return Parse attribute
     */
    public MorphologicalParse getParse(){
        return parse;
    }

    /**
     * Accessor for a specific parse.
     * @param index Index of the word.
     * @return Parse of the word with index
     */
    public MorphologicalParse getOriginalParse(int index){
        if (index < originalParses.size()){
            return originalParses.get(index);
        } else {
            return null;
        }
    }

    /**
     * Number of words in this item.
     * @return Number of words in this item.
     */
    public int size(){
        return originalParses.size();
    }

    /**
     * Accessor for the relation attribute.
     * @return relation attribute.
     */
    public TurkishDependencyRelation getRelation(){
        return relation;
    }

}
