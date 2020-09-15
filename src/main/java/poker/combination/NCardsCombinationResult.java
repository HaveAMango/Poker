package poker.combination;

import poker.Card;
import poker.Value;

import java.util.List;

public class NCardsCombinationResult extends CombinationResult {

    private Value value;

    public NCardsCombinationResult(Combination combination, Value value, List<Card> kickers) {
        super(value != Value.NONE, combination, kickers);
        this.value = value;
    }

    @Override
    public int compareTo(CombinationResult o) {
        int priorityDelta = super.compareTo(o);
        if (priorityDelta != 0) {
            return priorityDelta;
        }

        NCardsCombinationResult other = (NCardsCombinationResult) o;
        int valueDelta = value.compareTo(other.value);
        if (valueDelta != 0) {
            return valueDelta;
        }

        return compareByKickers(o);
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == Value.NONE) {
            return "NoCombination";
        }
        return combination.name() + " of " + value.getSymbol() + " (Kickers: " + kickers + ")";
    }
}
