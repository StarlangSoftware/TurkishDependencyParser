package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 5.12.2020 */

import DependencyParser.Universal.UniversalDependencyType;

public class Decision {

    private Command command;
    private UniversalDependencyType relation;
    private double point;

    public Decision(Command command, UniversalDependencyType relation, double point) {
        this.command = command;
        this.relation = relation;
        this.point = point;
    }

    public Command getCommand() {
        return command;
    }

    public UniversalDependencyType getRelation() {
        return relation;
    }

    public double getPoint() {
        return point;
    }
}
