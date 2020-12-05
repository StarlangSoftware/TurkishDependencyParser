package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.UniversalDependencyType;

public class Decision {

    private Command command;
    private UniversalDependencyType relation;

    public Decision(Command command, UniversalDependencyType relation) {
        this.command = command;
        this.relation = relation;
    }

    public Command getCommand() {
        return command;
    }

    public UniversalDependencyType getRelation() {
        return relation;
    }
}
