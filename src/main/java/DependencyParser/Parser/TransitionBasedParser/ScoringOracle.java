package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 23.12.2020 */

public interface ScoringOracle {
    double score(State state);
}
