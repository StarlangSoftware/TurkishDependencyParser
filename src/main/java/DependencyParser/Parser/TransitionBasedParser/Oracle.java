package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import java.util.ArrayList;

public interface Oracle {
    Decision makeDecision(State state, TransitionSystem transitionSystem);
    ArrayList<Decision> scoreDecisions(State state, TransitionSystem transitionSystem);
}
