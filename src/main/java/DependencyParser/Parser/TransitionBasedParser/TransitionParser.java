package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.*;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Stack;

public class TransitionParser {

    public TransitionParser() {
    }

    private boolean checkForMoreRelation(ArrayList<Word> wordList, int id) {
        for (Word word : wordList) {
            if (((UniversalDependencyTreeBankWord) word).getRelation().to() == id) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Command> simulateParse(UniversalDependencyTreeBankSentence sentence) {
        UniversalDependencyTreeBankWord top, beforeTop;
        UniversalDependencyRelation topRelation, beforeTopRelation;
        ArrayList<Command> commandList = new ArrayList<>();
        ArrayList<Word> wordList = new ArrayList<>();
        Stack<Word> stack = new Stack<>();
        for (int j = 0; j < sentence.wordCount(); j++) {
            wordList.add(sentence.getWord(j));
        }
        stack.add(new UniversalDependencyTreeBankWord(0, "root", "", null, "", null, new UniversalDependencyRelation(-1, ""), "", ""));
        if (wordList.size() > 0) {
            stack.add(wordList.remove(0));
            if (wordList.size() > 1) {
                stack.add(wordList.remove(0));
                commandList.add(Command.SHIFT);
            }
            commandList.add(Command.SHIFT);
            while (wordList.size() > 0 || stack.size() > 1) {
                top = ((UniversalDependencyTreeBankWord) stack.peek());
                topRelation = top.getRelation();
                if (stack.size() > 1) {
                    beforeTop = ((UniversalDependencyTreeBankWord) stack.get(stack.size() - 2));
                    beforeTopRelation = beforeTop.getRelation();
                    if (beforeTop.getId() == topRelation.to() && checkForMoreRelation(wordList, top.getId())) {
                        commandList.add(Command.RIGHTARC);
                        stack.pop();
                    } else if (top.getId() == beforeTopRelation.to()) {
                        commandList.add(Command.LEFTARC);
                        stack.remove(stack.size() - 2);
                    } else {
                        if (wordList.size() > 0) {
                            commandList.add(Command.SHIFT);
                            stack.add(wordList.remove(0));
                        } else {
                            break;
                        }
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

    private UniversalDependencyTreeBankSentence createResultSentence(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence) {
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

    public UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, Oracle oracle) {
        UniversalDependencyTreeBankSentence sentence = createResultSentence(universalDependencyTreeBankSentence);
        ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList = new ArrayList<>();
        for (int i = 0; i < sentence.wordCount(); i++) {
            wordList.add(new AbstractMap.SimpleEntry<>(sentence.getWord(i), i + 1));
        }
        Stack<AbstractMap.SimpleEntry<Word, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<>(new Word("root"), 0));
        while (wordList.size() > 0 || stack.size() > 1) {
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

    public UniversalDependencyTreeBankCorpus dependencyParse(UniversalDependencyTreeBankCorpus universalDependencyTreeBankCorpus, Oracle oracle) {
        UniversalDependencyTreeBankCorpus corpus = new UniversalDependencyTreeBankCorpus();
        for (int i = 0; i < universalDependencyTreeBankCorpus.sentenceCount(); i++) {
            UniversalDependencyTreeBankSentence sentence = (UniversalDependencyTreeBankSentence) universalDependencyTreeBankCorpus.getSentence(i);
            corpus.addSentence(dependencyParse(sentence, oracle));
        }
        return corpus;
    }
}
