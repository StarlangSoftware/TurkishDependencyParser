package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 17.12.2020 */

import Classification.Attribute.Attribute;
import Classification.Attribute.DiscreteAttribute;
import Classification.Instance.Instance;
import DependencyParser.Universal.UniversalDependencyTreeBankWord;

import java.util.ArrayList;

public class SimpleInstanceGenerator implements InstanceGenerator {

    public SimpleInstanceGenerator() {
    }

    @Override
    public Instance generate(State state, int windowSize, String command) {
        Instance instance = new Instance(command);
        ArrayList<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < windowSize; i++) {
            UniversalDependencyTreeBankWord word = ((UniversalDependencyTreeBankWord) state.getStackWord(i));
            if (word == null) {
                attributes.add(new DiscreteAttribute("null"));
            } else {
                if (word.getName().equals("root")) {
                    attributes.add(new DiscreteAttribute("root"));
                } else {
                    attributes.add(new DiscreteAttribute(word.getUpos().toString()));
                }
            }
        }
        for (int i = 0; i < windowSize; i++) {
            UniversalDependencyTreeBankWord word = ((UniversalDependencyTreeBankWord) state.getWordListWord(i));
            if (word != null) {
                attributes.add(new DiscreteAttribute(word.getUpos().toString()));
            } else {
                attributes.add(new DiscreteAttribute("null"));
            }
        }
        for (Attribute attribute : attributes) {
            instance.addAttribute(attribute);
        }
        return instance;
    }
}