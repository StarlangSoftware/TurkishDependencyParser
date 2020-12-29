package DependencyParser.Parser.TransitionBasedParser;/* Created by oguzkeremyildiz on 23.12.2020 */

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Agenda {

    private ConcurrentHashMap<State, Double> agenda;
    private int beamSize;

    public Agenda(int beamSize) throws CloneNotSupportedException {
        agenda = new ConcurrentHashMap<>();
        this.beamSize = beamSize;
    }

    public Set<State> getKeySet() {
        return agenda.keySet();
    }

    public void updateAgenda(ScoringOracle oracle, State current) {
        if (agenda.containsKey(current)) {
            return;
        }
        double point = oracle.score(current);
        if (agenda.size() < beamSize) {
            agenda.put(current, point);
        } else {
            State worst = null;
            double worstValue = Integer.MAX_VALUE;
            for (State key : agenda.keySet()) {
                if (agenda.get(key) < worstValue) {
                    worstValue = agenda.get(key);
                    worst = key;
                }
            }
            if (point > worstValue) {
                agenda.remove(worst);
                agenda.put(current, point);
            }
        }
    }

    public State best() {
        State best = null;
        double bestValue = Integer.MIN_VALUE;
        for (State key : agenda.keySet()) {
            if (agenda.get(key) > bestValue) {
                bestValue = agenda.get(key);
                best = key;
            }
        }
        return best;
    }
}
