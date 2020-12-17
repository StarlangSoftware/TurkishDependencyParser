package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 17.12.2020 */

import Classification.Instance.Instance;

public interface InstanceGenerator {
    Instance generate(State state, int windowSize, String command);
}