package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.UniversalDependencyType;
import Dictionary.Word;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RandomOracle implements Oracle {
    @Override
    public Decision makeDecision(State state, TransitionSystem transitionSystem) {
        Random random = new Random();
        int command = 4;
        switch (transitionSystem){
            case ARC_EAGER:
                command = random.nextInt(4);
                break;
            case ARC_STANDARD:
                command = random.nextInt(3);
                break;
        }
        int relation = random.nextInt(UniversalDependencyType.values().length);
        switch (command) {
            case 0:
                return new Decision(Command.LEFTARC, UniversalDependencyType.values()[relation], 0);
            case 1:
                return new Decision(Command.RIGHTARC, UniversalDependencyType.values()[relation], 0);
            case 2:
                return new Decision(Command.SHIFT, UniversalDependencyType.DEP, 0);
            case 3:
                return new Decision(Command.REDUCE, UniversalDependencyType.DEP, 0);
        }
        return null;
    }

    @Override
    public ArrayList<Decision> scoreDecisions(State state, TransitionSystem transitionSystem) {
        return null;
    }
}
