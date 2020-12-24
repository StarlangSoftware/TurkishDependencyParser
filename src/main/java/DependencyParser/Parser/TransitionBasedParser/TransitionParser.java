package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import Classification.DataSet.DataSet;
import Classification.Instance.Instance;
import DependencyParser.Universal.*;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Stack;

public abstract class TransitionParser {

    public TransitionParser() {
    }

    protected UniversalDependencyTreeBankSentence createResultSentence(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence) {
        UniversalDependencyTreeBankSentence sentence = new UniversalDependencyTreeBankSentence();
        for (int i = 0; i < universalDependencyTreeBankSentence.wordCount(); i++) {
            UniversalDependencyTreeBankWord word = (UniversalDependencyTreeBankWord) universalDependencyTreeBankSentence.getWord(i);
            sentence.addWord(new UniversalDependencyTreeBankWord(word.getId(), word.getName(), word.getLemma(), word.getUpos(), word.getXpos(), word.getFeatures(), null, word.getDeps(), word.getMisc()));
        }
        return sentence;
    }

    public DataSet simulateParse(UniversalDependencyTreeBankCorpus corpus, int windowSize) {
        DataSet dataSet = new DataSet();
        for (int i = 0; i < corpus.sentenceCount(); i++) {
            dataSet.addInstanceList(simulateParse((UniversalDependencyTreeBankSentence) corpus.getSentence(i), windowSize));
        }
        return dataSet;
    }

    public abstract ArrayList<Instance> simulateParse(UniversalDependencyTreeBankSentence sentence, int windowSize);

    public abstract UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, Oracle oracle);

    private boolean checkStates(Agenda agenda) {
        for (State state : agenda.getKeySet()) {
            if (state.wordListSize() > 0 || state.stackSize() > 1) {
                return true;
            }
        }
        return false;
    }

    protected State initialState(UniversalDependencyTreeBankSentence sentence) {
        ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList = new ArrayList<>();
        for (int i = 0; i < sentence.wordCount(); i++) {
            wordList.add(new AbstractMap.SimpleEntry<>(sentence.getWord(i), i + 1));
        }
        Stack<AbstractMap.SimpleEntry<Word, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<>(new Word("root"), 0));
        return new State(stack, wordList, new ArrayList<>());
    }

    private ArrayList<AbstractMap.SimpleEntry<Command, UniversalDependencyType>> constructCandidates(TransitionSystem transitionSystem) {
        ArrayList<AbstractMap.SimpleEntry<Command, UniversalDependencyType>> subsets = new ArrayList<>();
        subsets.add(new AbstractMap.SimpleEntry<>(Command.SHIFT, UniversalDependencyType.DEP));
        if (transitionSystem == TransitionSystem.ARC_EAGER) {
            subsets.add(new AbstractMap.SimpleEntry<>(Command.REDUCE, UniversalDependencyType.DEP));
        }
        for (int i = 0; i < UniversalDependencyRelation.universalDependencyTypes.length; i++) {
            UniversalDependencyType type = UniversalDependencyRelation.getDependencyTag(UniversalDependencyRelation.universalDependencyTypes[i]);
            subsets.add(new AbstractMap.SimpleEntry<>(Command.LEFTARC, type));
            subsets.add(new AbstractMap.SimpleEntry<>(Command.RIGHTARC, type));
        }
        return subsets;
    }

    public State dependencyParse(ScoringOracle oracle, int beamSize, UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, TransitionSystem transitionSystem) throws CloneNotSupportedException {
        UniversalDependencyTreeBankSentence sentence = createResultSentence(universalDependencyTreeBankSentence);
        State initialState = initialState(sentence);
        Agenda agenda = new Agenda(beamSize);
        agenda.updateAgenda(oracle, (State) initialState.clone());
        while (checkStates(agenda)) {
            for (State state : agenda.getKeySet()) {
                State oldState = (State) state.clone();
                ArrayList<AbstractMap.SimpleEntry<Command, UniversalDependencyType>> subsets = constructCandidates(transitionSystem);
                for (AbstractMap.SimpleEntry<Command, UniversalDependencyType> subset : subsets) {
                    Command command = subset.getKey();
                    UniversalDependencyType type = subset.getValue();
                    state.apply(command, type, transitionSystem);
                    agenda.updateAgenda(oracle, (State) state.clone());
                    state = oldState;
                }
            }
        }
        return agenda.best();
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
