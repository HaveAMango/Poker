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
    public String toString() {
        if (value1 == Value.NONE || value2 == Value.NONE) {
            return "NoCombination";
        }
        return combination.name() + " of " + value1.getSymbol() + " & " + value2.getSymbol();
    }
}
