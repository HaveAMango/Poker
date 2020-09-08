package poker.combination;

import poker.Value;

public class TwoGroupsCombinationResult extends CombinationResult {

    private Value value1;
    private Value value2;

    public TwoGroupsCombinationResult(Combination combination, Value value1, Value value2) {
        super(value1 != Value.NONE && value2 != Value.NONE, combination);
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int compareTo(CombinationResult o) {
        int priorityDelta = super.compareTo(o);
        if (priorityDelta != 0) {
            return priorityDelta;
        }

        if (o instanceof TwoGroupsCombinationResult) {
            TwoGroupsCombinationResult other = (TwoGroupsCombinationResult) o;
            int delta1 = value1.compareTo(other.value1);
            if (delta1 != 0) {
                return delta1;
            }

            return value2.compareTo(other.value2);
        }

        throw new RuntimeException("Should not be here");
    }

    @Override
    public String toString() {
        if (value1 == Value.NONE || value2 == Value.NONE) {
            return "NoCombination";
        }
        return combination.name() + " of " + value1.getSymbol() + " & " + value2.getSymbol();
    }
}
