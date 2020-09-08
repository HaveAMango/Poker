package poker.combination;

import poker.Value;

public class NCardsCombinationResult extends CombinationResult {

    private Value value;

    public NCardsCombinationResult(Combination combination, Value value) {
        super(value != Value.NONE, combination);
        this.value = value;
    }

    @Override
    public int compareTo(CombinationResult o) {
        int priorityDelta = super.compareTo(o);
        if (priorityDelta != 0) {
            return priorityDelta;
        }

        if (o instanceof NCardsCombinationResult) {
            return value.getValue() - ((NCardsCombinationResult) o).value.getValue();
        }

        throw new RuntimeException("Should not be here");
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == Value.NONE) {
            return "NoCombination";
        }
        return combination.name() + " of " + value.getSymbol();
    }
}
