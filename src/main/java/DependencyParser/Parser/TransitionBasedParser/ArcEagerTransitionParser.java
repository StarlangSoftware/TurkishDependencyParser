package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 14.12.2020 */

import DependencyParser.Universal.UniversalDependencyTreeBankSentence;

import java.util.ArrayList;

public class ArcEagerTransitionParser extends TransitionParser {

    public ArcEagerTransitionParser() {
        super();
    }

    @Override
    public ArrayList<Command> simulateParse(UniversalDependencyTreeBankSentence sentence) {
        return null;
    }

    @Override
    public UniversalDependencyTreeBankSentence dependencyParse(UniversalDependencyTreeBankSentence universalDependencyTreeBankSentence, Oracle oracle) {
        return null;
    }
}
