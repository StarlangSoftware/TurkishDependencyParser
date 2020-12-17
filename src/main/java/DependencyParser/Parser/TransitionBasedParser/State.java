package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 14.12.2020 */

import DependencyParser.Universal.UniversalDependencyRelation;
import DependencyParser.Universal.UniversalDependencyTreeBankWord;
import DependencyParser.Universal.UniversalDependencyType;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Stack;

public class State {

    private Stack<AbstractMap.SimpleEntry<Word, Integer>> stack;
    private ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList;
    private ArrayList<AbstractMap.SimpleEntry<Word, UniversalDependencyRelation>> relations;

    public State(Stack<AbstractMap.SimpleEntry<Word, Integer>> stack, ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList, ArrayList<AbstractMap.SimpleEntry<Word, UniversalDependencyRelation>> relations) {
        this.stack = stack;
        this.wordList = wordList;
        this.relations = relations;
    }

    public void applyShift() {
        if (wordList.size() > 0) {
            stack.add(wordList.remove(0));
        }
    }

    public void applyLeftArc(UniversalDependencyType type) {
        if (stack.size() > 1) {
            UniversalDependencyTreeBankWord beforeLast = (UniversalDependencyTreeBankWord) stack.get(stack.size() - 2).getKey();
            int index = stack.get(stack.size() - 1).getValue();
            beforeLast.setRelation(new UniversalDependencyRelation(index, type.toString()));
            stack.remove(stack.size() - 2);
            relations.add(new AbstractMap.SimpleEntry<>(beforeLast, new UniversalDependencyRelation(index, type.toString())));
        }
    }

    public void applyRightArc(UniversalDependencyType type) {
        if (stack.size() > 1) {
            UniversalDependencyTreeBankWord last = (UniversalDependencyTreeBankWord) stack.get(stack.size() - 1).getKey();
            int index = stack.get(stack.size() - 2).getValue();
            last.setRelation(new UniversalDependencyRelation(index, type.toString()));
            stack.pop();
            relations.add(new AbstractMap.SimpleEntry<>(last, new UniversalDependencyRelation(index, type.toString())));
        }
    }

    public void applyArcEagerLeftArc(UniversalDependencyType type) {
        if (stack.size() > 0 && wordList.size() > 0) {
            UniversalDependencyTreeBankWord lastElementOfStack = (UniversalDependencyTreeBankWord) stack.peek().getKey();
            int index = wordList.get(0).getValue();
            lastElementOfStack.setRelation(new UniversalDependencyRelation(index, type.toString()));
            stack.pop();
            relations.add(new AbstractMap.SimpleEntry<>(lastElementOfStack, new UniversalDependencyRelation(index, type.toString())));
        }
    }

    public void applyArcEagerRightArc(UniversalDependencyType type) {
        if (stack.size() > 0 && wordList.size() > 0) {
            UniversalDependencyTreeBankWord firstElementOfWordList = (UniversalDependencyTreeBankWord) wordList.get(0).getKey();
            int index = stack.peek().getValue();
            firstElementOfWordList.setRelation(new UniversalDependencyRelation(index, type.toString()));
            applyShift();
            relations.add(new AbstractMap.SimpleEntry<>(firstElementOfWordList, new UniversalDependencyRelation(index, type.toString())));
        }
    }

    public void reduce() {
        if (stack.size() > 0) {
            stack.pop();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        State o = new State(new Stack<>(), new ArrayList<>(), new ArrayList<>());
        for (AbstractMap.SimpleEntry<Word, Integer> element : stack) {
            o.stack.add(new AbstractMap.SimpleEntry<>(element.getKey().clone(), element.getValue()));
        }
        for (AbstractMap.SimpleEntry<Word, Integer> word : wordList) {
            o.wordList.add(new AbstractMap.SimpleEntry<>(word.getKey().clone(), word.getValue()));
        }
        for (AbstractMap.SimpleEntry<Word, UniversalDependencyRelation> relation : relations) {
            o.relations.add(new AbstractMap.SimpleEntry<>(relation.getKey().clone(), relation.getValue()));
        }
        return o;
    }
}
