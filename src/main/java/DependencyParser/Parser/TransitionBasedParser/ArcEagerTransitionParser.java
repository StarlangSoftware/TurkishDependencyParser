package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 14.12.2020 */

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
    public ArrayList<Command> simulateParse(UniversalDependencyTreeBankSentence sentence) {
        UniversalDependencyTreeBankWord top, first;
        UniversalDependencyRelation topRelation, firstRelation;
        ArrayList<Command> commandList = new ArrayList<>();
        ArrayList<Word> wordList = new ArrayList<>();
        Stack<Word> stack = new Stack<>();
        for (int j = 0; j < sentence.wordCount(); j++) {
            wordList.add(sentence.getWord(j));
        }
        stack.add(new UniversalDependencyTreeBankWord(0, "root", "", null, "", null, new UniversalDependencyRelation(-1, ""), "", ""));
        if (wordList.size() > 0) {
            stack.add(wordList.remove(0));
            commandList.add(Command.SHIFT);
            if (wordList.size() > 1) {
                stack.add(wordList.remove(0));
                commandList.add(Command.SHIFT);
            }
            while (wordList.size() > 0 || stack.size() > 1) {
                if (!wordList.isEmpty()) {
                    first = ((UniversalDependencyTreeBankWord) wordList.get(0));
                    firstRelation = first.getRelation();
                } else {
                    first = null;
                    firstRelation = null;
                }
                top = ((UniversalDependencyTreeBankWord) stack.peek());
                topRelation = top.getRelation();
                if (stack.size() > 1) {
                    if (firstRelation != null && firstRelation.to() == top.getId()) {
                        commandList.add(Command.RIGHTARC);
                        stack.add(wordList.remove(0));
                    } else if (first != null && topRelation.to() == first.getId()) {
                        commandList.add(Command.LEFTARC);
                        stack.pop();
                    } else if (wordList.size() > 0) {
                        commandList.add(Command.SHIFT);
                        stack.add(wordList.remove(0));
                    } else {
                        commandList.add(Command.REDUCE);
                        stack.pop();
                    }
                } else {
                    if (wordList.size() > 0) {
                        commandList.add(Command.SHIFT);
                        stack.add(wordList.remove(0));
                    } else {
                        break;
                    }
                }
            }
        }
        return commandList;
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
            Decision decision = oracle.makeDecision(stack, wordList, TransitionSystem.ARC_EAGER);
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
