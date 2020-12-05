package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.UniversalDependencyType;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RandomDecision implements Oracle {
    @Override
    public Decision makeDecision(Stack<AbstractMap.SimpleEntry<Word, Integer>> stack, ArrayList<AbstractMap.SimpleEntry<Word, Integer>> wordList) {
        Random random = new Random();
        int decision = random.nextInt(3);
        switch (decision) {
            case 0:
                return new Decision(Command.LEFTARC, UniversalDependencyType.ACL);
            case 1:
                return new Decision(Command.RIGHTARC, UniversalDependencyType.ACL);
            case 2:
                return new Decision(Command.SHIFT, UniversalDependencyType.ACL);
        }
        return null;
    }
}
