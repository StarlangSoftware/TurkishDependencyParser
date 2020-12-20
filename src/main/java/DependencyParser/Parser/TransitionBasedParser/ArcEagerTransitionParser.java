package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 14.12.2020 */

import Classification.Instance.Instance;
import DependencyParser.Universal.UniversalDependencyRelation;
import DependencyParser.Universal.UniversalDependencyTreeBankSentence;
import DependencyParser.Universal.UniversalDependencyTreeBankWord;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Stack;

public class ArcEagerTransitionParser extends TransitionParser {

    public ArcEagerTransitionParser() {
        super();
    }

    @Override
    public ArrayList<Instance> simulateParse(UniversalDependencyTreeBankSentence sentence, int windowSize) {
        UniversalDependencyTreeBankWord top, first;
        UniversalDependencyRelation topRelation, firstRelation;
        InstanceGenerator instanceGenerator = new SimpleInstanceGenerator();
        ArrayList<Instance> instanceList = new ArrayList<>();
        ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList = new ArrayList<>();
        Stack<AbstractMap.SimpleEntry<Word, Integer>> stack = new Stack<>();
        for (int j = 0; j < sentence.wordCount(); j++) {
            wordList.add(new AbstractMap.SimpleEntry<>(sentence.getWord(j), j + 1));
        }
        stack.add(new AbstractMap.SimpleEntry<>(new UniversalDependencyTreeBankWord(0, "root", "", null, "", null, new UniversalDependencyRelation(-1, ""), "", ""), 0));
        State state = new State(stack, wordList, new ArrayList<>());
        if (wordList.size() > 0) {
            instanceList.add(instanceGenerator.generate(state, windowSize, "Shift"));
            stack.add(wordList.remove(0));
            if (wordList.size() > 1) {
                instanceList.add(instanceGenerator.generate(state, windowSize, "Shift"));
                stack.add(wordList.remove(0));
            }
            while (wordList.size() > 0 || stack.size() > 1) {
                if (!wordList.isEmpty()) {
                    first = ((UniversalDependencyTreeBankWord) wordList.get(0).getKey());
                    firstRelation = first.getRelation();
                } else {
                    first = null;
                    firstRelation = null;
                }
                top = ((UniversalDependencyTreeBankWord) stack.peek().getKey());
                topRelation = top.getRelation();
                if (stack.size() > 1) {
                    if (firstRelation != null && firstRelation.to() == top.getId()) {
                        instanceList.add(instanceGenerator.generate(state, windowSize, "RightArc(" + firstRelation.toString() + ")"));
                        stack.add(wordList.remove(0));
                    } else if (first != null && topRelation.to() == first.getId()) {
                        instanceList.add(instanceGenerator.generate(state, windowSize, "LeftArc(" + topRelation.toString() + ")"));
                        stack.pop();
                    } else if (wordList.size() > 0) {
                        instanceList.add(instanceGenerator.generate(state, windowSize, "Shift"));
                        stack.add(wordList.remove(0));
                    } else {
                        instanceList.add(instanceGenerator.generate(state, windowSize, "Reduce"));
                        stack.pop();
                    }
                } else {
                    if (wordList.size() > 0) {
                        instanceList.add(instanceGenerator.generate(state, windowSize, "Shift"));
                        stack.add(wordList.remove(0));
                    } else {
                        break;
                    }
                }
            }
        }
        return instanceList;
    }

    @Override
    public UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, Oracle oracle) {
        UniversalDependencyTreeBankSentence sentence = createResultSentence(universalDependencyTreeBankSentence);
        ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList = new ArrayList<>();
        for (int i = 0; i < sentence.wordCount(); i++) {
            wordList.add(new AbstractMap.SimpleEntry<>(sentence.getWord(i), i + 1));
        }
        Stack<AbstractMap.SimpleEntry<Word, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<>(new Word("root"), 0));
        State state = new State(stack, wordList, new ArrayList<>());
        while (wordList.size() > 0 || stack.size() > 1) {
            Decision decision = oracle.makeDecision(state, TransitionSystem.ARC_EAGER);
            switch (decision.getCommand()) {
                case SHIFT:
                    state.applyShift();
                    break;
                case LEFTARC:
                    state.applyArcEagerLeftArc(decision.getRelation());
                    break;
                case RIGHTARC:
                    state.applyArcEagerRightArc(decision.getRelation());
                    break;
                case REDUCE:
                    state.reduce();
                    break;
                default:
                    break;
            }
        }
        return sentence;
    }
}
