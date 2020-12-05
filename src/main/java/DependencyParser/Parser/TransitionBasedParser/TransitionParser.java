package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.*;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Stack;

public class TransitionParser {

    public TransitionParser() {
    }

    public UniversalDependencyTreeBankCorpus parse(UniversalDependencyTreeBankCorpus universalDependencyTreeBankCorpus) {
        return null;
    }

    public UniversalDependencyTreeBankSentence setList(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence) {
        UniversalDependencyTreeBankSentence sentence = new UniversalDependencyTreeBankSentence();
        for (int i = 0; i < universalDependencyTreeBankSentence.wordCount(); i++) {
            UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) universalDependencyTreeBankSentence.getWord(i);
            sentence.addWord(new UniversalDependencyTreeBankWord(word.getId(), word.getName(), word.getLemma(), word.getUpos(), word.getXpos(), word.getFeatures(), null, word.getDeps(), word.getMisc()));
        }
        return sentence;
    }

    private void applyShift(Stack<AbstractMap.SimpleEntry<Word, Integer>> stack, ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList) {
        if (wordList.size() > 0) {
            stack.add(wordList.remove(0));
        }
    }

    private void applyLeftArc(Stack<AbstractMap.SimpleEntry<Word, Integer>> stack, UniversalDependencyType type) {
        if (stack.size() > 1) {
            UniversalDependencyTreeBankWord beforeLast = (UniversalDependencyTreeBankWord) stack.get(stack.size() - 2).getKey();
            int index = stack.get(stack.size() - 1).getValue();
            beforeLast.setRelation(new UniversalDependencyRelation(index, type.toString()));
            stack.remove(stack.size() - 2);
        }
    }

    private void applyRightArc(Stack<AbstractMap.SimpleEntry<Word, Integer>> stack, UniversalDependencyType type) {
        if (stack.size() > 1) {
            UniversalDependencyTreeBankWord last = (UniversalDependencyTreeBankWord) stack.get(stack.size() - 1).getKey();
            int index = stack.get(stack.size() - 2).getValue();
            last.setRelation(new UniversalDependencyRelation(index, type.toString()));
            stack.pop();
        }
    }

    public UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence) {
        UniversalDependencyTreeBankSentence sentence = setList(universalDependencyTreeBankSentence);
        ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList = new ArrayList<>();
        for (int i = 0; i < sentence.wordCount(); i++) {
            wordList.add(new AbstractMap.SimpleEntry<>(sentence.getWord(i), i + 1));
        }
        Stack<AbstractMap.SimpleEntry<Word, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<>(new Word("root"), -1));
        Oracle oracle = new RandomDecision();
        while (wordList.size() == 0 && stack.size() == 0) {
            Decision decision = oracle.makeDecision(stack, wordList);
            switch (decision.getCommand()) {
                case SHIFT:
                    applyShift(stack, wordList);
                    break;
                case LEFTARC:
                    applyLeftArc(stack, decision.getRelation());
                    break;
                case RIGHTARC:
                    applyRightArc(stack, decision.getRelation());
                    break;
                default:
                    break;
            }
        }
        return sentence;
    }
}
